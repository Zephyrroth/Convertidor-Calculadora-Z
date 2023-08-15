package com.conversor.ui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaPrincipalUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor + Calculadora");
        frame.setContentPane(new PantallaPrincipalUI().mainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private JPanel mainWindow;
    private JLabel labelSaludo;
    private JLabel labelOpcion;
    private JButton calculadoraButton;
    private JButton conversorButton;
    private JButton salirButton;

    public PantallaPrincipalUI() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la aplicación cuando se hace clic en el botón "Salir"
                System.exit(0);
            }
        });
        conversorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConvertidor();
            }
        });
        calculadoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCalculadora();
            }
        });

    }
    private void mostrarConvertidor() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Convertidor de Moneda");
        dialog.setSize(600, 400);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        ConversorUI conversorUI = new ConversorUI();
        dialog.add(conversorUI.getMainPanel());

        dialog.setVisible(true);
    }

    private void mostrarCalculadora() {
        CalculadoraApp calculator = new CalculadoraApp();
        calculator.createAndShowGUI();
        JFrame calculatorFrame = calculator.getFrame();
        calculatorFrame.setSize(300, 300);
        calculatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calculatorFrame.setVisible(true);
    }


}
