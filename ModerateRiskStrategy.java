public class ModerateRiskStrategy implements RiskStrategy {
    @Override
    public String recommendInvestments() {
        return "Invest in a mix of ETFs, index funds, and stable growth stocks.";
    }

    @Override
    public double calculateReturn(double investment) {
        return investment * 1.05; // 5% return
    }

    @Override
    public double getRiskPercentage() {
        return 15.0; // Moderate risk
    }
}
