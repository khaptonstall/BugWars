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

//#include "main.h"


#include <iostream>
#include <string>

#include "HexMatch.h"
#include "JUnitParser.h" //declaration for jparse(bool multiple)#include "XMLParser.h" //declaration for xmlparse
using namespace std;

bool readKey(char selection);

int main() {
	string jListName;
	char selection;
	bool parseJUnit, parseMultipleJUnit, parseXML;
	bool hexing = false;
	bool parsing = false;
	bool simpleParse = false;
	cout << "-----------------" << endl;
 	parseXML = true;

	if (parseXML) {
		setXFileName("fileList2_p.txt");
		setRPath("C:/Users/Meredith/AppData/Local/Android/APKs/WordPress-Source/WordPress-Android-2.0/gen/org/wordpress/android/R.java");
		xmlparse();
	}

	if (hexing) {
		cout << "1690.. " << intToHex(16908298) << endl;
		cout << "2131" << intToHex(2131165257) << endl;
		//cout << findWidgetName(16908298) << endl;
	}

	if (simpleParse) {
		setPath("WP_2_4.java");
		jparse(false);
	}

	if (parsing) {
		cout << "Do you want to run the JUnit parser? y/n: " << endl;
		cin >> selection;
		if (readKey(selection)) {
			parseJUnit = true;
			cout << "Do you want to parse multiple test suites? y/n: " << endl;
			cin >> selection;
			if (readKey(selection)) {
				cout << "What is the name of the file containing the path & list of test suites? " << endl;
				cin >> jListName;
				setJListFile(jListName);
				parseMultipleJUnit = true;
			} else {
				cout << "What is the path of the test suite? " << endl;
				string jpath;
				cin >> jpath;
				setPath(jpath);
				parseMultipleJUnit = false;
			}
		} else {
			parseJUnit = false;
		}

		cout << "Do you want to run the XML parser? y/n: " << endl;
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
	}
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

