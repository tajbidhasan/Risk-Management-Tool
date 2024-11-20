public interface RiskStrategy {
    String recommendInvestments();
    double calculateReturn(double investment);
    double getRiskPercentage();
}
