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
abstract public class ReportLine {
    
    abstract public String reportLine();
    
    abstract public String reportChecksum();
    
    abstract public Boolean isDataLine();
}
