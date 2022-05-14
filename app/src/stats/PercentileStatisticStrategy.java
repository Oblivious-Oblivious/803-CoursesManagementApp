package app.src.stats;

import app.src.entities.Course;
import app.src.entities.StatisticsStrategy;

/* TODO Inject this */
import statistics.ApacheMathDescriptiveStatisticsGatewayImplementation;

public class PercentileStatisticStrategy extends StatisticsStrategy {
    private ApacheMathDescriptiveStatisticsGatewayImplementation ds = null;

    public PercentileStatisticStrategy(Course course) {
        this.ds = new ApacheMathDescriptiveStatisticsGatewayImplementation(this.grades_to_double_array(course));
    }

    @Override
    public double calculate() {
        /* TODO Figure out how to forward the datapoint parameter */
        double arr[] = {3, 5, 7, 5, 3};
        this.ds = new ApacheMathDescriptiveStatisticsGatewayImplementation(arr);
        return this.ds.get_percentile(5) / arr.length;
    }

    @Override
    public String toString() {
        return "Percentile";
    }
}
