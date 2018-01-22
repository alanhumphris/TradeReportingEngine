/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.report.core;

/**
 *
 * @author Alan Humphris
 */
public final class SimpleText extends ReportLine {

    private final String header;

    public SimpleText(String header) {
        this.header = header;
    }
    
    @Override
    public String reportLine() {
        return header;
    }

    @Override
    public String reportChecksum() {
        return "0";
    }
    
    @Override
    public Boolean isDataLine() {
        return Boolean.FALSE;
    }
    
}
