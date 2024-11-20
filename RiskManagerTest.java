import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RiskManagerTest {

    @Test
    void testConservativeStrategy() {
        RiskManager manager = new RiskManager();
        manager.setStrategy(new ConservativeRiskStrategy());

        String recommendation = manager.getRecommendations();
        assertEquals("Invest in government bonds, mutual funds, and blue-chip stocks.", recommendation);

        double returnValue = manager.calculateReturn(1000.0);
        assertEquals(1020.0, returnValue, 0.001);

        double riskPercentage = manager.getRiskPercentage();
        assertEquals(5.0, riskPercentage, 0.001);
    }

    @Test
    void testModerateStrategy() {
        RiskManager manager = new RiskManager();
        manager.setStrategy(new ModerateRiskStrategy());

        String recommendation = manager.getRecommendations();
        assertEquals("Invest in a mix of ETFs, index funds, and stable growth stocks.", recommendation);

        double returnValue = manager.calculateReturn(1000.0);
        assertEquals(1050.0, returnValue, 0.001);

        double riskPercentage = manager.getRiskPercentage();
        assertEquals(15.0, riskPercentage, 0.001);
    }

    @Test
    void testAggressiveStrategy() {
        RiskManager manager = new RiskManager();
        manager.setStrategy(new AggressiveRiskStrategy());

        String recommendation = manager.getRecommendations();
        assertEquals("Invest in high-growth stocks, startups, and speculative assets.", recommendation);

        double returnValue = manager.calculateReturn(1000.0);
        assertEquals(1150.0, returnValue, 0.001);

        double riskPercentage = manager.getRiskPercentage();
        assertEquals(30.0, riskPercentage, 0.001);
    }

    @Test
    void testSwitchingStrategies() {
        RiskManager manager = new RiskManager();

        // Test Conservative Strategy
        manager.setStrategy(new ConservativeRiskStrategy());
        String conservativeRecommendation = manager.getRecommendations();
        assertEquals("Invest in government bonds, mutual funds, and blue-chip stocks.", conservativeRecommendation);

        // Switch to Moderate Strategy
        manager.setStrategy(new ModerateRiskStrategy());
        String moderateRecommendation = manager.getRecommendations();
        assertEquals("Invest in a mix of ETFs, index funds, and stable growth stocks.", moderateRecommendation);

        // Switch to Aggressive Strategy
        manager.setStrategy(new AggressiveRiskStrategy());
        String aggressiveRecommendation = manager.getRecommendations();
        assertEquals("Invest in high-growth stocks, startups, and speculative assets.", aggressiveRecommendation);
    }

    @Test
    void testInvalidStrategy() {
        RiskManager manager = new RiskManager();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            manager.calculateReturn(1000.0);
        });

        assertEquals("Strategy not set!", exception.getMessage());
    }
}
