/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.model;

/**
 *
 * @author Alan Humphris
 */
public class InstructionValidated {

    private final Instruction instruction;

    private Boolean valid = Boolean.TRUE;


    public InstructionValidated(Instruction instruction) {
        if (instruction == null) {
            throw new RuntimeException("InstructionValidated(Instruction) constructor - instruction is null");
        }
        this.instruction = instruction;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
