/*
 * XMLParser.cpp
 *
 *  Created on: July 8, 2014
 *      Author: Meredith Singletary
 *      Description: XMLParser works with JUnit test cases created using Android GUI Ripper/Crawler.
 *      	XMLParser.cpp goes through these JUnit test cases and for each gui event,
 *      	adds the event info to an xml file for use by the C-PUT test case prioritization tool.
 *
 *      	Using XMLParser: If the JUnit file you are parsing is
 *      		not in the same workspace folder as XMLParser.cpp, include the path as part of the file name.
 *      		Replace the name
 *      		of both the infile and outfile as commented below. Build and run.
 *
 *      Notes: Be sure there are no comments that contain the word testTrace
 *
 *      	Formatting of list file:
 *      		first line: path of the junit test suite files
 *      			ex: C:/Users/Username/workspace/AppTests/
 *      			(include last slash)
 *      		each line after: name of a junit test file located in that path
 *      			ex: Wordpress_v2_4.java
 *      			(include extension)
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>

#include "found.h"
#include "hasonlyspaces.h"
using namespace std;

int xmlparse(); //main parsing method
string eventXML(string inputText);
string activityMgr(string inputText);
string currentActivity;
string path;

string DEFAULT_ACTIVITY = "Dashboard"; //Replace with name of the starting activity
string xmlName = "sample_out.xml"; //Replace with desired output XML file name & path
string listName;
//string fileListName = "fileList_p.txt"; //Replace with file name & path of the list of test suite files to include in log


/*
 * sets listFileName and outputListName variables
 * @param string name of txt file containing list of JUnit files to parse
 * @return string name of txt file containing list of parsed JUnit file names
 */
void setXFileName(string fileName) {
	listName = fileName;
}

int xmlparse() {

	bool traceFound = false;

	ofstream outfile;
	outfile.open(xmlName.c_str());
	outfile << "<!--This xml file contains android/robotium event call information," <<
				'\n' << "formatted for the C-PUT prioritization tool.-->" << '\n';
	outfile << "<testSuite>" << '\n';

	ifstream listFile;
	listFile.open(listName.c_str());

	if(listFile.is_open()){
		string line;
		getline(listFile, line);
		while (has_only_spaces(line)) {
			getline(listFile, line);
		}
		path = line;	//set path of JUnit test suites
		//for each line (each line is a file name in fileList.txt):
		while(getline(listFile, line)){
			if (!has_only_spaces(line)) {
				string filePath = path + line;
				string currentFileName = line.substr(0, line.find("."));	//name, without extension
				ifstream infile;
				infile.open(filePath.c_str());
				if(infile.is_open()){
					string currLine;
					//reads each line in the open file
					while(getline(infile, currLine)){
						//if new testTrace method found:
						if(found(currLine, "testTrace")) {
							traceFound = true;
							currentActivity = DEFAULT_ACTIVITY;
							string traceNum = currLine;
							traceNum = traceNum.erase(0, traceNum.find("0"));
							traceNum = traceNum.erase(traceNum.find(" "));
							outfile << "<session id=\"" << currentFileName
									<< "_" << traceNum << "\">" << '\n'
									<< "<url>"
									<< "\n\t<baseurl>" + currentActivity + "</baseurl>" << '\n';
						}
						//if inside a testTrace method:
						else if (traceFound) {
							//if end of testTrace method found
							if(found(currLine, "}")) {
								outfile << "</url>\n" << "</session>\n";
								traceFound = false;
							}
							if(found(currLine, "solo.sendKey") ||
									found(currLine, "solo.clickOnButton") ||
									found(currLine, "setInput") ||
									found(currLine, "solo.setActivityOrientation") ||
									found(currLine, "solo.goBack") ||
									found(currLine, "solo.clickOnMenuItem") ||
									found(currLine, "linearLayout") ||
									found(currLine, "fireEvent")) {
								outfile << eventXML(currLine);
								// << '\n'
							}
							else if(found(currLine, "solo.assertCurrentActivity")) {
									outfile << activityMgr(currLine);
							}
						}
					}
				} else {
					cout << "Unable to open current junit file: " << filePath << endl;
				}
				infile.close();
				cout << "Finished parsing to XML: " << line << endl;
			}
		}
	} else {
		cout << "Unable to open file containing list of test suites.";
	}
	outfile << "</testSuite>" << endl;
	outfile.close();
	cout << "Finished creating XML file from JUnit test suites." << endl;
	return 0;
}


/**
 * eventXML gets information from the robotium event methods
 * and adds xml information to the output xml file.
 * @param string inputText
 * @return xml code representing android events
 */
string eventXML(string inputText){
	if (found(inputText, "fireEvent")) {				//temporary
		return ("\n\t<param>\n\t\t"
			"<name>"
			+ inputText
			+ "</name>\n\t\t"
			"<value>fireEvent</value>\n\t</param>");
		//cout << "found!" << endl;
	}
	else if(found(inputText, "solo.sendKey")) {
		if(found(inputText, "Solo.MENU")) {
			return ("\n\t<param>\n\t\t"
					"<name>Solo.MENU</name>\n\t\t"
					"<value>sendKey</value>\n\t</param>");
		} else {
			cout << "sendKey not matched to existing key options." << endl;
		}
	}
	else if(found(inputText, "solo.clickOnButton")) {		//clickOnButton events
		vector<string> string_list;
		istringstream ss(inputText);
		string token;
		while(getline(ss, token, '\"')){
			string_list.push_back(token);
		}
		string button = string_list[1];
		return "\n\t<param>\n\t\t<name>"
				+ button
				+ "</name>\n\t\t<value>clickOnButton</value>\n\t</param>";
	}
	else if(found(inputText, "setInput")) {				//setInput events
		vector<string> string_list;
		istringstream sstream(inputText);
		string token;
		while(getline(sstream, token, ',')){
			string_list.push_back(token);
		}
		string text = string_list[2];
		text = text.erase(0,2);
		text = text.erase(text.find("\""));
		return  "\n\t<param>\n\t\t<name>" + text
				+ "</name>\n\t\t<value>setInput</value>\n\t</param>";
	}
	else if(found(inputText, "solo.setActivityOrientation")) {	//setActivityOrientation events
		if(found(inputText, "Solo.LANDSCAPE")) {
			return ("\n\t<param>\n\t\t"
					"<name>Solo.LANDSCAPE</name>\n\t\t"
					"<value>setActivityOrientation</value>\n\t</param>");
		} else if(found(inputText, "Solo.PORTRAIT")) {
			return ("\n\t<param>\n\t\t"
					"<name>Solo.PORTRAIT</name>\n\t\t"
					"<value>setActivityOrientation</value>\n\t</param>");
		}
	}
	else if(found(inputText, "solo.goBack")) {					//goBack events								//temporary
		return ("\n\t<param>\n\t\t"
				"<name>Back</name>\n\t\t"
				"<value>sendKey</value>\n\t</param>");
	}
	else if(found(inputText, "solo.clickOnMenuItem")) {
		vector<string> string_list;
		istringstream ss(inputText);
		string token;
		while(getline(ss, token, '\"')){
			string_list.push_back(token);
		}
		string item = string_list[1];
		return "\n\t<param>\n\t\t<name>"
				+ item
				+ "</name>\n\t\t<value>clickOnMenuItem</value>\n\t</param>";
	}
	else if(found(inputText, "linearLayout")) {
		string x = "xx";
		return "\n\t<param>\n\t\t<name>"
				+ x
				+ "</name>\n\t\t<value>linearLayout</value>\n\t</param>";
	}
	return "";
}

/**
 * Reads activity name from robotium method (solo.assertCurrentActivity),
 * compares name to value of currentActivity.
 * If new activity, end current xml url section and begin new <url> xml section
 * @param string inputText
 * @return new line of xml code, as string
 */
string activityMgr(string inputText) {
	vector<string> string_list;
	istringstream ss(inputText);
	string token;
	while(getline(ss, token, ',')){
		string_list.push_back(token);
	}
	string Activity = string_list[1];
	Activity = Activity.erase(0,2);
	Activity = Activity.erase(Activity.find("\""));
		//if currentActivity not previously set
		/*if (currentActivity.compare("new") == 0) {
			//first activity is manually set, making this irrelevant
			currentActivity = Activity;
			return "<url>\n\t<baseurl>" + Activity + "</baseurl>";
		}*/
	//if different activity is found..
	if (Activity.compare(currentActivity) != 0) {
		currentActivity = Activity;
		return "\n</url>\n<url>\n\t<baseurl>" + Activity + "</baseurl>";
	}
	return "";
}


