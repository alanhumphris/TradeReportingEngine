/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.report.core;

import com.domain.reporting.model.EnumCurrencyInfo;
import java.text.DecimalFormat;

/**
 *
 * @author Alan Humphris
 */
public final class EntityRankingReportLine extends ReportLine {
    
    private final String entityName;
    private final Double tradeValue;
    private final EnumCurrencyInfo currency;

    public EntityRankingReportLine(String entityName, Double tradeValue, EnumCurrencyInfo currency) {
        this.entityName = entityName;
        this.tradeValue = tradeValue;
        this.currency = currency;
    }

    public String getEntityName() {
        return entityName;
    }

    public Double getTradeValue() {
        return tradeValue;
    }

    public EnumCurrencyInfo getCurrency() {
        return currency;
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
        
        result.append("entity: ");
        result.append(getEntityName());
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
