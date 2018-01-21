/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.service;

import com.domain.reporting.model.Instruction;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public interface TradeReportingService {
    
    void runReports(List<Instruction> instructions);
}
