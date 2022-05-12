package app.src.stats;

import java.util.ArrayList;
import java.util.HashMap;

import app.src.entities.StatisticsStrategy;

public class StatisticsCalculator {
    public ArrayList<StatisticsStrategy> strategies = null;

    public void set_strategies(ArrayList<StatisticsStrategy> strategies) {
        this.strategies = strategies;
    }

    public HashMap<String, Double> calculate_statistics() {
        HashMap<String, Double> stats = new HashMap<String, Double>();

        for(StatisticsStrategy strategy : this.strategies)
            stats.put(strategy.toString(), strategy.calculate());
        
        return stats;
    }
}
