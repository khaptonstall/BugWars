/*
 * ClassNameFix.cpp
 *
 *  Created on: July 27, 2014
 *      Author: Meredith Singletary
 *      Description:
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>

#include "found.h"
#include "JUnitParser.h"

using namespace std;

string NAME_FORMAT;
//NAME_FORMAT= "WP2_FINAL_"; //format of junit file names

/**
 * Corrects class & constructor name inside junit file to match new file name
 * "AndroidGuiTest" is the default name from AndroidRipper.
 * NAME_FORMAT is declared in this file.
 * @param string inputText
 * @return string of new line containing the class changed to match new file name
 */
string classNameFix(string inputText) {
	string name = getFullPath().erase(0, getFullPath().find_last_of("/") + 1);
	name = name.substr(0, name.find("."));
	name = name + "_p";
	if (found(inputText, "/*") || found(inputText, "//")) {
		//if nameformat is found inside a comment, ignore
		return inputText;
	}
	if(found(inputText, "class")) {
		return ("public class " + name + " extends ActivityInstrumentationTestCase2 {");
	}
	else {
		return ("	public " + name + " () {");
	}
}

/*
 * If name_format is not set, requests name_format in console.
 * return string with the name format of the junit files
 */
string getNameFormat(){
	if (NAME_FORMAT.compare("") == 0) {
		cout << "Name format for junit files: " << endl;
		string format;
		cin >> format;
		NAME_FORMAT = format;
	}
	return NAME_FORMAT;
}
/**
 * Sets the NAME_FORMAT variable
 * @param string
 */
void setNameFormat(string format) {
	NAME_FORMAT = format;
}
