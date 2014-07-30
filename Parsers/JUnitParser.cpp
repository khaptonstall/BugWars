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
using namespace std;
#include "found.h"
#include "XMLParser.h"
#include "hasonlyspaces.h"
#include "ClassNameFix.h"

void parser(string fileName);
string fireEventFix(string inputText);

int orientationCount;
string fullPath;
string listFileName;
string outputListName;

/* Sets fullPath variable
 * @param string path/file name of the java file to parse
 */
void setPath(string filePath) {
	fullPath = filePath;
}

/* @return string with full path of junit file
 */
string getFullPath() {
	return fullPath;
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
			outListFile << line << endl; //creates txt file with list of JUnit cases, for use with xml parser
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
	fullPath = fileName; //ex: WP2_Test_1.java
	string outPath = fullPath.substr(0, fullPath.find(".")) + "_p.java"; //ex: WP2_Test_1_p.java

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
				} else {
					getline(infile, nextLine);
					if(!found(nextLine, "retrieve")){
						outfile << fireEventFix(currLine + nextLine) << '\n';
					} else {
						outfile << fireEventFix(currLine) << '\n' << nextLine << '\n';
					}
				}
			}
			/* Replaces the class names automatically when parsing. NAME_FORMAT is set in main
			 * Or can be set in ClassNameFix.cpp, or by calling setNameFormat(string format) */
			else if(found(currLine, "AndroidGuiTest") || found(currLine, getNameFormat())) {
				outfile << classNameFix(currLine) << '\n';
			}
			else {
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
			return "\t\tsolo.setActivityOrientation(Solo.PORTRAIT);";
		} else {
			orientationCount += 1;
			return "\t\tsolo.setActivityOrientation(Solo.LANDSCAPE);";
		}
	} else if (found(inputText, "back")) {
		//fireEvent (0, "", "null", "back");
		return "\t\tsolo.goBack();";
	} else if (found(inputText, "openMenu")) {
		//fireEvent (0, "", "null", "openMenu");
		return "\t\tsolo.sendKey(Solo.MENU);";
	} else if (found(inputText, "menuItem")) {
		//fireEvent (1, "New Page", "menuItem", "click");
		return inputText;
	} else if (found(inputText, "click")) {
		vector<string> string_list;
		istringstream ss(inputText);
		string token;
		while (getline(ss, token, ',')) {
			string_list.push_back(token);
		}
		if (found(string_list[3], "\"button\"")) {
			if (found(string_list[2], "\"\"")) {
				//fireEvent (16908794, 19, "", "button", "click");
				return inputText;
			} else {
				//fireEvent (16908313, 15, "Yes", "button", "click");
				return "\t\tsolo.clickOnButton(" + string_list[2] + ");";
			}
		} else if (found(string_list[3], "\"text\"")) {
			//fireEvent (2131165193, 10, "www.automattic.com", "text", "click");
			return "\t\tsolo.clickOnText(" + string_list[2] + ");";
		} else if(found(string_list[2], "menuItem")) {
			//fireEvent (1, "New Page", "menuItem", "click");
			return inputText;
		} else if (found(string_list[3], "toggle")) {
			//fireEvent (2131165293, 10, " ABC ", "toggle", "click");
			//maybe: return inputText?
			return "\t\tsolo.clickOnButton(" + string_list[2] + ");";
		}
	}
	return inputText;
}


/* Sets listFileName and outputListName variables
 * @param string name of txt file containing list of JUnit files to parse
 * @return string name of txt file containing list of parsed JUnit file names
 */
void setJListFile(string fileName) {
	listFileName = fileName;
	string outputListName = fileName.substr(0, fileName.find(".")) + "_p.txt";
	setXFileName(outputListName);
}
