/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.report.core;

import com.domain.reporting.model.EnumCurrencyInfo;
import com.domain.reporting.model.EnumTradeDirection;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 *
 * @author Alan Humphris
 */
public final class SettlementReportLine extends ReportLine {
    
    private final LocalDate settlementDate;
    private final Double tradeValue;
    private final EnumCurrencyInfo currency;
    private final EnumTradeDirection tradeDirection;

    public SettlementReportLine(LocalDate settlementDate, Double tradeValue, EnumCurrencyInfo currency, EnumTradeDirection tradeDirection) {
        this.settlementDate = settlementDate;
        this.tradeValue = tradeValue;
        this.currency = currency;
        this.tradeDirection = tradeDirection;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public Double getTradeValue() {
        return tradeValue;
    }

    public EnumCurrencyInfo getCurrency() {
        return currency;
    }

    public EnumTradeDirection getTradeDirection() {
        return tradeDirection;
    }

    @Override
    public String reportChecksum() {
        DecimalFormat df2 = new DecimalFormat(".00");
        return df2.format(tradeValue);
    }
    
            
    @Override
    public String reportLine() {
        StringBuilder result = new StringBuilder();
        DecimalFormat df2 = new DecimalFormat(".00");
        
        result.append("settlement date: ");
        result.append(getSettlementDate());
        result.append(", trade value: ");
        result.append(df2.format(getTradeValue()));
        result.append("");
        result.append(getCurrency().getCurrencyCode());
        
        return result.toString();
    }
    
    @Override
    public Boolean isDataLine() {
        return Boolean.TRUE;
    }
}
