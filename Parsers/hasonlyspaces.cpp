/*
 * hasonlyspaces.cpp
 *
 *  Created on: Jul 14, 2014
 *      Author: Meredith
 */

#include <string>
#include "hasonlyspaces.h"

using namespace std;

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
