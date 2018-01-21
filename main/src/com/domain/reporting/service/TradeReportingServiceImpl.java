/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.service;

import com.domain.reporting.delegate.PublishReport;
import com.domain.reporting.delegate.PublishToConsoleImpl;
import com.domain.reporting.delegate.TradeProcess;
import com.domain.reporting.delegate.TradeProcessImpl;
import com.domain.reporting.delegate.TradeValidate;
import com.domain.reporting.delegate.TradeValidateImpl;
import com.domain.reporting.model.Instruction;
import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.model.InstructionValidated;
import com.domain.reporting.report.core.ReportLine;
import com.domain.reporting.report.DTRFromStreamImpl;
import com.domain.reporting.report.DailyTradeReport;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public class TradeReportingServiceImpl implements TradeReportingService {

    private final TradeValidate tradeValidate = new TradeValidateImpl();
    private final TradeProcess tradeProcess = new TradeProcessImpl();
    private final DailyTradeReport dailyTradeReport = new DTRFromStreamImpl();
    private final PublishReport publishReport  = new PublishToConsoleImpl();
    
    @Override
    public void runReports(List<Instruction> instructions) {
        
        // validate batch of instructions
        List<InstructionValidated> validated = tradeValidate.validate(instructions);
        
        // process batch of instructions
        List<InstructionProcessed> processed = tradeProcess.process(validated);

        // generate daily incoming Summary
        List<ReportLine> reportLines = dailyTradeReport.dailySettlementIncomingSummary(processed);
        // publish daily incoming Summary
        publishReport.publish(reportLines);

        // generate daily outgoing Summary
        reportLines = dailyTradeReport.dailySettlementOutgoingSummary(processed);
        // publish daily outgoing Summary
        publishReport.publish(reportLines);

        // generate entity ranking
        reportLines = dailyTradeReport.entityRanking(processed);
        // publish entity ranking
        publishReport.publish(reportLines);
        
    }
    
}
