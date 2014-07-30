/*
 * HexMatch.cpp
 *
 *  Created on: July 16, 2014
 *      Author: Meredith Singletary
 *      Description: HexMatch contains methods for use
 *      when parsing JUnit test case information to an xml file.
 *
 */

#include <string>
#include <sstream>
#include <iostream>
#include <fstream>
#include <vector>
#include <stdlib.h> //atoi function //changes string to int
using namespace std;
#include "HexMatch.h"
#include "found.h"

string RPath;

/* RPath is the location of R.java of the android application being tested.
 * R.java is found inside the /gen folder of the application code.
 * param string fullPath of R.java
 */
void setRPath(string rpath) {
	RPath = rpath;
}

/*
 * return boolean true if RPath variable has been set, either manually or by a call to setRPath
 */
bool isRPathSet() {
	if (RPath.compare("") == 0)
		return false;
	return true;
}

/* Converts an integer value to the corresponding hex value.
 * param int id
 * return string hex value
 */
string intToHex(int i) {
	try {
		stringstream sstream;
		sstream << std::hex << i;
		string result = sstream.str();
		return result;
	} catch (...) {
		cout << "An exception was thrown by intToHex method!" << endl;
	}
	return "";
}

/* Gets the widgetId from a fireEvent method. (It is the first parameter)
 * Calls findWidgetName(int id)
 * param string line containing fireEvent method call
 * return string findWidgetName(int id)
 */
string findWidgetName(string inputText) {
	string widgetId = inputText.substr(inputText.find("("));
	widgetId = widgetId.substr(1, widgetId.find(","));
	int id = atoi(widgetId.c_str());
	return findWidgetNameFromId(id);
}

/* Searches an android application's R.java file for the widget matching the given ID. (The int id is first converted to a hex value).
 * If the value is found, this method returns a string containing the name of the variable that stores that hex value.
 * This string name is the name of the widget.
 * param int widget id.
 * return string widget name
 */
string findWidgetNameFromId(int id) {
	try {
		if (!isRPathSet()) {
			//if RPath is not set, asks for user input in console.
			cout << "Path of the R.java file for application under test: " << endl;
			string path;
			cin >> path;
			setRPath(path);
		}
		string hex = intToHex(id);
		ifstream infile;
		infile.open(RPath.c_str());
		string currLine;
		string name;
		if (infile.is_open()) {
			while (getline(infile, currLine)) {
				if (found(currLine, hex)) {
					name = currLine.substr(currLine.find_last_of(" "));
					name = name.substr(1, name.find("=") - 1);
				}
			}
		} else {
			cout << "Unable to open R.java" << endl;
		}
		infile.close();
		//cout << "Finished searching R.java for widget with id = " << id << endl;
		return name;
	} catch (...) {
		cout << "An exception was thrown inside the findWidgetName method!" << endl;
	}
	return "";
}
