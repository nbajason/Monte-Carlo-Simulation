package com.interview;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Simulator {
	// private class to save state during the simulation
	private class SimulatorState {
		private NormalDistribution normalDistribution;
		private DescriptiveStatistics stats;

		public SimulatorState(double mean, double standardDeviation) {
			// initial distribution for sampling
			// using default Randomizer
			this.normalDistribution = new NormalDistribution(mean, standardDeviation);
			// to store results and compute percentiles
			this.stats = new DescriptiveStatistics();
		}

		public void saveSimulationResult(double simResult) {
			this.stats.addValue(simResult);
		}

		public double nextSampleReturn() {
			return this.normalDistribution.sample();
		}

		public double getPercentile(double n) {
			return this.stats.getPercentile(n);
		}
	}

	private Portfolio[] portfolios;
	private Map<Portfolio, SimulatorState> results;
	private double inflation;
	private long num_simulations;
	private int periods;

	public double getInflation() {
		return inflation;
	}

	public void setInflation(double inflation) {
		this.inflation = inflation;
	}

	public long getSimulations() {
		return num_simulations;
	}

	public void setSimulations(long num_simulations) {
		this.num_simulations = num_simulations;
	}

	public int getPeriods() {
		return periods;
	}

	public void setPeriods(int periods) {
		this.periods = periods;
	}

	public Simulator(Portfolio... portfolios) {
		if (portfolios.length == 0) {
			System.out.println("warning: no data input, please check");
		}
		
		this.portfolios = portfolios;

		// initialization
		this.results = new HashMap<Portfolio, Simulator.SimulatorState>(portfolios.length);
		for (Portfolio p : portfolios) {
			SimulatorState sState = new SimulatorState(p.getMean(), p.getStandardDeviation());
			results.put(p, sState);
		}
		// 20th Year future value should be inflation adjusted at the rate of 3.5% each
		// year.
		this.inflation = 0.035;
		// Based on iterative evaluation of each random future value, we project the
		// portfolio future value over 20 years.
		this.periods = 20;
		// We would like to run 10,000 simulations
		this.num_simulations = 10000;
	}

	public void simulate() {
		for (int i = 0; i < num_simulations; i++) {
			for (Portfolio p : portfolios) {
				double simResult = p.getInitialInvestment();// starting value
				for (int j = 0; j < periods; j++) {
					// get next random sample return for the portfolio
					double r = results.get(p).nextSampleReturn();
					// end of period value
					simResult = (1 + r) * simResult;
					// adjust for inflation
					simResult = (1 - inflation) * simResult;
				}
				// save result
				results.get(p).saveSimulationResult(simResult);
			}
		}

		// update portfolios at end of num_simulations
		for (Portfolio p : portfolios) {
			SimulatorState sState = results.get(p);
			p.setSimulationMedian(sState.getPercentile(50));
			p.setSimulationWorst10(sState.getPercentile(10));
			p.setSimulationBest10(sState.getPercentile(90));
		}
	}

}