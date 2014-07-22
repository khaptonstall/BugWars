/*
 * main.cpp
 *
 *  Created on: Jul 14, 2014
 *      Author: Meredith Singletary
 *
 *  Description:
 *  	Asks user which parsers to run, and which files to run these parsers on.
 *
 *	Formatting of list file:
 *      first line: path of the junit test suite files
 *      ex: C:/Users/Username/workspace/AppTests/
 *      	(include last slash)
 *      each line after: name of a junit test file located in that path
 *      	ex: Wordpress_v2_4.java
 *      	(include extension)
 *
 *    If JUnitParser.cpp parses multiple files at once,
 *    it automatically creates a new file with the list of modified java file names.
 *    If running JUnitParser & XMLParser at the same time, it will automatically parse these same files into XML.
 */

#include <iostream>
#include <string>

#include "JUnitParser.h" //declaration for jparse(bool multiple)#include "XMLParser.h" //declaration for xmlparse
#include "HexMatch.h"
using namespace std;

bool readKey(char selection);
int main();

int main() {

	string jListName;
	char selection;
	bool parseJUnit, parseMultipleJUnit, parseXML;
	cout << "-----------------" << endl;

	cout << "Run the JUnit parser (y/n): " << endl;
	cin >> selection;
	if (readKey(selection)) {
		parseJUnit = true;
		cout << "Parse multiple test suites (y/n): " << endl;
		cin >> selection;
		if (readKey(selection)) {
			cout << "Name of the file containing the path & list of test suites: " << endl;
			cin >> jListName;
			setJListFile(jListName);
			parseMultipleJUnit = true;
		} else {
			cout << "Path of the test suite: " << endl;
			string jpath;
			cin >> jpath;
			setPath(jpath);
			parseMultipleJUnit = false;
		}
	} else {
		parseJUnit = false;
	}

	cout << "Run the XML parser (y/n): " << endl;
	cin >> selection;
	if (readKey(selection)) {
		//if also running JUnitParser,
		//Runs XMLParser on the same files JUnitParser just finished parsing
		if (parseJUnit) {
			string xListName = setJListFile(jListName);
			setXFileName(xListName);
		} else {
			cout << "Enter the name of the file containing the path & list of test suites to add to the xml file:"  << endl;
			string xListName;
			cin >> xListName;
			setXFileName(xListName);
		}
		if (!isRPathSet()) {
			cout << "Enter the full path of the R.java file for the android application being tested:" << endl;
			string rpath;
			cin >> rpath;
			setRPath(rpath);
		}
		parseXML = true;
	} else {
		parseXML = false;
	}

	//runs the JUnitParser.cpp
	if (parseJUnit) {
		if (parseMultipleJUnit) {
			jparse(parseMultipleJUnit);
		}
		else {
			jparse(false);
		}
	}

	//runs XMLParser.cpp
	if (parseXML) {
		xmlparse();
	}

	cout << "DONE." << endl;

	return 0;
}

/*
 * If parameter == 'y', returns true
 * If parameter != 'y', return false
 * @param char
 * @return bool
 */
bool readKey(char selection) {
	if (selection == 'y') {
		return true;
	} else if (selection == 'n') {
		return false;
	}
	return false;
}

