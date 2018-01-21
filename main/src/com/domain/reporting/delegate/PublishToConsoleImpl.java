/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.delegate;

import com.domain.reporting.report.core.ReportLine;
import java.util.List;

/**
 *
 * @author Alan Humphris
 */
public class PublishToConsoleImpl implements PublishReport {

    // used to create large datasets. You will begin to see seem some delay in running tests at 1,000,000 
    private static final Long NUMBER_OF_INSTRUCTIONS_TO_CREATE = 100000L;
    
    @Override
    public void publish(List<ReportLine> reportLines) {
        reportLines.stream().forEach(e -> System.out.println(e.reportLine()));
    }
    
}
