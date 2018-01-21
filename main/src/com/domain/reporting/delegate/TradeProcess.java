/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.delegate;

import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.model.InstructionValidated;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public interface TradeProcess {

    List<InstructionProcessed>  process(List<InstructionValidated> instructions);
    
}
