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
			if (!ParserUtil.defaultDelimiterExists(numbers)) {
				String digits[] = numbers.split(ParserUtil.defaultDelimiter);

				int output = 0;
				List<String> negativeList = new ArrayList<String>();
				for (String value : digits) {
					if (Integer.parseInt(value) < 0) {//negative number message
						negativeList.add(value);
					}
					if (Integer.parseInt(value) > Calculator.MAX_VALUE){// number bigger than 1000
						output = output + 0;
					} else {
						output = output + Integer.parseInt(value);
					}
					
				}
				if (negativeList.size() > 0) {
					throw new NotValidInputException("Negatives not allowed" + negativeList);
				}
				return output;
			} else {
				//TODO: implement logic for multiple delimiter 
			}
			return 0;
		}
	}
	//This need to be removed during final build
	public static void main(String[] args) throws NotValidInputException {
		Calculator calc = new Calculator();
		System.out.println("#############"+calc.add("1,3,1000,5"));
	}

}
