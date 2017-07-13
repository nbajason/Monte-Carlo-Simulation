
class portfolio(object):
    '''
    classdocs
    '''

    def __init__(self, portfolioType, initialInvestment, mean, standardDeviation):
        '''
        Constructor
        '''
        self.portfolioType = portfolioType
        self.initialInvestment = initialInvestment
        self.mean = mean
        self.standardDeviation = standardDeviation
        self.simulationMedian = 0
        self.simulationBest10 = 0;
        self.simulationWorst10 = 0;
        
    def setSimulationMedian(self, simulationMedian):
        self.simulationMedian = simulationMedian
        
    def setSimulationBest10(self, simulationBest10):
        self.simulationBest10 = simulationBest10
        
    def setSimulationWorst10(self, simulationWorst10):
        self.simulationWorst10 = simulationWorst10
    
    def getSimulationMedian(self):
        return self.simulationMedian
        
    def getSimulationBest10(self):
        return self.simulationBest10 
        
    def getSimulationWorst10(self):
        return self.simulationWorst10
            
        
    def getPortfolioType(self):
        return self.portfolioType
    
    def getInitialInvestment(self):
        return self.initialInvestment
        
    def getMean(self):
        return self.mean
    
    def getStandardDeviation(self):
        return self.standardDeviation
