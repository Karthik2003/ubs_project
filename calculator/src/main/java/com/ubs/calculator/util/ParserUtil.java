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
	public static final String newLine = "\n";
	public static final String startInput = "//";

//Below check is not required as it does not cover functional use-case  
/*	public static boolean checkNumberPresent(String input) {
		return input.matches(numberPresentRegex);
	}*/

	public static void validate(String input) throws NotValidInputException {
		
		if (input.endsWith(newLine)) {
			throw new NotValidInputException("Input ends with newline not valid");
		}
		
//Below check is not required as it does not cover functional use-case  
/*		if (!checkNumberPresent(input)) {
			throw new NotValidInputException("Input does not consists of number");
		} */
	}

	public static boolean defaultDelimiterExists(String input) {

		return input.startsWith(startInput) ? true : false;
	}
	
	public static String findDelimiter(String input) {
		
		return input.substring(input.indexOf(startInput) + 2, input.indexOf(newLine));
	}
	
	
}
