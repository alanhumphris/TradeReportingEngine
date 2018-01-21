/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.app;

import com.domain.reporting.model.Instruction;
import com.domain.reporting.service.TradeReportingService;
import com.domain.reporting.service.TradeReportingServiceImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public class TradeReportingEngine {

    // default test data
    private static final Instruction INSTRUCTION_FOO_1 = 
                new Instruction("foo", "B", 0.5, "SGP", LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 2), 200L, 100.25);
    private static final Instruction INSTRUCTION_BAR_1 = 
                new Instruction("bar", "S", 0.22, "AED", LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 7), 450L, 150.5);

    private static final Instruction INSTRUCTION_FOO_2 = 
                new Instruction("foo", "S", 1.0, "USD", LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 7), 200L, 100.25);
    private static final Instruction INSTRUCTION_BAR_2 = 
                new Instruction("bar", "B", 1.0, "USD", LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 4), 450L, 150.5);
    
    private static final Instruction INSTRUCTION_FOO_3 = 
                new Instruction("foo", "B", 0.5, "SGP", LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 2), 10L, 100.25);
    private static final Instruction INSTRUCTION_BAR_3 = 
                new Instruction("bar", "S", 0.22, "AED", LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 7), 10L, 150.5);

    private TradeReportingService service;
   
    public void runReports() {
        List<Instruction> data = new ArrayList();
        data.add(INSTRUCTION_FOO_1);
        data.add(INSTRUCTION_BAR_1);
        data.add(INSTRUCTION_FOO_2);
        data.add(INSTRUCTION_BAR_2);
        data.add(INSTRUCTION_FOO_3);
        data.add(INSTRUCTION_BAR_3);
                
        service = new TradeReportingServiceImpl();
        service.runReports(data);
    }
    
    public static void main(String[] args) {
        TradeReportingEngine engine = new TradeReportingEngine();
        engine.runReports();
    }

}
