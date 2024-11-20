public class ConservativeRiskStrategy implements RiskStrategy {
    @Override
    public String recommendInvestments() {
        return "Invest in government bonds, mutual funds, and blue-chip stocks.";
    }

    @Override
    public double calculateReturn(double investment) {
        return investment * 1.02; // 2% return
    }

    @Override
    public double getRiskPercentage() {
        return 5.0; // Low risk
    }
}
