/*
 * Compare.cpp
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

/*
 * Compares two files line by line.
 * Outputs to console line numbers of differences
 * @param string (path/name of a file)
 * @param string (path/name of a file)
 * @return bool (false if there is a difference in 1 or more lines)
 */
bool comp(string file1, string file2) {

	ifstream f1;
	ifstream f2;
	f1.open(file1.c_str());
	f2.open(file2.c_str());

	string curr1, curr2;
	int lineNum = 0;

	bool diff;

	if (f1.is_open() && f2.is_open()) {
		while (getline(f1, curr1)) {
			getline(f2, curr2);
			lineNum++;
			if (curr1.compare(curr2) != 0) {
				diff = true;
				cout << "Different @ line " << lineNum << endl;
			}
		}
	} else {
		cout << "Unable to open files to compare." << endl;
	}
	f1.close();
	f2.close();
	cout << "Finished comparing files." << endl;

	return diff;
}

