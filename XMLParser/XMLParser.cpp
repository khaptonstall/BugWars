/*
 * XMLParser.cpp
 *
 *  Created on: July 8, 2014
 *      Author: Meredith Singletary
 *      Description: XParser works with JUnit test cases created using Android GUI Ripper/Crawler.
 *      	XParser.cpp goes through these JUnit test cases and for each gui event,
 *      	adds the event info to an xml file for use by the C-PUT test case prioritization tool.
 *
 *      	Using XParser: If the JUnit file you are parsing is
 *      		not in the same workspace folder as XParser.cpp, include the path as part of the file name.
 *      		Replace the name
 *      		of both the infile and outfile as commented below. Build and run.
 *
 *      Notes: Be sure there are no comments that contain the word testTrace
 *
 *      	Formatting of list file:
 *      		first line: path of the junit test suite files
 *      			ex: C:/Users/Username/workspace/AppTests/
 *      			(include last slash)
 *      		each line after: name of a junit test file
 *      			ex: Wordpress_v2_4.java
 *      			(include extension)
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

string parser(string inputText);
string activityMgr(string inputText);
bool found(string line, string text);
bool has_only_spaces(string line);
string currentActivity;
string path;

string DEFAULT_ACTIVITY = "Dashboard"; //starting activity
string outName = "sample_out.xml"; //Replace with desired output XML file name & path
string listName = "fileList.txt"; //Replace with file name & path of the list of test suite files to include in log

int main(int argc, char** argv) {
	string path;
	bool traceFound = false;
	currentActivity = DEFAULT_ACTIVITY;

	ofstream outfile;
	outfile.open(outName.c_str());
	outfile << "<!--This xml file contains android/robotium event call information," <<
				'\n' << "formatted for the C-PUT tool.-->" << '\n';
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
		//for each file name in fileList.txt:
		while(getline(listFile, line)){
			if (!has_only_spaces(line)) {
				string filePath = path + line;
				string currentFileName = line.substr(0, line.find("."));

				ifstream infile;
				infile.open(filePath.c_str());
				if(infile.is_open()){
					string currLine;
					while(getline(infile, currLine)){	//reads each line in the open file; stores as currLine
						//if new testTrace method found
						if(found(currLine, "testTrace")) {
							traceFound = true;
							string traceNum = currLine;
							traceNum = traceNum.erase(0, traceNum.find("0"));
							traceNum = traceNum.erase(traceNum.find(" "));
							outfile << "<session id=\"" << currentFileName
									<< "_" << traceNum << "\">" << '\n'
									<< "<url>"
									<< "\n\t<baseurl>" + currentActivity + "</baseurl>" << '\n';
						}
						//if inside a testTrace method
						else if (traceFound) {
							//if end of testTrace method found
							if(currLine.find("}") != std::string::npos) {
								outfile << "</url>\n" << "</session>\n";
								traceFound = false;
							}
							if(found(currLine, "solo.sendKey") ||
									found(currLine, "solo.clickOnButton") ||
									found(currLine, "setInput") ||
									found(currLine, "solo.setActivityOrientation") ||
									found(currLine, "solo.goBack") ||
									found(currLine, "fireEvent")) {
								outfile << parser(currLine) << '\n';
							}
							else if(found(currLine, "solo.assertCurrentActivity")) {
									outfile << activityMgr(currLine) << '\n';
							}
						}
					}
				} else {
					cout << "Unable to open current junit file.";
				}
				infile.close();
				cout << "Finished: " << filePath << endl;
			}
		}
	} else {
		cout << "Unable to open file containing list of test suites.";
	}
	outfile << "</testSuite>" << endl;
	outfile.close();
	cout << "DONE." << endl;
	return 0;
}


/**
 * Parser takes robotium methods
 * adds xml information to the output xml file.
 * @param string inputText
 * @return xml code representing android events
 */
string parser(string inputText){
	if (found(inputText, "fireEvent")) {				//temporary
		//cout << "found!" << endl;
	}
	if(found(inputText, "solo.sendKey")) {
		if(found(inputText, "Solo.MENU")) {
			return ("\t<param>\n\t\t"
					"<name>Solo.MENU</name>\n\t\t"
					"<value>sendKey</value>\n\t</param>");
		} else {
			cout << "sendKey not matched to existing key options." << endl;
		}
	}
	if(found(inputText, "solo.clickOnButton")) {		//clickOnButton events
		vector<string> string_list;
		istringstream ss(inputText);
		string token;
		while(getline(ss, token, '\"')){
			string_list.push_back(token);
		}
		string button = string_list[1];
		return "\t<param>\n\t\t<name>"
				+ button
				+ "</name>\n\t\t<value>clickOnButton</value>\n\t</param>";
	}
	if(found(inputText, "setInput")) {				//setInput events
		vector<string> string_list;
		istringstream sstream(inputText);
		string token;
		while(getline(sstream, token, ',')){
			string_list.push_back(token);
		}
		string text = string_list[2];
		text = text.erase(0,2);
		text = text.erase(text.find("\""));
		return  "\t<param>\n\t\t<name>" + text
				+ "</name>\n\t\t<value>setInput</value>\n\t</param>";
	}
	if(found(inputText, "solo.setActivityOrientation")) {	//setActivityOrientation events
		if(found(inputText, "Solo.LANDSCAPE")) {
			return ("\t<param>\n\t\t"
					"<name>Solo.LANDSCAPE</name>\n\t\t"
					"<value>setActivityOrientation</value>\n\t</param>");
		} else if(found(inputText, "Solo.PORTRAIT")) {
			return ("\t<param>\n\t\t"
					"<name>Solo.PORTRAIT</name>\n\t\t"
					"<value>setActivityOrientation</value>\n\t</param>");
		}
	}
	if(found(inputText, "solo.goBack")) {					//goBack events								//temporary
		return ("\t<param>\n\t\t"
				"<name>Back</name>\n\t\t"
				"<value>sendKey</value>\n\t</param>");
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
		return "</url>\n<url>\n\t<baseurl>" + Activity + "</baseurl>";
	}
	return "";
}



/**
 * Returns true if the substring (text) is found in the string line.
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

/**
 * Checks to see if a line contains only spaces
 * @param string str
 * @return bool (true if no non-space char is found)
 */
bool has_only_spaces(string line) {
	if (line.find_first_not_of(' ') == std::string::npos) {
		return true;
	} else {
		return false;
	}

}
