'''
Created on Jul 12, 2017

@author: jasonzhang
'''

import numpy as np
from random import gauss


class simulation(object):
    '''
    classdocs
    '''
    def __init__(self, portfolioList):
        '''
        Constructor
        '''
        self.portfolioList = portfolioList
        self.inflation = 0.035
        #return 
        self.resultList = {}
        for p in portfolioList:
            self.resultList[p]=[]
        
    def simulate(self, num_simulations, period):
        for i in range(num_simulations):
            for portfl in self.portfolioList:
                simResult = portfl.getInitialInvestment()
                mn = portfl.getMean()
                sd = portfl.getStandardDeviation()
                for p in range(period):
                    returnRate = gauss(mn, sd)
                    simResult = (1+returnRate) * simResult
                    simResult = (1-self.inflation) * simResult
                self.resultList[portfl].append(simResult)

        for portfl in self.portfolioList:
            result_median = np.percentile(self.resultList[portfl], 50)
            portfl.setSimulationMedian(result_median)
            result_best10 = np.percentile(self.resultList[portfl], 90)
            portfl.setSimulationBest10(result_best10)
            result_worst10 = np.percentile(self.resultList[portfl], 10)
            portfl.setSimulationWorst10(result_worst10)

    
