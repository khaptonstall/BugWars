/*
 * HexMatch.cpp
 *
 *  Created on: July 16, 2014
 *      Author: Meredith Singletary
 *      Description: HexMatch contains methods for use when parsing JUnit test cases into to an xml file.
 *
 */
#include "HexMatch.h"
#include <string>
#include <sstream>
#include <iostream>
#include <fstream>
#include <vector>

#include "found.h"

using namespace std;

string RPath;
bool RPathSet;

/* RPath/fullPath is the location of R.java of the android application being tested.
 * R.java is found inside the gen/ folder of the application code.
 * param string fullPath of R.java
 */
void setRPath(string fullPath) {
	RPath = fullPath;
	RPathSet = true;
}

bool isRPathSet() {
	if (RPathSet) {
		return true;
	}
	return false;
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
		return "Exception occured.";
		cout << "An exception was thrown by intToHex method." << endl;
	}
	return "";
}


/* Searches an android application's R.java file for the widget matching the given ID. (The int id is converted to a hex value).
 * If the value is found, this method returns a string containing the name of the variable that stores that hex value.
 * This string name is the name of the widget.
 * param int widget id.
 * return string widget name
 */
string findWidgetName(int id) {
	try {
		string hex = intToHex(id);
		setRPath("C:/Users/Meredith/AppData/Local/Android/APKs/WordPress-Source/WordPress-Android-2.0/gen/org/wordpress/android/R.java");
		ifstream infile;
		infile.open(RPath.c_str());
		string currLine;
		string line = "notFound";

		if (infile.is_open()) {
			while (getline(infile, currLine)) {
				if (found(currLine, hex)) {
					line = currLine;
				}
			}
		} else {
			cout << "Unable to open R.java" << endl;
		}

		if (found(line, "notFound")) {
			return "name not found";
		}

		string name = line.substr(line.find_last_of(" "));
		name = name.substr(1, name.find("=") - 1);

		infile.close();
		//cout << "Finished searching R.java for widget with id = " << id << endl;
		return name;
	} catch (...) {
		cout << "An exception was thrown inside the findWidgetName method: " << endl;
	}
	return "";
}
