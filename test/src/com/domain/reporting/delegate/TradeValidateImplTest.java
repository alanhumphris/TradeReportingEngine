/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.delegate;

import com.domain.reporting.TestDataHelper;
import com.domain.reporting.model.Instruction;
import com.domain.reporting.model.InstructionValidated;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alan Humphris
 */
public class TradeValidateImplTest {
        
    private TradeValidateImpl classUnderTest;
    
    @Before
    public void setUp() throws Exception {
        classUnderTest = new TradeValidateImpl();
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest  = null;
    }   
    
    @Test
    public void shouldValidatePass() {
        List<InstructionValidated> list = new ArrayList();
        
        classUnderTest.validate(list, TestDataHelper.INSTRUCTION_AED_1);
        Assert.assertTrue(list.get(0).isValid());
        list = new ArrayList();

        classUnderTest.validate(list, TestDataHelper.INSTRUCTION_SAR_1);
        Assert.assertTrue(list.get(0).isValid());
        list = new ArrayList();

        classUnderTest.validate(list, TestDataHelper.INSTRUCTION_USD_1);
        Assert.assertTrue(list.get(0).isValid());
    }

    @Test
    public void shouldValidateFail() {
        List<InstructionValidated> list = new ArrayList();

        Instruction instruction = new Instruction(null, null, null, null, null, null, null, null);
        classUnderTest.validate(list, instruction);
        Assert.assertFalse(list.get(0).isValid());
        list = new ArrayList();

        instruction = new Instruction("Some", null, null, null, null, null, null, null);
        classUnderTest.validate(list, instruction);
        Assert.assertFalse(list.get(0).isValid());
        list = new ArrayList();
        
        instruction = new Instruction("Some", "B", null, null, null, null, null, null);
        classUnderTest.validate(list, instruction);
        Assert.assertFalse(list.get(0).isValid());
        list = new ArrayList();
        
        instruction = new Instruction("Some", "B", 1.0, null, null, null, null, null);
        classUnderTest.validate(list, instruction);
        Assert.assertFalse(list.get(0).isValid());
        list = new ArrayList();
        
        instruction = new Instruction("Some", "B", 1.0, "GBP", null, null, null, null);
        classUnderTest.validate(list, instruction);
        Assert.assertFalse(list.get(0).isValid());
        list = new ArrayList();
        
        instruction = new Instruction("Some", "B", 1.0, "GBP", LocalDate.of(2018, 1, 1), null, null, null);
        classUnderTest.validate(list, instruction);
        Assert.assertFalse(list.get(0).isValid());
        list = new ArrayList();
        
        instruction = new Instruction("Some", "B", 1.0, "GBP", LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 1), null, null);
        classUnderTest.validate(list, instruction);
        Assert.assertFalse(list.get(0).isValid());
        list = new ArrayList();
        
        instruction = new Instruction("Some", "B", 1.0, "GBP", LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 1), 1L, null);
        classUnderTest.validate(list, instruction);
        Assert.assertFalse(list.get(0).isValid());
        list = new ArrayList();
        
        instruction = new Instruction("Some", "B", 1.0, "GBP", LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 1), 1L, 1.0);
        classUnderTest.validate(list, instruction);
        Assert.assertTrue(list.get(0).isValid());
    }
}
