/**
 * 
 */
package com.ubs.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ubs.calculator.exception.NotValidInputException;
import com.ubs.calculator.util.ParserUtil;

/**
 * @author Karthik
 *
 */
public class Calculator implements ICalculator {

	/**
	 * 
	 */
	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ubs.calculator.service.ICalculator#add(java.lang.String)
	 */
	public int add(String numbers) throws NotValidInputException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(numbers)) {// usecase-1
			return 0;
		} else {
			ParserUtil.validate(numbers);
			String delimiter = null;
			if (!ParserUtil.defaultDelimiterExists(numbers)) {
				numbers = numbers.replaceAll(ParserUtil.newLine, ParserUtil.defaultDelimiter);
			} else {
				delimiter = ParserUtil.findDelimiter(numbers);
				numbers = numbers.substring(numbers.indexOf(ParserUtil.newLine) + 1, numbers.length());
				numbers = numbers.replace(delimiter, ParserUtil.defaultDelimiter);
			}
			
			String digits[] = numbers.split(ParserUtil.defaultDelimiter);

			int output = 0;
			List<String> negativeList = new ArrayList<String>();
			for (String value : digits) {
				if (Integer.parseInt(value) < 0) {// negative number message
					negativeList.add(value);
				}
				if (Integer.parseInt(value) > Calculator.MAX_VALUE) {// number bigger than 1000
					output = output + 0;
				} else {
					output = output + Integer.parseInt(value);
				}
			}
			if (negativeList.size() > 0) {
				throw new NotValidInputException("Negatives not allowed" + negativeList);
			}
			return output;
		}
	}

	// This need to be removed during final build
	public static void main(String[] args) throws NotValidInputException {
		Calculator calc = new Calculator();
		System.out.println("-------------" + calc.add("//***\n1***2***3"));
	}

}
