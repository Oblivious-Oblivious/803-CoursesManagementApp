package app.src.entities;

public interface DescriptiveStatisticsGateway {
    public double get_min();
    public double get_max();
    public double get_mean();
    public double get_standard_deviation();
    public double get_variance();
    public double get_percentile(double datapoint);
    public double get_skewness();
    public double get_median();
    public double get_kurtosis();
}
