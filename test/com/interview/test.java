package com.interview;

public class test {
	public static void main(String [ ] args)
	{	
		//********data input***********//
		//1- Aggressive  	 
		//    - Return (Mean): %9.4324 
		//    - Risk ( Standard Deviation): 15.675
		//1- Very Conservative 
		//    - Return (Mean): %6.189 
		//    - Risk ( Standard Deviation): 6.3438
		Portfolio[] portfolioArr = new Portfolio[2];
		portfolioArr[0] = new Portfolio("Aggressive", 100000, 0.094324, 0.15675);
		portfolioArr[1] = new Portfolio("Very Conservative", 100000, 0.06189,  0.63438);
		
		//********data process***********//
		System.out.println("Monte Carlo Simulation");
		Simulator mySimulator = new Simulator(portfolioArr);
		mySimulator.setPeriods(20);
		mySimulator.setSimulations(10000);
		mySimulator.simulate();
		
		//********data output***********//
		for (Portfolio p : portfolioArr) 
		{
		System.out.println(p);
		}
	}
	
}
