/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting.model;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Alan Humphris
 */
public class EnumCurrencyInfoTest {
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }   
    
    @Test
    public void shouldCalculateWorkingDayForOther() {
        LocalDate result = null;
        
        result = EnumCurrencyInfo.OTHER.getWorkingDay(LocalDate.of(2018, 1, 1));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 1), result);
        
        result = EnumCurrencyInfo.OTHER.getWorkingDay(LocalDate.of(2018, 1, 2));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 2), result);
        
        result = EnumCurrencyInfo.OTHER.getWorkingDay(LocalDate.of(2018, 1, 3));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 3), result);
        
        result = EnumCurrencyInfo.OTHER.getWorkingDay(LocalDate.of(2018, 1, 4));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 4), result);
        
        result = EnumCurrencyInfo.OTHER.getWorkingDay(LocalDate.of(2018, 1, 5));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 5), result);

        result = EnumCurrencyInfo.OTHER.getWorkingDay(LocalDate.of(2018, 01, 6));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 8), result);

        result = EnumCurrencyInfo.OTHER.getWorkingDay(LocalDate.of(2018, 01, 7));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 8), result);
        
        result = EnumCurrencyInfo.OTHER.getWorkingDay(LocalDate.of(2018, 01, 8));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 8), result);
    }

    @Test
    public void shouldCalculateWorkingDayForUSD() {
        LocalDate result = null;
        
        result = EnumCurrencyInfo.US_DOLLAR.getWorkingDay(LocalDate.of(2018, 1, 1));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 1), result);
        
        result = EnumCurrencyInfo.US_DOLLAR.getWorkingDay(LocalDate.of(2018, 1, 2));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 2), result);
        
        result = EnumCurrencyInfo.US_DOLLAR.getWorkingDay(LocalDate.of(2018, 1, 3));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 3), result);
        
        result = EnumCurrencyInfo.US_DOLLAR.getWorkingDay(LocalDate.of(2018, 1, 4));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 4), result);
        
        result = EnumCurrencyInfo.US_DOLLAR.getWorkingDay(LocalDate.of(2018, 1, 5));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 5), result);

        result = EnumCurrencyInfo.US_DOLLAR.getWorkingDay(LocalDate.of(2018, 01, 6));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 8), result);

        result = EnumCurrencyInfo.US_DOLLAR.getWorkingDay(LocalDate.of(2018, 01, 7));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 8), result);
        
        result = EnumCurrencyInfo.US_DOLLAR.getWorkingDay(LocalDate.of(2018, 01, 8));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 8), result);
    }


    @Test
    public void shouldCalculateWorkingDayForAED() {
        LocalDate result = null;
        
        result = EnumCurrencyInfo.UAE_DIRHAM.getWorkingDay(LocalDate.of(2018, 1, 1));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 1), result);
        
        result = EnumCurrencyInfo.UAE_DIRHAM.getWorkingDay(LocalDate.of(2018, 1, 2));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 2), result);
        
        result = EnumCurrencyInfo.UAE_DIRHAM.getWorkingDay(LocalDate.of(2018, 1, 3));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 3), result);
        
        result = EnumCurrencyInfo.UAE_DIRHAM.getWorkingDay(LocalDate.of(2018, 1, 4));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 4), result);
        
        result = EnumCurrencyInfo.UAE_DIRHAM.getWorkingDay(LocalDate.of(2018, 1, 5));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 7), result);

        result = EnumCurrencyInfo.UAE_DIRHAM.getWorkingDay(LocalDate.of(2018, 01, 6));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 7), result);

        result = EnumCurrencyInfo.UAE_DIRHAM.getWorkingDay(LocalDate.of(2018, 01, 7));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 7), result);
        
        result = EnumCurrencyInfo.UAE_DIRHAM.getWorkingDay(LocalDate.of(2018, 01, 8));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 8), result);
    }

    @Test
    public void shouldCalculateWorkingDayForSAR() {
        LocalDate result = null;
        
        result = EnumCurrencyInfo.SAUDI_RIYAL.getWorkingDay(LocalDate.of(2018, 1, 1));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 1), result);
        
        result = EnumCurrencyInfo.SAUDI_RIYAL.getWorkingDay(LocalDate.of(2018, 1, 2));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 2), result);
        
        result = EnumCurrencyInfo.SAUDI_RIYAL.getWorkingDay(LocalDate.of(2018, 1, 3));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 3), result);
        
        result = EnumCurrencyInfo.SAUDI_RIYAL.getWorkingDay(LocalDate.of(2018, 1, 4));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 4), result);
        
        result = EnumCurrencyInfo.SAUDI_RIYAL.getWorkingDay(LocalDate.of(2018, 1, 5));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 7), result);

        result = EnumCurrencyInfo.SAUDI_RIYAL.getWorkingDay(LocalDate.of(2018, 01, 6));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 7), result);

        result = EnumCurrencyInfo.SAUDI_RIYAL.getWorkingDay(LocalDate.of(2018, 01, 7));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 7), result);
        
        result = EnumCurrencyInfo.SAUDI_RIYAL.getWorkingDay(LocalDate.of(2018, 01, 8));
        Assert.assertEquals("dates do not match", LocalDate.of(2018, 1, 8), result);
    }

}
