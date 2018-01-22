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
public class EnumTradeDirectionTest {
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }   
    
    @Test
    public void shouldLookupS() {
        EnumTradeDirection result = EnumTradeDirection.get("S");
        Assert.assertEquals("EnumTradeDirections do not match", EnumTradeDirection.INCOMING, result);
    }

    @Test
    public void shouldLookupB() {
        EnumTradeDirection result = EnumTradeDirection.get("B");
        Assert.assertEquals("EnumTradeDirections do not match", EnumTradeDirection.OUTGOING, result);
    }

    @Test
    public void shouldLookupUnknown() {
        EnumTradeDirection result = EnumTradeDirection.get("SBSB");
        Assert.assertEquals("EnumTradeDirections do not match", EnumTradeDirection.UNKNOWN, result);
    }
}
