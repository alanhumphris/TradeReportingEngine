/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.service;

import com.domain.reporting.TestDataHelper;
import com.domain.reporting.model.Instruction;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alan Humphris
 */
public class TradeReportingServiceImplTest {
    
    private TradeReportingServiceImpl classUnderTest;
    
    @Before
    public void setUp() throws Exception {
        classUnderTest = new TradeReportingServiceImpl();
    }
    
    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
    }
    
    @Test
    public void shouldRunReportsWhenEmpty() {
        classUnderTest.runReports(new ArrayList());
    }
    
    @Test
    public void shouldRunReports() {
        List<Instruction> data = new ArrayList();
        data.add(TestDataHelper.INSTRUCTION_AED_1);
        data.add(TestDataHelper.INSTRUCTION_USD_1);
        data.add(TestDataHelper.INSTRUCTION_SAR_1);

        classUnderTest.runReports(data);
    }
    
}
