/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.model;

import java.time.LocalDate;

/**
 * An instruction to buy or sell
 *
 * @author Alan Humphris
 */
public final class Instruction {

    /**
     * A financial entity whose shares are to be bought or sold
     */
    private final String entityName;

    /**
     * B – Buy – outgoing; S – Sell – incoming
     */
    private final String buySellFlag;

    /**
     * the foreign exchange rate with respect to USD that was agreed
     */
    private final Double agreedFx;

    /**
     * code of currency
     */
    private final String currencyCode;

    /**
     * Date on which the instruction was sent to JP Morgan by various clients
     */
    private final LocalDate instructionDate;

    /**
     * The date on which the client wished for the instruction to be settled
     * with respect to Instruction Date
     */
    private final LocalDate settlementDate;

    /**
     * Number of shares to be bought or sold
     */
    private final Long units;

    /**
     * trade price of each unit
     */
    private final Double pricePerUnit;

    public Instruction(String entityName, String buySellFlag, Double agreedFx, String currencyCode, LocalDate instructionDate, LocalDate settlementDate, Long units, Double pricePerUnit) {
        this.entityName = entityName;
        this.buySellFlag = buySellFlag;
        this.agreedFx = agreedFx;
        this.currencyCode = currencyCode;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getBuySellFlag() {
        return buySellFlag;
    }

    public Double getAgreedFx() {
        return agreedFx;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public Long getUnits() {
        return units;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

}
