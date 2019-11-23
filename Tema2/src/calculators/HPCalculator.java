package calculators;

public class HPCalculator {
    private static HPCalculator instance = null;

    private HPCalculator() {

    }

    public static HPCalculator getInstance() {
        if(instance == null) {
            return new HPCalculator();
        }
        return instance;
    }
}
