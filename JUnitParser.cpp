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

//itoa
#include <stdio.h>
//itoa
#include <stdlib.h>
using namespace std;

string parser(string inputText, string vers);
int classRenames;


int main(int argc, char** argv) {
	ifstream infile;
	//change this string to the path of your jUnit test project::
	string path = "C:/Users/Meredith/workspace/WPTest_2/src/org/wordpress/android/test";
	path += "/Wordpress_Test2_";
	cout << "Test version number: ";
	string version; cin >> version;
	path = path + version;
	infile.open((path + ".java").c_str());	//opens input file
	string currLine;
	string nextLine;
	ofstream outfile;
	path = path + "_parsed.java";
	outfile.open((path + ".java").c_str()); //opens output file

	outfile << "//Parser replaces non-working fireEvent calls in testTrace with" <<
			'\n' << "//working Robotium methods." << '\n';

	if(infile.is_open()){
		while(getline(infile, currLine)){
			if(currLine.find("fireEvent") != std::string::npos){
				if(currLine.find("changeOrientation") == std::string::npos &&
				   currLine.find("back") == std::string::npos &&
				   currLine.find("openMenu") == std::string::npos &&
				   currLine.find("click") == std::string::npos){

					outfile << currLine << '\n';
				}else{
					getline(infile, nextLine);
					outfile << parser(currLine + nextLine, version) << '\n';
				}
			}else{
				outfile << parser(currLine, version) << '\n';
			}
		}
	}
	else{
		cout << "Unable to open";
	}
	infile.close();
	outfile.close();
	cout << "DONE." << endl;
	return 0;
}

/**
 * parser finds "fireEvent" method calls and replaces them with
 * working Robotium calls
 * @param string inputText
 * @return new Robotium call as a string
 */
string parser(string inputText, string version){
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
			if(string_list.size() <= 5){
				return "\t \tsolo.clickOnButton(" + string_list[2] + ");";
			}
			else{
				return inputText;
			}
		}
	}
	//Corrects class & constructor names to match new file name
	else if (classRenames < 3) {
		//these are the two likely class names
		if((inputText.find("AndroidGuiTest") != std::string::npos) || (inputText.find("Wordpress_Test2") != std::string::npos)){
			if(inputText.find("class") != std::string::npos) {
				classRenames++;
				return ("public class Wordpress_Test2_" + version + "_parsed extends ActivityInstrumentationTestCase2 {");
			}
			else {
				classRenames++;
				return ("	public Wordpress_Test2_" + version + "_parsed () {");
			}
		}
	}
	else{
		return inputText;
	}
	return "";
}


