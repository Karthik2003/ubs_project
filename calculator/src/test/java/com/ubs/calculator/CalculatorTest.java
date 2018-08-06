/**
 * 
 */
package com.ubs.calculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.calculator.exception.NotValidInputException;
import com.ubs.calculator.service.Calculator;

/**
 * @author Karthik
 *
 */
public class CalculatorTest {
	
	Calculator calc = new Calculator();
	
    @Test
    public void checkForMaxValue(){
        int max = 1000;
        Assert.assertEquals(Calculator.MAX_VALUE, max);
    }

    @Test
    public void checkAddFuncationality() throws NotValidInputException {

    	assertThat(calc.add("2,3,5"), is(10));
    }
    
    @Test
    public void checkForNegative()  {
        try {
        	calc.add("-2,-3,-5");
        } catch (Exception e) {
            assertEquals("error message", "Negatives not allowed[-2, -3, -5]", e.getMessage());
        }
    }
    
    @Test
    public void checkForInvalidInput()  {
        try {
        	calc.add("1,2,3,\n");
        } catch (Exception e) {
            assertEquals("error message", "Input ends with newline not valid", e.getMessage());
        }
    }    

//Below test case is not required as it does not cover functional use-case    
/*    @Test
    public void noNumberInput()  {
        try {
        	calc.add("safdsafadfd");
        } catch (Exception e) {
            assertEquals("error message", "Input does not consists of number", e.getMessage());
        }
    }*/
    
    @Test
    public void checkNumberLimitMore() throws NotValidInputException {

    	assertThat(calc.add("2,3,1001,5"), is(10));
    }
    
    @Test
    public void checkNumberLimit() throws NotValidInputException {

    	assertThat(calc.add("2,3,1000,5"), is(1010));
    }
    
    @Test
    public void assertDelimiterChar() throws NotValidInputException {

    	assertThat(calc.add("//;\n1;2"), is(3));
    }
    
    @Test
    public void assertDelimiterString() throws NotValidInputException {

    	assertThat(calc.add("//***\n1***2***3"), is(6));
    }
    
    @Test
    public void assertMultiDelimiterChar() throws NotValidInputException {

    	assertThat(calc.add("//*|%\n1*2%3"), is(6));
    }
    
    @Test
    public void assertMultiDelimiterString() throws NotValidInputException {

    	assertThat(calc.add("//****|%%%%\n1****2%%%%3"), is(6));
    }

}
