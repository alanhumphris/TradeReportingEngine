/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alan Humphris
 */
public enum EnumTradeDirection {
    
    INCOMING("S", "Sell"),//
    OUTGOING("B", "Buy"),//
    UNKNOWN("U", "Unknown");
    
    private final String description;
    private final String buySellFlag;

    // reverse-lookup map for getting a EnumTradeDirection from a buy/sell flag
    private static final Map<String, EnumTradeDirection> lookup = new HashMap<String, EnumTradeDirection>();
    
    static {
        for (EnumTradeDirection etd : EnumTradeDirection.values()) {
            lookup.put(etd.getBuySellFlag(), etd);
        }
    }    
    
    private EnumTradeDirection(String buySellFlag, String description) {
        this.buySellFlag = buySellFlag;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getBuySellFlag() {
        return buySellFlag;
    }
    
    public static EnumTradeDirection get(String buySellFlag) {
        EnumTradeDirection result = lookup.get(buySellFlag);

        if (result == null) {
            result = EnumTradeDirection.UNKNOWN;
        }

        return result;
    }

    public static boolean contains(String buySellFlag) {
        boolean result = lookup.get(buySellFlag) != null;

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        result.append("EnumTradeDirection{");
        result.append("name: ");
        result.append(this.name());
        result.append(", buySellFlag=");
        result.append(buySellFlag);
        result.append("description=");
        result.append(description);
        result.append('}');
        
        return result.toString();
    }
    
    
}
