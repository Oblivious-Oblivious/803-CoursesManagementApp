package statistics;

import statistics.apachecommons.ApacheMathDescriptive;

import app.src.entities.DescriptiveStatisticsGateway;

public class ApacheMathDescriptiveStatisticsGatewayImplementation implements DescriptiveStatisticsGateway {
    private ApacheMathDescriptive desc = null;

    public ApacheMathDescriptiveStatisticsGatewayImplementation(double dataset[]) {
        this.desc = new ApacheMathDescriptive(dataset);
    }

    @Override
    public double get_min() {
        return Double.parseDouble(String.format("%.3f", this.desc.get_min()));
    }

    @Override
    public double get_max() {
        return Double.parseDouble(String.format("%.3f", this.desc.get_max()));
    }

    @Override
    public double get_mean() {
        return Double.parseDouble(String.format("%.3f", this.desc.get_mean()));
    }

    @Override
    public double get_standard_deviation() {
        return Double.parseDouble(String.format("%.3f", this.desc.get_standard_deviation()));
    }

    @Override
    public double get_variance() {
        return Double.parseDouble(String.format("%.3f", this.desc.get_variance()));
    }

    @Override
    public double get_percentile(double datapoint) {
        return Double.parseDouble(String.format("%.3f", this.desc.get_percentile(datapoint)));
    }

    @Override
    public double get_skewness() {
        return Double.parseDouble(String.format("%.3f", this.desc.get_skewness()));
    }

    @Override
    public double get_median() {
        return Double.parseDouble(String.format("%.3f", this.desc.get_median()));
    }

    @Override
    public double get_kurtosis() {
        return Double.parseDouble(String.format("%.3f", this.desc.get_kurtosis()));
    }
}
