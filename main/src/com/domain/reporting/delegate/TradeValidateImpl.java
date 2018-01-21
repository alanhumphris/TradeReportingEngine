/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.delegate;

import com.domain.reporting.model.Instruction;
import com.domain.reporting.model.InstructionValidated;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public class TradeValidateImpl implements TradeValidate {

    @Override
    public List<InstructionValidated> validate(List<Instruction> instructions) {
        List<InstructionValidated> result = new ArrayList();
        
        instructions.stream().forEach(e ->  validate(result, e));
        
        return result;
    }

    protected void validate(List<InstructionValidated> result, Instruction instruction) {
        InstructionValidated newOne = new InstructionValidated(instruction);
        
        if ((instruction.getAgreedFx() == null)
                || (instruction.getBuySellFlag() == null)
                || (instruction.getCurrencyCode() == null)
                || (instruction.getEntityName() == null)
                || (instruction.getInstructionDate() == null)
                || (instruction.getPricePerUnit() == null)
                || (instruction.getSettlementDate() == null)
                || (instruction.getUnits() == null)) {
            newOne.setValid(Boolean.FALSE);
        }
        
        result.add(newOne);
    }
}
