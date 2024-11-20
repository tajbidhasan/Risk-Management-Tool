public class AggressiveRiskStrategy implements RiskStrategy {
    @Override
    public String recommendInvestments() {
        return "Invest in high-growth stocks, startups, and speculative assets.";
    }

    @Override
    public double calculateReturn(double investment) {
        return investment * 1.15; // 15% return
    }

    @Override
    public double getRiskPercentage() {
        return 30.0; // High risk
    }
}
