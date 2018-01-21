/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.report;

import com.domain.reporting.report.core.ReportLine;
import com.domain.reporting.model.InstructionProcessed;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public interface DailyTradeReport {
   
    /**
     * Amount in USD settled incoming everyday 
     * @param instructions - instructions
     * @return 
     */   
    List<ReportLine> dailySettlementIncomingSummary(List<InstructionProcessed> instructions);
    
    /**
     * Amount in USD settled outgoing everyday
     * @param instructions 
     * @return 
     */
    List<ReportLine> dailySettlementOutgoingSummary(List<InstructionProcessed> instructions);
    
    /**
     * Ranking of entities based on incoming and outgoing amount. 
     * E.g.: If entity foo instructs the highest amount for a buy instruction, 
     * then foo is rank 1 for outgoing
     * @param instructions 
     * @return 
     */
    List<ReportLine> entityRanking(List<InstructionProcessed> instructions);
}
