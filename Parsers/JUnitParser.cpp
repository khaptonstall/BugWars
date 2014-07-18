/*
 * JUnitParser.cpp
 *
 *  Created on: Jun 27, 2014
 *      Author: Kyle Haptonstall
 *      Description: JUnit Parser was created to work with JUnit test
 *      	cases that come as a result of the Android GUI Ripper/Crawler.
 *      	JUnitParser.cpp goes through these JUnit test cases and replaces
 *      	a method "fireEvent," that often crashed the test, with a Robotium method.
 *
 *      	Using JUnitParser: Make sure that the JUnit file you are parsing is
 *      		in the same workspace folder as JUnitParser.cpp. Replace the name
 *      		of both the infile and outfile as commented below. Build and run.
 *
 *      Formatting of list file:
 *      	first line: path of the junit test suite files
 *      		ex: C:/Users/Username/workspace/AppTests/
 *      		(include last slash)
 *      	each line after: name of a junit test file located in that path
 *      		ex: Wordpress_v2_4.java
 *      		(include extension)
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>

#include "found.h"
#include "hasonlyspaces.h"

using namespace std;

int jparse(bool multiple);
void parser(string fileName);
string classNameFix(string inputText);
string fireEventFix(string inputText);

int orientationCount;
string fullPath;
string NAME_FORMAT = "WP_2_"; //format of junit file names

string listFileName;
string outputListName;

/* Sets listFileName and outputListName variables
 * @param string name of txt file containing list of JUnit files to parse
 * @return string name of txt file containing list of parsed JUnit file names
 */
string setJListFile(string fileName) {
	listFileName = fileName;
	outputListName = fileName.substr(0, fileName.find(".")) + "_p.txt";
	return outputListName;
}

/* Sets fullPath variable
 * @param string path/file name of the java file to parse
 */
void setPath(string filePath) {
	fullPath = filePath;
}

int jparse(bool multiple) {
	if (!multiple) {
		parser(fullPath);
	}

	if (multiple) {
		ifstream listFile;
		listFile.open(listFileName.c_str());
		ofstream outListFile;
		outListFile.open(outputListName.c_str());

		if(listFile.is_open()){
			string line;
			getline(listFile, line);
			while (has_only_spaces(line)) {
				getline(listFile, line);
			}
			string path = line;	//set path of JUnit test suites
			outListFile << line << endl;
			//parse each file listed in fileList.txt:
			while(getline(listFile, line)){
				if (!has_only_spaces(line)) {
					string filePath = path + line;
					parser(filePath);
					string pName = line.erase(0, line.find_last_of("/") + 1);
					pName = pName.substr(0, pName.find(".")) + "_p.java";
					outListFile << pName << endl;
				}
			}
		} else {
			cout << "Unable to open txt file containing list of JUnit files to parse." << endl;
			cout << "Failed file's name: " << listFileName << endl;
		}
	}
	cout << "Finished JUnit parsing." << endl;
	return 0;
}

/**
 * Opens a java/junit file and replaces certain lines.
 * Creates an output file in the same path as the original file.
 * @param string fileName
 * @return int 0
 */
void parser(string fileName) {
	fullPath = fileName;
	string outPath = fullPath.substr(0, fullPath.find(".")) + "_p.java";

	ifstream infile;
	infile.open(fullPath.c_str());
	ofstream outfile;
	outfile.open(outPath.c_str());
	string currLine, nextLine;
	outfile << "//JUnitParser replaces non-working fireEvent calls in test suite with"
			<< '\n' << "//working Robotium methods." << '\n';

	orientationCount = 1;
	if (infile.is_open()) {
		while (getline(infile, currLine)) {
			if (found(currLine, "fireEvent")) {
				if (!found(currLine, "back")
					&& !found(currLine, "openMenu")
					&& !found(currLine, "click")
					&& !found(currLine, "changeOrientation")) {
						outfile << currLine << '\n';
				}
			    else {
					getline(infile, nextLine);
					if(!found(nextLine, "retrieve")){
						outfile << fireEventFix(currLine + nextLine) << '\n';
					} else{
						outfile << fireEventFix(currLine) << '\n' << nextLine << '\n';
					}
				}
			} else if(found(currLine, "AndroidGuiTest") || found(currLine, NAME_FORMAT)) {
				outfile << classNameFix(currLine) << '\n';
			} else {
				outfile << currLine << '\n';
			}
		}
	} else {
		cout << "Unable to open " << fileName << endl;
	}
	infile.close();
	outfile.close();
	cout << "Finished parsing JUnit file: " << fullPath << endl;
}

/**
 * parser finds "fireEvent" method calls and replaces them with
 * working Robotium calls
 * @param string inputText
 * @return new Robotium call as a string
 */
string fireEventFix(string inputText) {
	//if string "fireEvent" is found...
	if (found(inputText, "changeOrientation")) {
		if (orientationCount % 2 == 0) {
			orientationCount += 1;
			return "\t \tsolo.setActivityOrientation(Solo.PORTRAIT);";
		} else {
			orientationCount += 1;
			return "\t \tsolo.setActivityOrientation(Solo.LANDSCAPE);";
		}
	} else if (found(inputText, "back")) {
		return "\t \tsolo.goBack();";
	} else if (found(inputText, "openMenu")) {
		return "\t \tsolo.sendKey(Solo.MENU);";
	} else if (found(inputText, "click")) {
		vector<string> string_list;
		istringstream ss(inputText);
		string token;
		while (getline(ss, token, ',')) {
			string_list.push_back(token);
		}
		if (string_list.size() == 4) {
			if (string_list[1].length() <= 3) {
				return inputText;
			} else if (found(string_list[2], "menu")) {
				return "\t \tsolo.clickOnMenuItem(" + string_list[1] + ");";
			} else {
				return "\t \tsolo.clickOnButton(" + string_list[1] + ");";
			}
		} else if (string_list.size() == 5) {
			if (string_list[2].length() <= 3) {
				return inputText;
			} else if (found(string_list[3], "menu")) {
				return "\t \tsolo.clickOnMenuItem(" + string_list[2] + ");";
			} else {
				return "\t \tsolo.clickOnButton(" + string_list[2] + ");";
			}
		} else {
			return inputText;
		}
	}
	else {
		return inputText;
	}
}

/**
 * Corrects class & constructor name inside junit file to match new file name
 * "AndroidGuiTest" is the default from AndroidRipper.
 * NAME_FORMAT is declared in this file.
 * @param string inputText
 * @return string of new line containing the class changed to match new file name
 */
string classNameFix(string inputText) {
	string name = fullPath.erase(0, fullPath.find_last_of("/") + 1);
	name = name.substr(0, name.find("."));
	name = name + "_p";
	if(found(inputText, "class")) {
		return ("public class " + name + " extends ActivityInstrumentationTestCase2 {");
	}
	else {
		return ("	public " + name + " () {");
	}
}
