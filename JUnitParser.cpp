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

int main(int argc, char** argv) {

	orientationCount = 1;
	ifstream infile;
	infile.open("INPUT.java"); //Replace with your JUnit file name
	string currLine;
	string nextLine;
	ofstream outfile;
	outfile.open("OUTPUT.java"); //Replace with desired output JUnit name

	outfile << "//Parser replaces non-working fireEvent calls in testCase with"
			<< '\n' << "//working Robotium methods." << '\n';

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
					outfile << parser(currLine + nextLine) << '\n';
				}
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
				return "\t \tsolo.setActivityOrientation(Solo.POTRAIT);";
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
				//cout << token << '\n';
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
	} else {
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


