/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.delegate;

import com.domain.reporting.model.Instruction;
import com.domain.reporting.model.InstructionValidated;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public interface TradeValidate {
    
    List<InstructionValidated> validate(List<Instruction> instructions);
    
}
