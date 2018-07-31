/**
 * 
 */
package com.ubs.calculator.util;

/**
 * @author Karthik
 *
 */
public class ParserUtil {
	
	public static final String numberPresentRegex = "-?\\d+";
	
	public static boolean checkNumberPresent(String input) {
	        return input.matches(numberPresentRegex);
	    }
	

}
