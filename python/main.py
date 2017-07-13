
from interview.simulator import simulation
from interview.portfolio import portfolio

if __name__ == '__main__':
    portfolioList = []
    portfolioList.append(portfolio('Aggressive', 100000, 0.094324, 0.15675))
    portfolioList.append(portfolio("Very Conservative", 100000, 0.06189, 0.063438))
    mySimulation = simulation(portfolioList)
    mySimulation.simulate(10000, 20)
    
    
    for portfl in portfolioList:
        print(portfl.getPortfolioType())
        print('  investment:', portfl.getInitialInvestment())
        print('  median:', int(round(portfl.getSimulationMedian())))
        print('  10% best:', int(round(portfl.getSimulationBest10())))
        print('  10% worst:', int(round(portfl.getSimulationWorst10())))
        print()
