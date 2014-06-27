//============================================================================
// Name        : CP2.cpp
// Author      : Meredith
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <fstream>
#include <string>

using namespace std;



string deleteLeadingTabs(string line) {
	string newLine = line;
	size_t found_tab = newLine.find("\t");
	while (found_tab != string::npos) {
		newLine.erase(found_tab,1);
		found_tab = newLine.find("\t");
	}
	return (newLine);
}

string deleteAfterQuote(string line) {
	return line;
}

string button(string line) {						//fireEvent --> clickOnButton

	line = deleteLeadingTabs(line);

	//find 2nd comma, delete two more chars
	int found_comma = line.find(",");
	line.erase(0, found_comma + 1);
	found_comma = line.find(",");
	line.erase(0, found_comma + 1 + 2);
	size_t found_quote = line.find("\"");
	line.erase(found_quote, string::npos);

	string newText = "solo.clickOnButton(\"" + line + "\");";
	return (newText);
}

string key(string line) { 						// fireEvent --> sendKey/back/orientation
	line = deleteLeadingTabs(line);

	//26 "openMenu"/"back"/etc start at char[26]
	line.erase(0,27);
	size_t found_quote = line.find("\"");
	line.erase(found_quote, string::npos);
	cout << line << endl;


	string newText ="";
	if (line.compare("openMenu") == 0) {
			newText = "solo.sendKey(Solo.MENU);";
	}
	if (line.compare("back") == 0) {
			newText = "solo.goBack();";
	}
	if (line.compare("changeOrientation") == 0) {
			//keep track of orientation changes
			//add later
			//***************
			//edit!!
			newText = "solo.setActivityOrientation(Solo.LANDSCAPE);";
	}

	return (newText);
}

string enterText(string line) {	//setInput --> enterText
	return line;
}
string insideTestTrace(string line) {
	size_t found_fE = line.find("fireEvent");
	size_t found_0 = line.find("(0,");

	//fireEvent (2131099743, 9, "Add blog hosted at WordPress.com", "button", "click");
	//find 2nd comma - delete two more chars
	string newText = "";

	if (found_fE != string::npos && found_0 == string::npos) {
		return(button(line));
	}

	if (found_fE != string::npos && found_0 != string::npos) {
		return(key(line));
	}
	return "";
}


int main() {

	//input file
	ifstream infile;
	infile.open("Wp_141_GuiTest.java");
	string line;

	//output file
	ofstream outfile;
	outfile.open("Wp_141_GuiTest_parsed.java");

	//boolean: has "testTrace" been found; or, has ending "}" been found?
	bool yes = false;

	//reads each line
	while (std::getline(infile, line)) {
		if (!yes) {
			size_t found = line.find("testTrace");
			if (found != string::npos) {
				cout << "found!! @" << found << endl;
				yes = true;
			}
			else {
				outfile << line << "\n";
			}
		}
		if (yes) {
			if (line.find("}") != string::npos) {
				yes = false;
			}
			string newLine = insideTestTrace(line);
			//if == "": method did not make any changes
			if (newLine != "") {
				outfile << "\t\t" << newLine << "\n";
			}
			if (newLine == "") {
				outfile << line << "\n";
			}


		}
	}

	infile.close();
	outfile.close();

	return 0;
}

