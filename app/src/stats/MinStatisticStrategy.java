package app.src.stats;

import app.src.entities.Course;
import app.src.entities.StatisticsStrategy;

/* TODO Inject this */
import statistics.ApacheMathDescriptiveStatisticsGatewayImplementation;

public class MinStatisticStrategy extends StatisticsStrategy {
    private ApacheMathDescriptiveStatisticsGatewayImplementation ds = null;

    public MinStatisticStrategy(Course course) {
        this.ds = new ApacheMathDescriptiveStatisticsGatewayImplementation(this.grades_to_double_array(course));
    }

    @Override
    public double calculate() {
        return this.ds.get_min();
    }
}
