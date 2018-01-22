/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.report;

import com.domain.reporting.BaseTest;
import com.domain.reporting.report.core.ReportLine;
import com.domain.reporting.TestDataHelper;
import com.domain.reporting.model.EnumTradeDirection;
import com.domain.reporting.model.InstructionProcessed;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alan Humphris
 */
public class DTRFromStreamImplTest extends BaseTest {

    // used to create large datasets. You will begin to see seem some delay in running tests at 1,000,000 
    private static final Long NUMBER_OF_INSTRUCTIONS_TO_CREATE = 100000L;
    
    private DTRFromStreamImpl classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new DTRFromStreamImpl();
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
    }

    @Test
    public void shouldGenerateEmptyIncomingDailySummary() {
        Map<LocalDate, Double> result = classUnderTest.generateDailySummary(null, EnumTradeDirection.INCOMING);
        Assert.assertNull("Unexpectedly not null for null parameter", result);

        result = null;
        
        result = classUnderTest.generateDailySummary(new ArrayList(), EnumTradeDirection.INCOMING);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List not empty", 0, result.size());
    }

    @Test
    public void shouldGenerateEmptyOutgoingDailySummary() {
        Map<LocalDate, Double> result = classUnderTest.generateDailySummary(null, EnumTradeDirection.OUTGOING);
        Assert.assertNull("Unexpectedly not null for null parameter", result);

        result = null;
        
        result = classUnderTest.generateDailySummary(new ArrayList(), EnumTradeDirection.OUTGOING);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List not empty", 0, result.size());
    }

    @Test
    public void shouldGenerateEmptyEntityRankingForIncoming() {
        Map<String, Optional<InstructionProcessed>> result = classUnderTest.generateEntityRanking(null, EnumTradeDirection.INCOMING);
        Assert.assertNull("Unexpectedly not null for null parameter", result);

        result = null;
        
        result = classUnderTest.generateEntityRanking(new ArrayList(), EnumTradeDirection.INCOMING);
        
       Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List not empty", 0, result.size());
    }

    @Test
    public void shouldGenerateEmptyEntityRankingForOutgoing() {
        Map<String, Optional<InstructionProcessed>> result = classUnderTest.generateEntityRanking(null, EnumTradeDirection.OUTGOING);
        Assert.assertNull("Unexpectedly not null for null parameter", result);

        result = null;
        
        result = classUnderTest.generateEntityRanking(new ArrayList(), EnumTradeDirection.OUTGOING);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List not empty", 0, result.size());
    }

    @Test
    public void shouldGenerateSimpleIncomingDailySummary() {
        Map<LocalDate, Double> result = null;
        List<InstructionProcessed> data = new ArrayList();

        data.add(TestDataHelper.INSTRUCTION_PROCESSED_SGP_1);
        data.add(TestDataHelper.INSTRUCTION_PROCESSED_AED_1);

        result = classUnderTest.generateDailySummary(data, EnumTradeDirection.INCOMING);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List size incorrect", 1, result.size());
        Assert.assertEquals("List size incorrect", new Double(14899.5), result.values().iterator().next());
    }

    @Test
    public void shouldGenerateSimpleOutgoingDailySummary() {
        Map<LocalDate, Double>  result = null;
        List<InstructionProcessed> data = new ArrayList();

        data.add(TestDataHelper.INSTRUCTION_PROCESSED_SGP_1);
        data.add(TestDataHelper.INSTRUCTION_PROCESSED_AED_1);

        result = classUnderTest.generateDailySummary(data, EnumTradeDirection.OUTGOING);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List size incorrect", 1, result.size());
        Assert.assertEquals("List size incorrect", new Double(10025.0), result.values().iterator().next());
    }

    @Test
    public void shouldGenerateSimpleEntityRankingForIncoming() {
        Map<String, Optional<InstructionProcessed>> result = null;
        List<InstructionProcessed> data = new ArrayList();

        data.add(TestDataHelper.INSTRUCTION_PROCESSED_SGP_1);
        data.add(TestDataHelper.INSTRUCTION_PROCESSED_AED_1);
      
        result = classUnderTest.generateEntityRanking(data, EnumTradeDirection.INCOMING);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List size incorrect", 1, result.size());
        Assert.assertEquals("Expected value incorrect", new Double(14899.5), result.values().iterator().next().get().getTradeValueUSD());
    }
    
    @Test
    public void shouldGenerateSimpleEntityRankingForOutgoing() {
        Map<String, Optional<InstructionProcessed>> result = null;
        List<InstructionProcessed> data = new ArrayList();

        data.add(TestDataHelper.INSTRUCTION_PROCESSED_SGP_1);
        data.add(TestDataHelper.INSTRUCTION_PROCESSED_AED_1);

        result = classUnderTest.generateEntityRanking(data, EnumTradeDirection.OUTGOING);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List size incorrect", 1, result.size());
        Assert.assertEquals("Expected value incorrect", new Double(10025.0), result.values().iterator().next().get().getTradeValueUSD());
    }
    
    @Test
    public void shouldRunEmptyIncomingDailySummary() {
        // note List<ReportLine> result contains boilerplate text lines, so will always contain some rows
        List<ReportLine> result = classUnderTest.dailySettlementIncomingSummary(null);
        Assert.assertNotNull("Unexpectedly null for null parameter", result);
        Assert.assertEquals("List not empty", 3, result.size());

        result = null;
        
        result = classUnderTest.dailySettlementIncomingSummary(new ArrayList());
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List not empty", 3, result.size());
    }

    @Test
    public void shouldRunEmptyOutgoingDailySummary() {
        // note List<ReportLine> result contains boilerplate text lines, so will always contain some rows
        List<ReportLine> result = null;
        result = classUnderTest.dailySettlementOutgoingSummary(null);
        Assert.assertNotNull("Unexpectedly null for null parameter", result);
        Assert.assertEquals("List not empty", 3, result.size());

        result = null;
        
        result = classUnderTest.dailySettlementOutgoingSummary(new ArrayList());
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List not empty", 3, result.size());
    }

    @Test
    public void shouldRunEmptyEntityRanking() {
        // note List<ReportLine> result contains boilerplate text lines, so will always contain some rows
        List<ReportLine> result = classUnderTest.entityRanking(null);
        Assert.assertNotNull("Unexpectedly null for null parameter", result);
        Assert.assertEquals("List not empty", 3, result.size());

        result = null;
        
        result = classUnderTest.entityRanking(new ArrayList());
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List not empty", 3, result.size());
    }

    @Test
    public void shouldRunSimpleIncomingDailySummary() {
        // note List<ReportLine> result contains boilerplate text lines, so will always contain some rows
        List<ReportLine> result = null;
        List<InstructionProcessed> data = new ArrayList();

        data.add(TestDataHelper.INSTRUCTION_PROCESSED_SGP_1);
        data.add(TestDataHelper.INSTRUCTION_PROCESSED_AED_1);

        result = classUnderTest.dailySettlementIncomingSummary(data);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List size incorrect", 3, result.size());
        Assert.assertEquals("List size incorrect", "14899.50", result.get(1).reportChecksum());
    }

    @Test
    public void shouldRunSimpleOutgoingDailySummary() {
        // note List<ReportLine> result contains boilerplate text lines, so will always contain some rows
        List<ReportLine> result = null;
        List<InstructionProcessed> data = new ArrayList();

        data.add(TestDataHelper.INSTRUCTION_PROCESSED_SGP_1);
        data.add(TestDataHelper.INSTRUCTION_PROCESSED_AED_1);

        result = classUnderTest.dailySettlementOutgoingSummary(data);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List size incorrect", 3, result.size());
        Assert.assertEquals("List size incorrect", "10025.00", result.get(1).reportChecksum());
    }

    @Test
    public void shouldRunSimpleEntityRanking() {
        // note List<ReportLine> result contains boilerplate text lines, so will always contain some rows
        List<ReportLine> result = null;
        List<InstructionProcessed> data = new ArrayList();

        data.add(TestDataHelper.INSTRUCTION_PROCESSED_SGP_1);
        data.add(TestDataHelper.INSTRUCTION_PROCESSED_AED_1);

        result = classUnderTest.entityRanking(data);
        
        Assert.assertNotNull("Unexpectedly null for new ArrayList() parameter", result);
        Assert.assertEquals("List size incorrect", 7, result.size());
        Assert.assertEquals("List size incorrect", "10025.00", result.get(2).reportChecksum());
        Assert.assertEquals("List size incorrect", "14899.50", result.get(5).reportChecksum());
    }

    @Test
    public void shouldGenerateLargeIncomingDailySummary() {
        Map<LocalDate, Double> result = null;
        List<InstructionProcessed> data = TestDataHelper.generateRandomData(NUMBER_OF_INSTRUCTIONS_TO_CREATE).getProcessedInstructions();

        long startTime = System.currentTimeMillis();
        
        result = classUnderTest.generateDailySummary(data, EnumTradeDirection.INCOMING);
        
        long endTime = System.currentTimeMillis();
        displayTimeDiff(DTRFromStreamImpl.class, "generateDailySummary Incoming", startTime,endTime);

        Assert.assertNotNull("Unexpectedly null", result);
    }

    @Test
    public void shouldGenerateLargeOutgoingDailySummary() {
        Map<LocalDate, Double>  result = null;
        List<InstructionProcessed> data = TestDataHelper.generateRandomData(NUMBER_OF_INSTRUCTIONS_TO_CREATE).getProcessedInstructions();

        long startTime = System.currentTimeMillis();
        
        result = classUnderTest.generateDailySummary(data, EnumTradeDirection.OUTGOING);
        
        long endTime = System.currentTimeMillis();
        displayTimeDiff(DTRFromStreamImpl.class, "generateDailySummary Outgoing", startTime,endTime);

        Assert.assertNotNull("Unexpectedly null", result);
    }

    @Test
    public void shouldGenerateLargeEntityRankingForIncoming() {
        Map<String, Optional<InstructionProcessed>> result = null;
        List<InstructionProcessed> data = TestDataHelper.generateRandomData(NUMBER_OF_INSTRUCTIONS_TO_CREATE).getProcessedInstructions();

        long startTime = System.currentTimeMillis();
        
        result = classUnderTest.generateEntityRanking(data, EnumTradeDirection.INCOMING);
        
        long endTime = System.currentTimeMillis();
        displayTimeDiff(DTRFromStreamImpl.class, "generateEntityRanking Incoming", startTime,endTime);

        Assert.assertNotNull("Unexpectedly null", result);
    }
    
    @Test
    public void shouldGenerateLargeEntityRankingForOutgoing() {
        Map<String, Optional<InstructionProcessed>> result = null;
        List<InstructionProcessed> data = TestDataHelper.generateRandomData(NUMBER_OF_INSTRUCTIONS_TO_CREATE).getProcessedInstructions();

        long startTime = System.currentTimeMillis();
        
        result = classUnderTest.generateEntityRanking(data, EnumTradeDirection.OUTGOING);
        
        long endTime = System.currentTimeMillis();
        displayTimeDiff(DTRFromStreamImpl.class, "generateEntityRanking Outgoing", startTime,endTime);

        Assert.assertNotNull("Unexpectedly null", result);
    }

    
}
