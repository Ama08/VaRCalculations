package com.amagunasekara.calculatingVaR;

import java.util.Arrays;

public class VarCalculation {

	// VaR for a single trade
	public double calcVaRForOneTrade(double confidanceLevel) {
		double[] historicalData = { -6.03, -3.05, 3.02, -1.02, -5.05, 5.20, 1.5, 0.0, 2.05, 4.52, -7.43, -4.36, -2.91,
				6.85, 7.28, 8.69, -8.24, 9.25, -9.26, 10.25 };
		double result = calcVaR(confidanceLevel, historicalData);
		return result;

	}

	// VaR for a portfolio
	public double calcPortfolioVaR(double confidanceLevel) {
		double[] historicalData1 = { -6.03, -3.05, 3.02, -1.02, -5.05, 5.20, 1.5, 0.0, 2.05, 4.52, -7.43, -4.36, -2.91,
				6.85, 7.28, 8.69, -8.24, 9.25, -9.26, 10.25 };
		double[] historicalData2 = { -7.03, -4.05, 4.02, -2.02, -6.05, 6.20, 2.5, 0.0, 3.05, 5.52, -8.43, -5.36, -3.91,
				7.85, 8.28, 9.69, -9.24, 10.25, -10.26, 11.25 };
		double[] historicalData3 = { -5.03, -2.05, 2.02, -0.02, -1.05, 4.20, 0.5, 0.0, 1.05, 3.52, -7.43, -3.36, -1.91,
				5.85, 6.28, 7.69, -7.24, 8.25, -8.26, 9.25 };
		double[] historicalData4 = { -6.02, -3.25, 3.22, -1.22, -2.05, 5.2, 2.5, 0.0, 1.05, 8.52, -6.43, -4.46, -2.94,
				6.8, 7.48, 9.69, -3.24, 6.25, -1.26, 2.25 };

		double weight1 = 0.4;
		double weight2 = 0.3;
		double weight3 = 0.2;
		double weight4 = 0.1;
		double[] portfolioReturn = new double[historicalData1.length];

		// calculating portfolio returns for each day
		for (int i = 0; i < historicalData1.length; i++) {
			portfolioReturn[i] = (historicalData1[i] * weight1) + (historicalData2[i] * weight2)
					+ (historicalData3[i] * weight3 + (historicalData4[i] * weight4));
		}

		double result = calcVaR(confidanceLevel, portfolioReturn);

		return result;

	}

	public double calcVaR(double confidanceLevel, double[] data) {
		int numberOfDays = data.length;
		Arrays.sort(data);
		double vaRPercentile = (1 - (confidanceLevel / 100)) * numberOfDays;
		return data[(int) vaRPercentile];
	}

}
