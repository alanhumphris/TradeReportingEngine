/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.model;

import java.time.LocalDate;

/**
 *
 * @author Alan Humphris
 */
public final class InstructionProcessed {

    private final Instruction instruction;
    private final LocalDate actualSettlementDate;
    private final Double tradeValueUSD;
    private final EnumCurrencyInfo currencyInfo;
    private final EnumTradeDirection tradeDirection;

    public InstructionProcessed(Instruction instruction) {
        if (instruction == null) {
            throw new RuntimeException("InstructionProcessed(Instruction) constructor - instruction is null");
        }
        this.instruction = instruction;

        this.tradeValueUSD = calculateTradeValue(instruction.getPricePerUnit(), instruction.getUnits(), instruction.getAgreedFx());
        this.currencyInfo = EnumCurrencyInfo.get(instruction.getCurrencyCode());
        this.tradeDirection = EnumTradeDirection.get(instruction.getBuySellFlag());
        
        this.actualSettlementDate = this.currencyInfo.getWorkingDay(instruction.getSettlementDate());
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public LocalDate getActualSettlementDate() {
        return actualSettlementDate;
    }

    public Double getTradeValueUSD() {
        return tradeValueUSD;
    }

    public EnumCurrencyInfo getCurrencyInfo() {
        return currencyInfo;
    }

    public EnumTradeDirection getTradeDirection() {
        return tradeDirection;
    }

    public String getEntityName() {
        return getInstruction().getEntityName();
    }
    
    
    /**
     * Price per unit * Units * Agreed Fx
     *
     * @param pricePerUnits
     * @param units
     * @param agreedFx
     * @return
     */
    final static public Double calculateTradeValue(Double pricePerUnits, Long units, Double agreedFx) {
        Double result = pricePerUnits * units * agreedFx;

        return result;
    }
}
