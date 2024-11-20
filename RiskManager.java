public class RiskManager {
    private RiskStrategy strategy;

    public void setStrategy(RiskStrategy strategy) {
        this.strategy = strategy;
    }

    public String getRecommendations() {
        if (strategy == null) {
            return "No strategy has been set!";
        }
        return strategy.recommendInvestments();
    }

    public double calculateReturn(double investment) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.calculateReturn(investment);
    }

    public double getRiskPercentage() {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.getRiskPercentage();
    }
}
