package app.src.stats;

import app.src.entities.Course;
import app.src.entities.StatisticsStrategy;

/* TODO Inject this */
import statistics.ApacheMathDescriptiveStatisticsGatewayImplementation;

public class SkewnessStatisticStrategy extends StatisticsStrategy {
    private ApacheMathDescriptiveStatisticsGatewayImplementation ds = null;

    public SkewnessStatisticStrategy(Course course) {
        this.ds = new ApacheMathDescriptiveStatisticsGatewayImplementation(this.grades_to_double_array(course));
    }

    @Override
    public double calculate() {
        return this.ds.get_skewness();
    }

    @Override
    public String toString() {
        return "Skewness";
    }
}
