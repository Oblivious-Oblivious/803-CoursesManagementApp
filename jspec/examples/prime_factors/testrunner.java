import jspec.*;

public class testrunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new PrimeFactors(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
