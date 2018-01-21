/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.reporting;

import com.domain.reporting.delegate.PublishToConsoleImplTest;
import com.domain.reporting.delegate.TradeProcessImplTest;
import com.domain.reporting.delegate.TradeValidateImplTest;
import com.domain.reporting.model.EnumCurrencyInfoTest;
import com.domain.reporting.model.InstructionProcessedTest;
import com.domain.reporting.report.DTRFromParallelStreamImplTest;
import com.domain.reporting.report.DTRFromStreamImplTest;
import com.domain.reporting.service.TradeReportingServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author Alan Humphris
 */

@RunWith(Suite.class)
@SuiteClasses({
	/* Model Tests */
	EnumCurrencyInfoTest.class,
	InstructionProcessedTest.class,
        /* Report Tests */
        DTRFromStreamImplTest.class,
        DTRFromParallelStreamImplTest.class,
        /* Delegate Tests */
        PublishToConsoleImplTest.class,
        TradeProcessImplTest.class,
        TradeValidateImplTest.class,
	/* Service tests */
        TradeReportingServiceImplTest.class,
	// finally
	})

public class AllTests {
    
}
