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
 *      it automatically creates a new text file with the list of modified java file names.
 *    If running JUnitParser & XMLParser at the same time, it will automatically parse these same files into XML.
 */

#include <iostream>
#include <string>
#include "Compare.h"
#include "main.h"
#include "HexMatch.h"
#include "JUnitParser.h" //declaration for jparse(bool multiple)
#include "XMLParser.h" //declaration for xmlparse

using namespace std;

char readKey();
bool isYes(char selection);


int main() {
	string jListName;
	char selection;
	bool parseJUnit, parseMultipleJUnit, parseXML;
	cout << "-----------------" << endl;

	//set the path for the R.java of the application under test //so you don't have to enter it every time:
	//setRPath("C:/Users/Meredith/workspace/WordPress-v2.0_ContainsAllBugs/WordPress-Android-2.0/gen/org/wordpress/android/R.java");

	cout << "Do you want to run the JUnit parser? y/n: " << endl;
	selection = readKey();
	if (isYes(selection)) {
		parseJUnit = true;
		cout << "Do you want to parse multiple test suites? y/n: " << endl;
		selection = readKey();
		if (isYes(selection)) {
			parseMultipleJUnit = true;
			cout << "What is the path/name of the file containing the path & list of test suites? " << endl;
			cin >> jListName;
			setJListFile(jListName);
		} else {
			parseMultipleJUnit = false;
			cout << "What is the path of the JUnit test suite? " << endl;
			string jpath;
			cin >> jpath;
			setPath(jpath);
		}
	} else {
		parseJUnit = false;
	}

	cout << "Do you want to run the XML parser? y/n: " << endl;
	selection = readKey();
	if (isYes(selection)) {
		//if also running JUnitParser, fileList_p.txt created in JUnitParser.cpp & contains list of parsed junit files
		//Runs XMLParser on the same files JUnitParser just finished parsing
		if (!(parseJUnit)) {
			cout << "Enter the name of the file containing the path & list of test suites to add to the xml file:"  << endl;
			string xListName;
			cin >> xListName;
			setXFileName(xListName);
		}
		if (!isRPathSet()) {
			cout << "Enter the full path of the R.java file for the application being tested: " << "\n(Usually something like C:/WHERE/YOU/SAVED/THE/APP/Wordpress-v2/gen/org/wordpress/android/R.java" << endl;
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

	cout << "\n" << "DONE." << endl;


	return 0;
}

/*
 * If parameter == 'y', returns true
 * If parameter != 'y', return false
 * @param char
 * @return bool
 */
bool isYes(char selection) {
	if (selection == 'y') {
		return true;
	} else if (selection == 'n') {
		return false;
	}
	return false;
}

/*
 * Reads char entered in console.
 * Asks for new char, until finds either y or n.
 * If char == 'y', returns true
 * If char != 'y', return false
 * @return char entered by user
 */
char readKey() {
	char in;
	cin >> in;
	while ((in != 'y') && (in != 'n')) {
		cout << "Please enter 'y' or 'n'" << endl;
		cin >> in;
	}
	return in;
}
