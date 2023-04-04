package com.amagunasekara.calculatingVaR.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.amagunasekara.calculatingVaR.VarCalculation;

class CalculatingVaRTest {

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
