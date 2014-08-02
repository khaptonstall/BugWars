#include <iostream>
#include <string>

#include "HexMatch.h"
#include "JUnitParser.h" //declaration for jparse(bool multiple)
#include "XMLParser.h" //declaration for xmlparse

using namespace std;

bool readInKey(char selection);

int help() {
	cout << "-----------------" << endl;
	string jListName;
	char selection;
	bool parseJUnit, parseMultipleJUnit, parseXML;
	bool parsing = true;

 	parseXML = false;

 	bool hexing = false;
	if (hexing) {
		cout << "2131165249 " << intToHex(2131165249) << endl;
		cout << "2131165200 " << intToHex(2131165200) << endl;
		//cout << findWidgetName(16908298) << endl;
	}

	if (parsing) {
		cout << "Do you want to run the JUnit parser? y/n: " << endl;
		cin >> selection;
		if (readInKey(selection)) { //JUnit parser?
			parseJUnit = true;

			cout << "Do you want to parse multiple test suites? y/n: " << endl;
			cin >> selection;
			if (readInKey(selection)) { //if parse multitple = y
				cout << "Is the file name fileList.txt ?" << endl;
				cin >> selection;
				if (readInKey(selection)) { //is file name fileList
					setJListFile("fileList.txt");
					parseMultipleJUnit = true;
				}
				else {
					cout << "What is the name of the file containing the path & list of test suites? " << endl;
					cin >> jListName;
					setJListFile(jListName);
					parseMultipleJUnit = true;
				}
			} else { //parse single
				parseMultipleJUnit = false;
				cout << "Do you want your path to be: C:/Users/Meredith/workspace/WPTest_2/src/org/wordpress/android/test/WP_2_B1.java " << endl;
				cin >> selection;
				if (readInKey(selection)) { //same path
					string jpath = "C:/Users/Meredith/workspace/WPTest_2/src/org/wordpress/android/test/WP_2_B1.java";
					setPath(jpath);
				} else {
					cout << "What is the path of the test suite? " << endl;
					string jpath;
					cin >> jpath;
					setPath(jpath);
				}
			}
		} else {
			parseJUnit = false;
		}

		cout << "Do you want to run the XML parser? y/n: " << endl;
		cin >> selection;
		if (readInKey(selection)) {
			if (!(parseJUnit)) {
				cout << "Enter the name of the file containing the path & list of test suites to add to the xml file:"  << endl;
				string xListName;
				cin >> xListName;
				setXFileName(xListName);
			}
			if (!isRPathSet()) {
				cout << "Do you want the R.java file path to be: C:/Users/Meredith/AppData/Local/Android/APKs/WordPress-Source/WordPress-Android-2.0/gen/org/wordpress/android/R.java?" << endl;
				//cout << "Do you want the R.java file path to be: C:/Users/Meredith/AppData/Local/Android/APKs/WordPress-Source/Bugs/WordPress-Android-2.0-1/gen/org/wordpress/android/R.java?" << endl;
				//cout << "C:\Users\Meredith\workspace\wp-android-2-bug2\gen\org\wordpress\android?" << endl;

				cin >> selection;
				if (readInKey(selection)) {
					setRPath("C:/Users/Meredith/AppData/Local/Android/APKs/WordPress-Source/WordPress-Android-2.0/gen/org/wordpress/android/R.java");
					//setRPath("C:/Users/Meredith/AppData/Local/Android/APKs/WordPress-Source/Bugs/WordPress-Android-2.0-1/gen/org/wordpress/android/R.java");
				} else {
					cout << "Enter the full path of the R.java file for the android application being tested:" << endl;
					string rpath;
					cin >> rpath;
					setRPath(rpath);
				}
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
bool readInKey(char selection) {
	if (selection == 'y') {
		return true;
	} else if (selection == 'n') {
		return false;
	}
	return false;
}

