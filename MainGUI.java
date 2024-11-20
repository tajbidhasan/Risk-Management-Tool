import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private RiskManager riskManager = new RiskManager();

    public MainGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Enhanced Risk Management Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Set dark theme
        Color backgroundColor = new Color(40, 40, 40);
        Color textColor = new Color(200, 200, 200);
        Color buttonColor = new Color(60, 63, 65);

        // Main panel
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title
        JLabel title = new JLabel("Risk Management Tool");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(textColor);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Input for investment amount
        JLabel amountLabel = new JLabel("Enter Investment Amount:");
        amountLabel.setForeground(textColor);
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(amountLabel);

        JTextField amountField = new JTextField(10);
        amountField.setMaximumSize(new Dimension(200, 30));
        panel.add(amountField);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Buttons for strategies
        JButton conservativeButton = new JButton("Conservative");
        JButton moderateButton = new JButton("Moderate");
        JButton aggressiveButton = new JButton("Aggressive");
        JButton clearButton = new JButton("Clear");

        // Style buttons
        JButton[] buttons = {conservativeButton, moderateButton, aggressiveButton, clearButton};
        for (JButton button : buttons) {
            button.setBackground(buttonColor);
            button.setForeground(textColor);
            button.setFocusPainted(false);
        }

        // Output area for recommendations and calculations
        JTextArea outputArea = new JTextArea(8, 40);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setBackground(buttonColor);
        outputArea.setForeground(textColor);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Action listeners for buttons
        conservativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riskManager.setStrategy(new ConservativeRiskStrategy());
                updateOutput(amountField, outputArea);
            }
        });

        moderateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riskManager.setStrategy(new ModerateRiskStrategy());
                updateOutput(amountField, outputArea);
            }
        });

        aggressiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riskManager.setStrategy(new AggressiveRiskStrategy());
                updateOutput(amountField, outputArea);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amountField.setText("");
                outputArea.setText("");
                riskManager.setStrategy(null);
            }
        });

        // Add components to panel
        panel.add(conservativeButton);
        panel.add(moderateButton);
        panel.add(aggressiveButton);
        panel.add(clearButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(scrollPane);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateOutput(JTextField amountField, JTextArea outputArea) {
        try {
            double investment = Double.parseDouble(amountField.getText());
            String recommendations = riskManager.getRecommendations();
            double potentialReturn = riskManager.calculateReturn(investment);
            double riskPercentage = riskManager.getRiskPercentage();

            outputArea.setText("Recommendations:\n" + recommendations + "\n\n" +
                    "Investment Amount: $" + investment + "\n" +
                    "Potential Return: $" + String.format("%.2f", potentialReturn) + "\n" +
                    "Risk Percentage: " + riskPercentage + "%");
        } catch (NumberFormatException e) {
            outputArea.setText("Please enter a valid numeric investment amount.");
        } catch (IllegalStateException e) {
            outputArea.setText("No strategy selected. Please choose an investment strategy.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI();
            }
        });
    }
}
