/*
 * found.cpp
 *
 *  Created on: Jul 14, 2014
 *      Author: Meredith
 */

#include <string>
#include "found.h"

using namespace std;

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
