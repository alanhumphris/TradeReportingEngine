/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.delegate;

import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.model.InstructionValidated;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public class TradeProcessImpl implements TradeProcess {

    @Override
    public List<InstructionProcessed> process(List<InstructionValidated> instructions) {
        List<InstructionProcessed> result = new ArrayList();

        instructions.stream().forEach(e -> process(result, e));

        return result;
    }

    protected void process(List<InstructionProcessed> list, InstructionValidated instruction) {
        if (instruction.isValid()) {
            list.add(new InstructionProcessed(instruction.getInstruction()));
        }

    }

}
