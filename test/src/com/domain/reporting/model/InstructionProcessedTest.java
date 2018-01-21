/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.model;

import com.domain.reporting.TestDataHelper;
import java.time.DayOfWeek;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alan Humphris
 */
public class InstructionProcessedTest {
    
    private InstructionProcessed classUnderTest;
    
    @Before
    public void setUp() throws Exception {
        //classUnderTest  = new InstructionProcessed();
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
    }   
    
    @Test
    public void shouldCalculateTradeValue() {
        Double result = null;
        
        result = InstructionProcessed.calculateTradeValue(1.0, 1L, 1.0);
        Assert.assertEquals("trade values do not match", new Double(1.0), result);
        
        result = InstructionProcessed.calculateTradeValue(2.0, 3L, 0.5);
        Assert.assertEquals("trade values do not match", new Double(3.0), result);

        result = InstructionProcessed.calculateTradeValue(14.73, 1000000L, 0.22);
        Assert.assertEquals("trade values do not match", new Double(3240600), result);
    }
    
    @Test
    public void shouldNotConstructWithNullInstruction() {       
        try {
            InstructionProcessed ip = new InstructionProcessed(null);
            Assert.fail("Should not construct");
            ip = null; //should never get here
        } catch (RuntimeException e) {
            // should get here  
        }
    }
    
    @Test
    public void shouldLookupCurrency() {       
        InstructionProcessed ip = new InstructionProcessed(TestDataHelper.INSTRUCTION_AED_1);
        Assert.assertEquals("Incorrect currency found", EnumCurrencyInfo.UAE_DIRHAM, ip.getCurrencyInfo());

        ip = new InstructionProcessed(TestDataHelper.INSTRUCTION_SAR_1);
        Assert.assertEquals("Incorrect currency found", EnumCurrencyInfo.SAUDI_RIYAL, ip.getCurrencyInfo());

        ip = new InstructionProcessed(TestDataHelper.INSTRUCTION_USD_1);
        Assert.assertEquals("Incorrect currency found", EnumCurrencyInfo.US_DOLLAR, ip.getCurrencyInfo());

        ip = new InstructionProcessed(TestDataHelper.INSTRUCTION_SGP_1);
        Assert.assertEquals("Incorrect currency found", EnumCurrencyInfo.OTHER, ip.getCurrencyInfo());
    }
       
    @Test
    public void shouldLookupFirstDayOfWeek() {       
        InstructionProcessed ip = new InstructionProcessed(TestDataHelper.INSTRUCTION_AED_1);
        Assert.assertEquals("Incorrect currency found", DayOfWeek.SUNDAY, ip.getCurrencyInfo().getFirstDayOfWeek());

        ip = new InstructionProcessed(TestDataHelper.INSTRUCTION_SAR_1);
        Assert.assertEquals("Incorrect currency found", DayOfWeek.SUNDAY, ip.getCurrencyInfo().getFirstDayOfWeek());

        ip = new InstructionProcessed(TestDataHelper.INSTRUCTION_USD_1);
        Assert.assertEquals("Incorrect currency found", DayOfWeek.MONDAY, ip.getCurrencyInfo().getFirstDayOfWeek());

        ip = new InstructionProcessed(TestDataHelper.INSTRUCTION_SGP_1);
        Assert.assertEquals("Incorrect currency found", DayOfWeek.MONDAY, ip.getCurrencyInfo().getFirstDayOfWeek());
    }

    @Test
    public void shouldLookupTradeDirection() {       

    }
       
       
}
