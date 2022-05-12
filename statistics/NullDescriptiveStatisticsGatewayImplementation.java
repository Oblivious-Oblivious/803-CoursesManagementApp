package statistics;

import app.src.entities.DescriptiveStatisticsGateway;

public class NullDescriptiveStatisticsGatewayImplementation implements DescriptiveStatisticsGateway {
    @Override
    public double get_min() {
        return 0;
    }

    @Override
    public double get_max() {
        return 0;
    }

    @Override
    public double get_mean() {
        return 0;
    }

    @Override
    public double get_standard_deviation() {
        return 0;
    }

    @Override
    public double get_variance() {
        return 0;
    }

    @Override
    public double get_percentile(double datapoint) {
        return 0;
    }

    @Override
    public double get_skewness() {
        return 0;
    }

    @Override
    public double get_median() {
        return 0;
    }

    @Override
    public double get_kurtosis() {
        return 0;
    }
}
