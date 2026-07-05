package Exercise_7_Financial_Forecasting;

public class FinancialForecaster {

    public static double calculateFutureValue(double currentBalance, double growthRate, int years) {
        if (years == 0) {
            return currentBalance;
        }

        double nextYearBalance = currentBalance * (1 + growthRate);
        return calculateFutureValue(nextYearBalance, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialPrincipal = 10000.0;
        double annualRate = 0.05;
        int targetYears = 10;

        double predictedValue = calculateFutureValue(initialPrincipal, annualRate, targetYears);

        System.out.printf("Initial Principal: $%.2f%n", initialPrincipal);
        System.out.printf("Forecasted Value after %d years: $%.2f%n", targetYears, predictedValue);
    }
}
