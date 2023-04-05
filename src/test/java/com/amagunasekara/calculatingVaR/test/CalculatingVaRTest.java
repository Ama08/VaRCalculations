package com.amagunasekara.calculatingVaR.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.amagunasekara.calculatingVaR.VarCalculation;

@TestInstance(Lifecycle.PER_CLASS)

class CalculatingVaRTest {
	private VarCalculation VarCalculation;

	@BeforeAll
	void setUp() {

		// avoids repetition in each method
		VarCalculation = new VarCalculation();
	}

	@Test
	void testCalculateVaR_usingConfidenceLevel() {
		double confidanceLevel = 99;
		double vAr = VarCalculation.calcVaRForOneTrade(confidanceLevel);
		assertEquals(-9.26, vAr);
	}

	@Test
	void testCalculateVaR_usingConfidenceLevel_forAPortfolio() {
		double confidanceLevel = 95;
		double vAr = VarCalculation.calcPortfolioVaR(confidanceLevel);
		assertEquals(-7.84, vAr);
	}

}
