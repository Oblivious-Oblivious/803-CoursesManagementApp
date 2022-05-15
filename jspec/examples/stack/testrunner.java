import jspec.*;

public class testrunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new StackSpec(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
