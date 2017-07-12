package com.interview;

public class Portfolio {
	// Two portfolios were created, one being extremely Conservative and one being
	// Aggressive.
	private String portfolioType;
	// A user with $100,000 invested
	private double initialInvestment;
	// Return value -mean
	private double mean;
	// Risk -Standard Deviation
	private double standardDeviation;

	// simulated results
	private double simulationMedian;
	private double simulationBest10;
	private double simulationWorst10;

	public Portfolio(String portfolioType, double initialInvestment, double mean, double standardDeviation) {
		this.portfolioType = portfolioType;
		this.initialInvestment = initialInvestment;
		this.mean = mean;
		this.standardDeviation = standardDeviation;
	}

	public String getPortfolioType() {
		return portfolioType;
	}

	public void setPortfolioType(String portfolioType) {
		this.portfolioType = portfolioType;
	}

	public double getInitialInvestment() {
		return initialInvestment;
	}

	public void setInitialInvestment(double initialInvestment) {
		this.initialInvestment = initialInvestment;
	}

	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	public double getSimulationMedian() {
		return simulationMedian;
	}

	public void setSimulationMedian(double simulationMedian) {
		this.simulationMedian = simulationMedian;
	}

	public double getSimulationBest10() {
		return simulationBest10;
	}

	public void setSimulationBest10(double simulationBest10) {
		this.simulationBest10 = simulationBest10;
	}

	public double getSimulationWorst10() {
		return simulationWorst10;
	}

	public void setSimulationWorst10(double simulationWorst10) {
		this.simulationWorst10 = simulationWorst10;
	}

	@Override
	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("Portfolio Type - ").append(portfolioType)
//		.append(":\n     - initialInvestment = ").append(Math.round(initialInvestment))
//		.append("\n     - return = ").append(mean)
//		.append("\n     - risk = ").append(standardDeviation)
//		.append("\n     - Median = ").append(Math.round(simulationMedian))
//		.append("\n     - 10% Best = ").append(Math.round(simulationBest10))
//		.append("\n     - 10% Worst = ").append(Math.round(simulationWorst10));
//		
//		return sb.toString();
	
		return "Portfolio Type - " + portfolioType + ":\n     - initialInvestment = " + Math.round(initialInvestment)
				+ "\n     - return = " + mean + "\n     - risk = " + standardDeviation + "\n     - Median = "
				+ Math.round(simulationMedian) + "\n     - 10% Best = " + Math.round(simulationBest10)
				+ "\n     - 10% Worst = " + Math.round(simulationWorst10) + "\n     NOTE:"
				+ "\n     - (10% Best: 90th Percentile value among the 10,000 simulations)"
				+ "\n     - (10% Worst:10th Percentile value among the 10,000 simulations)\n";
	}

}