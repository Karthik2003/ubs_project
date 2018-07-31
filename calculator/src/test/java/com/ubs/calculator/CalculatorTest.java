/**
 * 
 */
package com.ubs.calculator;

import com.ubs.calculator.service.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Karthik
 *
 */
public class CalculatorTest {
	
    @Test
    public void checkForMaxValue(){
        int max = 1000;
  
        Assert.assertEquals(Calculator.MAX_VALUE, max);
    }



}
