/*
 * JUnitParser.cpp
 *
 *  Created on: Jun 27, 2014
 *      Author: Kyle Haptonstall
 *      Description: JUnit Parser was created to work with JUnit test
 *      	cases that come as a result of the Android GUI Ripper/Crawler.
 *      	JUnitParser.cpp goes through these JUnit test cases and replaces
 *      	a method "fireEvent," that often crashed the test, with a Robotium method.
 *
 *      	Using JUnitParser: Make sure that the JUnit file you are parsing is
 *      		in the same workspace folder as JUnitParser.cpp. Replace the name
 *      		of both the infile and outfile as commented below. Build and run.
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

string parser(string inputText);


int main(int argc, char** argv) {
	ifstream infile;
	infile.open("File.java"); //Replace with your JUnit file name
	string currLine;
	string nextLine;
	ofstream outfile;
	outfile.open("output.java"); //Replace with desired output JUnit name

	outfile << "//Parser replaces non-working fireEvent calls in testTrace with" <<
			'\n' << "//working Robotium methods." << '\n';

	if(infile.is_open()){
		while(getline(infile, currLine)){
			if(currLine.find("fireEvent") != std::string::npos){
				getline(infile, nextLine);
				outfile << parser(currLine + nextLine) << '\n';
			}else{
				outfile << parser(currLine) << '\n';
			}
		}
	}
	else{
		cout << "Unable to open";
	}
	infile.close();


	outfile.close();
	return 0;
}

/**
 * parser finds "fireEvent" method calls and replaces them with
 * working Robotium calls
 * @param string inputText
 * @return new Robotium call as a string
 */
string parser(string inputText){
	//find returns npos if string not found
	//So if string is found...
	if(inputText.find("fireEvent") != std::string::npos){
		if(inputText.find("changeOrientation") != std::string::npos){
			return "\t \tsolo.setActivityOrientation(Solo.LANDSCAPE);";
		}
		else if(inputText.find("back") != std::string::npos){
			return "\t \tsolo.goBack();";
		}
		else if(inputText.find("openMenu") != std::string::npos){
			return "\t \tsolo.sendKey(Solo.MENU);";
		}
		else if(inputText.find("click") != std::string::npos){

			vector<string> string_list;
			istringstream ss(inputText);
			string token;
			while(getline(ss, token, ',')){
				string_list.push_back(token);
			}
			if(string_list.size() == 5){
				return "\t \tsolo.clickOnButton(" + string_list[2] + ");";
			}
			else{
				return inputText;
			}
		}
	}
	else{
		return inputText;
	}
	return "";
}


