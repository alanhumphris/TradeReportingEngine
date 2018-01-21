/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.delegate;

import com.domain.reporting.TestDataHelper;
import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.report.DTRFromStreamImpl;
import com.domain.reporting.report.DailyTradeReport;
import com.domain.reporting.report.core.ReportLine;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alan Humphris
 */
public class PublishToConsoleImplTest {
    
    // used to create large datasets. You will begin to see seem some delay in running tests at 1,000,000 
    private static final Long NUMBER_OF_INSTRUCTIONS_TO_CREATE = 10000L;
    
    private PublishToConsoleImpl classUnderTest;
    private DailyTradeReport dailyTradeReport;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new PublishToConsoleImpl();
        dailyTradeReport = new DTRFromStreamImpl();
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
        dailyTradeReport = null;
    }   
    
    @Test
    public void shouldPrintDailySettlementIncomingSummary() {
        List<InstructionProcessed> data = TestDataHelper.generateRandomData(NUMBER_OF_INSTRUCTIONS_TO_CREATE).getProcessedInstructions();
        List<ReportLine> report = dailyTradeReport.dailySettlementIncomingSummary(data);
        classUnderTest.publish(report); 
    }
    
    @Test
    public void shouldPrintDailySettlementOutgoingSummary() {
        List<InstructionProcessed> data = TestDataHelper.generateRandomData(NUMBER_OF_INSTRUCTIONS_TO_CREATE).getProcessedInstructions();
        List<ReportLine> report = dailyTradeReport.dailySettlementOutgoingSummary(data);
        classUnderTest.publish(report); 
    }
    
    @Test
    public void shouldPrintEntityRanking() {
        List<InstructionProcessed> data = TestDataHelper.generateRandomData(NUMBER_OF_INSTRUCTIONS_TO_CREATE).getProcessedInstructions();
        List<ReportLine> report = dailyTradeReport.entityRanking(data);
        classUnderTest.publish(report); 
    }
}
