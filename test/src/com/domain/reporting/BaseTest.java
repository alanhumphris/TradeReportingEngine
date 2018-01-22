/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting;

/**
 *
 * @author Alan Humphris
 */
public class BaseTest {
        
    protected void displayTimeDiff(Class klass, String methodInfo, long startTime, long endTime) {
        long diff = endTime - startTime;
        
        System.out.println(klass.getSimpleName() + " " + methodInfo + ": Elapsed time in milliseconds: " + diff);
    }

    
}
