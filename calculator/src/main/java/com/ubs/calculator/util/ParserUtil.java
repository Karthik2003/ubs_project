/**
 * 
 */
package com.ubs.calculator.util;

import com.ubs.calculator.exception.NotValidInputException;

/**
 * @author Karthik
 *
 */
public class ParserUtil {

	public static final String numberPresentRegex = ".*\\d+.*";
	public static final String defaultDelimiter = ",";

	public static boolean checkNumberPresent(String input) {
		return input.matches(numberPresentRegex);
	}

	public static void validate(String input) throws NotValidInputException {
		
		if (input.endsWith("\n")) {
			throw new NotValidInputException("Input ends with newline not valid");
		}

		if (!checkNumberPresent(input)) {
			throw new NotValidInputException("Input does not consists of number");
		} 
	}

	public static boolean defaultDelimiterExists(String input) {

		return input.startsWith("//") ? true : false;
	}

}
