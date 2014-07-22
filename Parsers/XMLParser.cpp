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
 *      Formatting of list file:
 *      	first line: path of the junit test suite files
 *      		ex: C:/Users/Username/workspace/AppTests/
 *     			(include last slash)
 *      	each line after: name of a junit test file located in that path
 *      		ex: Wordpress_v2_4.java
 *      		(include extension)
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
#include <stdlib.h> //atoi //changes string to int

//#include <iostream>       // std::cerr
//#include <typeinfo>       // operator typeid
//#include <exception>      // std::exception

#include "found.h"
#include "hasonlyspaces.h"
#include "HexMatch.h"
using namespace std;

int xmlparse(); //main parsing method
string activityMgr(string inputText);
string getInfo_fireEvent(string inputText);
string getInfo_sendKey(string inputText);
string getInfo_clickOnButton(string inputText);
string getInfo_setInput(string inputText);
string getInfo_setActivityOrientation(string inputText);
string getInfo_goBack(string inputText);
string getInfo_clickOnMenuItem(string inputText);

string currentActivity;
string path;
string xmlName = "sample_out.xml"; //Replace with desired output XML file name & path
string listName; //Replace with file name & path of the list of test suite files to include in log


/*
 * sets listFileName and outputListName variables
 * @param string name of txt file containing list of JUnit files to parse
 * @return string name of txt file containing list of parsed JUnit file names
 */
void setXFileName(string fileName) {
	listName = fileName;
}

/* Main parsing method. For each java file listed in the specified text file, xmlparse() reads each line.
 * For each gui event method, it adds information to an xml file, formatted for use with the C-PUT tool.
 */
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
		path = line; //sets path of JUnit test suites
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
							string traceNum = currLine;
							traceNum = traceNum.erase(0, traceNum.find("0"));
							traceNum = traceNum.erase(traceNum.find(" "));
							outfile << "<session id=\"" << currentFileName
									<< "_" << traceNum << "\">" << '\n';
						}
						//if inside a testTrace method:
						else if (traceFound) {
							if(found(currLine, "}")) {
								//if end of testTrace method found
								outfile << "\n</url>\n" << "</session>\n";
								traceFound = false;
							} else if(found(currLine, "solo.assertCurrentActivity")) {
								outfile << activityMgr(currLine);
							}else if (found(currLine, "solo.sendKey")) {
								outfile << getInfo_sendKey(currLine);
							} else if (found(currLine, "solo.clickOnButton")) {
								outfile << getInfo_clickOnButton(currLine);
							} else if (found(currLine, "setInput")) {
								outfile << getInfo_setInput(currLine);
							} else if (found(currLine, "solo.setActivityOrientation")) {
								outfile << getInfo_setActivityOrientation(currLine);
							} else if (found(currLine, "solo.goBack")) {
								outfile << getInfo_goBack(currLine);
							} else if (found(currLine, "solo.clickOnMenuItem")) {
								outfile << getInfo_clickOnMenuItem(currLine);
							} else if (found(currLine, "fireEvent")) {
								outfile << getInfo_fireEvent(currLine);
							}
						}
					}
				} else {
					cout << "Unable to open current junit file: " << filePath << endl;
				}
				infile.close();
				cout << "Finished parsing current junit file to XML: " << line << endl;
			}
		}
	} else {
		cout << "Unable to open the file containing list of test suites: " << listName;
	}
	outfile << "</testSuite>" << endl;
	outfile.close();
	cout << "Finished creating XML file from JUnit test suites." << endl;
	return 0;
}


/**
 * Reads activity name from robotium method (solo.assertCurrentActivity),
 * compares name to value of currentActivity.
 * If new activity, ends current xml url section and begins new <url> xml section
 * @param string inputText
 * @return new line of xml code, as string
 */
string activityMgr(string inputText) {
	//sets first currentActivity for each test trace:
	if (found(inputText, "Testing base activity") && found(inputText, "solo.assertCurrentActivity")) {
		//solo.assertCurrentActivity("Testing base activity", "Dashboard");
		//GuiRipper's junit tests assert the base activity at the beginning of each test trace
		currentActivity = inputText.substr(inputText.find(",") + 3, string::npos);
		currentActivity = currentActivity.substr(0, currentActivity.find(")") - 1);
		return ("<url>\n\t<baseurl>" + currentActivity + "</baseurl>"); // << '\n';
	}

	vector<string> string_list;
	istringstream ss(inputText);
	string token;
	while(getline(ss, token, ',')){
		string_list.push_back(token);
	}
	string Activity = string_list[1];
	Activity = Activity.erase(0,2);
	Activity = Activity.erase(Activity.find("\""));

	//if different activity is found..
	if (Activity.compare(currentActivity) != 0) {
		currentActivity = Activity;
		return "\n</url>\n<url>\n\t<baseurl>" + Activity + "</baseurl>";
	}
	return "";
}

/* Gets information from a robotium event method call: sendKey
 * Formats information in xml.
 * @param string inputText
 * @return xml code representing an android event
 */
string getInfo_sendKey(string inputText) {
	if(found(inputText, "Solo.MENU")) {
		return ("\n\t<param>\n\t\t"
				"<name>Solo.MENU</name>\n\t\t"
				"<value>sendKey</value>\n\t</param>");
	} else {
		return "unknown key";
		cout << "sendKey not matched to existing key options." << endl;
	}
	return inputText;
}

/* Gets information from a robotium event method call: clickOnButton
 * Formats information in xml.
 * @param string inputText
 * @return xml code representing an android event
 */
string getInfo_clickOnButton(string inputText) {
	//solo.clickOnButton( "Privacy Policy");
	/*
	vector<string> string_list;
	istringstream ss(inputText);
	string token;
	while(getline(ss, token, '\"')){
		string_list.push_back(token);
	}
	string button = string_list[1];
	*/
	string button = inputText.substr(inputText.find("\"") + 1, string::npos);
	button = button.substr(0, button.find("\""));

	return "\n\t<param>\n\t\t<name>"
			+ button
			+ "</name>\n\t\t<value>clickOnButton</value>\n\t</param>";
}

/* Gets information from an inputText method
 * Formats information for xml file.
 * @param string inputText
 * @return xml code representing an android event
 */
string getInfo_setInput(string inputText) {
	//setInput (2131165236, "writeText", "90");
	/*
	vector<string> string_list;
	istringstream sstream(inputText);
	string token;
	while(getline(sstream, token, ',')){
		string_list.push_back(token);
	}
	string text = string_list[2];
	text = text.erase(0,2);
	text = text.erase(text.find("\""));
	*/
	string input = inputText.substr(0, inputText.find_last_of("\""));
	input = input.substr(input.find_last_of("\"") + 1, string::npos);

	return  "\n\t<param>\n\t\t<name>"
			+ input
			+ "</name>\n\t\t<value>setInput</value>\n\t</param>";
}

/* Gets information from a robotium event method: setActivityOrientation
 * Formats information for xml file.
 * @param string inputText
 * @return xml code representing an android event
 */
string getInfo_setActivityOrientation(string inputText) {
	if(found(inputText, "Solo.LANDSCAPE")) {
		return ("\n\t<param>\n\t\t"
				"<name>Solo.LANDSCAPE</name>\n\t\t"
				"<value>setActivityOrientation</value>\n\t</param>");
	} else if(found(inputText, "Solo.PORTRAIT")) {
		return ("\n\t<param>\n\t\t"
				"<name>Solo.PORTRAIT</name>\n\t\t"
				"<value>setActivityOrientation</value>\n\t</param>");
	}
	return inputText;
}

/* Gets information from a robotium event method: goBack
 * Formats information for xml file.
 * @param string inputText
 * @return xml code representing an android event
 */
string getInfo_goBack(string inputText) {
	return ("\n\t<param>\n\t\t"
			"<name>Back</name>\n\t\t"
			"<value>sendKey</value>\n\t</param>");
}

/* Gets information from robotium method clickOnMenuItem(itemName)
 * & formats information in xml.
 * @param string inputText
 * @return xml code representing an android event
 */
string getInfo_clickOnMenuItem(string inputText) {
	//solo.clickOnMenuItem( "New Page");
	string item = inputText.substr(inputText.find("\"") + 1, string::npos);
	item = item.substr(0, item.find("\""));
	return "\n\t<param>\n\t\t<name>"
			+ item
			+ "</name>\n\t\t<value>clickOnMenuItem</value>\n\t</param>";
}

/* Gets information from an fireEvent method call
 * Formats information for xml file.
 * @param string inputText
 * @return xml code representing an android event
 */
string getInfo_fireEvent(string inputText) {
	if(found(inputText, "listView")) {
		/*
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "5"); //page from database/listview
			public void fireEvent (int widgetId, int widgetIndex, String widgetName, String widgetType, String eventType, String value)
		fireEvent (8, "", "listView", "selectListItem", "3");	//context menu
			public void fireEvent (int widgetIndex, String widgetName, String widgetType, String eventType, String value);
		fireEvent (8, "", "listView", "longClickListItem", "1"); //context menu
			public void fireEvent (int widgetIndex, String widgetName, String widgetType, String eventType, String value);
		*/
		inputText = inputText.erase(0, inputText.find("(") + 1);
		inputText = inputText.erase(inputText.find(")"), string::npos);
		cout << "\n" << inputText << endl;

		string clickType;
		if (found(inputText, "longClickListItem")) {
			clickType = "longClickListItem";
		} else if (found(inputText, "selectListItem")) {
			clickType = "selectListItem";
		}

		vector<string> param_list;
		istringstream ss(inputText);
		string token;
		while(getline(ss, token, ',')){
			param_list.push_back(token);
		}
		/*
		//int i;
		for (int i = 0; i < param_list.size(); i++) {
			cout << param_list[i] << endl;
		}
		*/
		//If the second fireEvent parameter is an empty string (""), method is clicking on a context menu
		if (found(param_list[1], "\"\"")) {
			string value = param_list[4];
			value = value.substr(value.find("\"") + 1, value.find_last_of("\"") - 2);

			return ("\n\t<param>\n\t\t<name>"
				"listItem #" + value + " in context menu."
				"</name>\n\t\t"
				"<value>" + clickType + "</value>\n\t</param>");
		}

		//if the second fireEvent parameter is not an empty string, method is NOT clicking on a context menu item
		else {
			string value = param_list[5];
			value = value.substr(value.find("\"") + 1, value.find_last_of("\"") - 2); //erases quotation marks around the string value

			//int n = atoi(value.c_str());
			//cout << "value: " << value << endl;
			//cout << "N: " << n << endl;
			//int n = Math.min(l.getCount(), Math.max(1,num))-1;

			return ("\n\t<param>\n\t\t<name>"
				"listItem, value = " + value
				+ "</name>\n\t\t"
				"<value>" + clickType + "</value>\n\t</param>");
		}
	}
	else if(found(inputText, "\"button\"")) {
		//fireEvent (16908796, 24, "", "button", "click"); date picker
		return ("\n\t<param>\n\t\t<name>"
			"date picker"
			"</name>\n\t\t"
			"<value>click button</value>\n\t</param>");
	}
	else if(found(inputText, "spinner")) {
		//fireEvent (2131165280, 13, "", "spinner", "selectSpinnerItem", "2");
		inputText = inputText.erase(0, inputText.find("(") + 1);
		inputText = inputText.erase(inputText.find(")"), string::npos);
		//cout << "\n" << inputText << endl;

		vector<string> param_list;
		istringstream ss(inputText);
		string token;
		while(getline(ss, token, ',')){
			param_list.push_back(token);
		}
		/*
		//int i;
		for (int i = 0; i < param_list.size(); i++) {
			cout << param_list[i] << endl;
		}
		*/

		string value = param_list[5];
		value = value.substr(value.find("\"") + 1, value.find_last_of("\"") - 2);

		return ("\n\t<param>\n\t\t<name>"
				"spinner item #" + value
				+ "</name>\n\t\t"
				"<value>selectSpinnerItem</value>\n\t</param>");
	}
	else if(found(inputText, "\"click\"")) {
		//fireEvent (2131165251, 21, "", "linearLayout", "click");
		string widgetId = inputText.substr(inputText.find("("));
		widgetId = widgetId.substr(1, widgetId.find(","));
		int id = atoi(widgetId.c_str());

		return ("\n\t<param>\n\t\t<name>"
			+ findWidgetName(id) + "</name>\n\t\t"
			"<value>fireEvent</value>\n\t</param>");
		//cout << "found!" << endl;
		//}
	}
	return "\n" + inputText + "\n";
}






