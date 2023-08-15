package com.conversor.ui;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.conversor.logic.TipoMoneda;
import javax.swing.*;
import java.text.DecimalFormat;

public class ConversorUI {
    private JPanel mainbg;
    private JButton convertButton;
    private JButton eraseButton;
    private JComboBox<TipoMoneda> moneyTypeBox1;
    private JComboBox<TipoMoneda> moneyTypeBox2;
    private JTextField resultField;
    private JLabel welcomeField;
    private JLabel descriptionField;
    private JButton revertButton;
    private JTextField quantityField;
    private JLabel howMuchField;
    private JLabel currencyToConvert;
    private JLabel convertedCurrency;

    public ConversorUI() {
        /* Campos de bienvenida y descripcion */
        welcomeField.setText("Bienvenido al Conversor de Monedas");
        descriptionField.setText("Seleccione las monedas y presione Convertir para obtener el resultado.");

        /*Selectores de tipos de moneda*/
        DefaultComboBoxModel<TipoMoneda> comboBoxModel1 = new DefaultComboBoxModel<>(TipoMoneda.TIPOS_MONEDA);
        moneyTypeBox1.setModel(comboBoxModel1);
        DefaultComboBoxModel<TipoMoneda> comboBoxModel2 = new DefaultComboBoxModel<>(TipoMoneda.TIPOS_MONEDA);
        moneyTypeBox2.setModel(comboBoxModel2);

        /*Icono para intercambiar entre monedas*/
        ImageIcon icon = new ImageIcon("img/switchIcon.png");
        revertButton.setIcon(icon);
        revertButton.setHorizontalTextPosition(SwingConstants.CENTER);
        revertButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        revertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Intercambiar las selecciones entre los moneyTypeBox
                TipoMoneda selectedMoneda1 = (TipoMoneda) moneyTypeBox1.getSelectedItem();
                TipoMoneda selectedMoneda2 = (TipoMoneda) moneyTypeBox2.getSelectedItem();

                moneyTypeBox1.setSelectedItem(selectedMoneda2);
                moneyTypeBox2.setSelectedItem(selectedMoneda1);
            }
        });
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TipoMoneda monedaOrigen = (TipoMoneda) moneyTypeBox1.getSelectedItem();
                TipoMoneda monedaDestino = (TipoMoneda) moneyTypeBox2.getSelectedItem();

                double cantidad = Double.parseDouble(quantityField.getText()); /*Obtener la cantidad ingresada*/

                /* Realizar la conversión usando los valores de tasa de cambio*/
                double resultado = cantidad * (monedaDestino.getTasaCambio() / monedaOrigen.getTasaCambio());

                /* Formatear el resultado a dos decimales*/
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String resultadoFormateado = decimalFormat.format(resultado);

                /* Mostrar el resultado en el campo resultField*/
                resultField.setText(resultadoFormateado + " " + monedaDestino.getSimbolo());
            }
        });

        /* Codigo para que el usuario identifique la moneda que convierte*/
        moneyTypeBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TipoMoneda monedaOrigen = (TipoMoneda) moneyTypeBox1.getSelectedItem();
                currencyToConvert.setText("Moneda a convertir: " + monedaOrigen.getNombre());
            }
        });
        moneyTypeBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TipoMoneda monedaDestino = (TipoMoneda) moneyTypeBox2.getSelectedItem();
                convertedCurrency.setText("Moneda convertida: " + monedaDestino.getNombre());
            }
        });

        /* Boton para limpiar la interfaz */
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moneyTypeBox1.setSelectedIndex(0);
                moneyTypeBox2.setSelectedIndex(0);
                quantityField.setText("");
                resultField.setText("");
                currencyToConvert.setText("");
                convertedCurrency.setText("");
            }
        });

    }


    public JPanel getMainPanel() {
        return mainbg;
    }
}
