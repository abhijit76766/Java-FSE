public class Main {
    static double predictFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return predictFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    static double predictFutureValueIterative(double presentValue, double growthRate, int years) {
        double value = presentValue;
        for (int year = 0; year < years; year++) {
            value *= 1 + growthRate;
        }
        return value;
    }

    public static void main(String[] args) {
        double presentValue = 10000.0;
        double growthRate = 0.08;
        int years = 5;

        System.out.printf("Recursive forecast: %.2f%n", predictFutureValue(presentValue, growthRate, years));
        System.out.printf("Iterative forecast: %.2f%n", predictFutureValueIterative(presentValue, growthRate, years));
    }
}

