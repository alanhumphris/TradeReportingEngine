/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.delegate;

import com.domain.reporting.TestDataHelper;
import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.model.InstructionValidated;
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
public class TradeProcessImplTest {

    private TradeProcessImpl classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new TradeProcessImpl();
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
    }

    @Test
    public void shouldProcessNothing() {
        List<InstructionProcessed> result = classUnderTest.process(new ArrayList());
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void shouldProcess() {
        List<InstructionValidated> data = new ArrayList();
        data.add(TestDataHelper.INSTRUCTION_VALIDATED_AED_1);
        data.add(TestDataHelper.INSTRUCTION_VALIDATED_USD_1);
        data.add(TestDataHelper.INSTRUCTION_VALIDATED_SAR_1);
        
        List<InstructionProcessed> result = classUnderTest.process(data);
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }
}
