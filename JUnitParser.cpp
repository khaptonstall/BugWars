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
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

string parser(string inputText);
bool found(string line, string text);
int orientationCount;
string fullPath;
string NAME_FORMAT = "WP_2_"; //format of junit file names

int main(int argc, char** argv) {

	fullPath = "PATH/FILENAME.java";	//Replace with the full path of JUnit test suite
	string outPath = fullPath.substr(0, fullPath.find(".")) + "_parsed.java";

	ifstream infile;
	infile.open(fullPath.c_str());
	string currLine, nextLine;
	ofstream outfile;
	outfile.open(outPath.c_str());

	outfile << "//JUnitParser replaces non-working fireEvent calls in test case with"
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
						outfile << parser(currLine + nextLine) << '\n';

					}
					else{
						outfile << parser(currLine) << '\n' << nextLine << '\n';
					}
				}
			} else if(found(currLine, "AndroidGuiTest") || found(currLine, NAME_FORMAT)) {
				outfile << parser(currLine) << '\n';
			} else {
				outfile << parser(currLine) << '\n';
			}
		}
	} else {
		cout << "Unable to open" << endl;
	}
	infile.close();
	cout << "DONE." << endl;
	outfile.close();
	return 0;
}

/**
 * parser finds "fireEvent" method calls and replaces them with
 * working Robotium calls
 * @param string inputText
 * @return new Robotium call as a string
 */
string parser(string inputText) {
	//if string is found...
	if (found(inputText, "fireEvent")) {
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
	}
	//Corrects class & constructor name inside junit file to match new file name
	//AndroidGuiTest is the default from AndroidRipper. NAME_FORMAT is declared in this file.
	if((found(inputText, "AndroidGuiTest")) || (found(inputText, NAME_FORMAT))){
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
	else {
		return inputText;
	}
	return "";
}


/**
 * Returns true if the substring 'text' the string 'line'.
 * Returns false if the substring is not found
 * @param string line
 * @param string text
 * @return bool
 */
bool found(string line, string text) {
	if (line.find(text) != std::string::npos) {
		return true;
	} else return false;
}
