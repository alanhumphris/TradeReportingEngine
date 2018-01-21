/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting;

import com.domain.reporting.model.Instruction;
import com.domain.reporting.model.InstructionProcessed;
import com.domain.reporting.model.InstructionValidated;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public class DataHolder {

    List<Instruction> instructions;
    List<InstructionValidated> validatedInstructions;
    List<InstructionProcessed> processedInstructions;

    public DataHolder() {
        this.instructions  = new ArrayList();
        this.processedInstructions  = new ArrayList();
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    } 

    public List<InstructionValidated> getValidatedInstructions() {
        return validatedInstructions;
    }

    public void setValidatedInstructions(List<InstructionValidated> validatedInstructions) {
        this.validatedInstructions = validatedInstructions;
    }

    public List<InstructionProcessed> getProcessedInstructions() {
        return processedInstructions;
    }

    public void setProcessedInstructions(List<InstructionProcessed> processedInstructions) {
        this.processedInstructions = processedInstructions;
    }
    
}
