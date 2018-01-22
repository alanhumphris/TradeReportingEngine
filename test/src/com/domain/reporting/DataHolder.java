/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting;

import com.domain.reporting.model.Instruction;
import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.model.InstructionValidated;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public final class DataHolder {

    private final List<Instruction> instructions;
    private final List<InstructionValidated> validatedInstructions;
    private final List<InstructionProcessed> processedInstructions;

    public DataHolder(List<Instruction> instructions, List<InstructionValidated> validatedInstructions, List<InstructionProcessed> processedInstructions) {
        this.instructions  = instructions;
        this.validatedInstructions = validatedInstructions;
        this.processedInstructions  = processedInstructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public List<InstructionValidated> getValidatedInstructions() {
        return validatedInstructions;
    }

    public List<InstructionProcessed> getProcessedInstructions() {
        return processedInstructions;
    }
   
}
