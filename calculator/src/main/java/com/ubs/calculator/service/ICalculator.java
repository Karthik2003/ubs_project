/**
 * 
 */
package com.ubs.calculator.service;

import com.ubs.calculator.exception.NotValidInputException;

/**
 * @author Karthik
 *
 */
public interface ICalculator {
	
	int MAX_VALUE = 1000;

	public int add(String numbers) throws NotValidInputException;
	
}
