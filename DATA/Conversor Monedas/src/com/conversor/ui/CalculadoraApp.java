package com.conversor.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class CalculadoraApp {

    private JFrame frame;
    private JTextField display;
    private String input = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraApp calculator = new CalculadoraApp();
            calculator.createAndShowGUI();
        });
    }
    public JFrame getFrame() {
        return frame;
    }


    void createAndShowGUI() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setEditable(false);
        display.setColumns(20);

        JPanel buttonPanel = createButtonPanel();

        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        return buttonPanel;
    }

    private class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("=")) {
                try {
                    Expression expression = new ExpressionBuilder(input).build();
                    double result = expression.evaluate();
                    if (result % 1 == 0) {
                        display.setText(Integer.toString((int) result));
                    } else {
                        display.setText(Double.toString(result));
                    }
                    input = "";
                } catch (Exception ex) {
                    display.setText("Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else if (command.equals("C")) {
                input = "";
                display.setText("");
            } else {
                input += command;
                display.setText(input);
            }
        }
    }
}
