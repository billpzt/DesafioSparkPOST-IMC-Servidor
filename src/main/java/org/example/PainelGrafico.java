package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelGrafico {

    JFrame frame = new JFrame("SERVIDOR");
    JPanel panel = new JPanel();
    JTextField inputFieldMassa = new JTextField(10);
    JTextField inputFieldAltura = new JTextField(10);
    JTextField inputFieldIMC = new JTextField(10);
    JLabel labelMassa = new JLabel("Massa:");
    JLabel labelAltura = new JLabel("Altura:");
    JLabel labelIMC = new JLabel("IMC:");

    public PainelGrafico() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);

        panel.setLayout(new GridLayout(4, 2));

        inputFieldMassa.setFont(new Font("Arial", Font.PLAIN, 30));
        inputFieldAltura.setFont(new Font("Arial", Font.PLAIN, 30));
        inputFieldIMC.setFont(new Font("Arial", Font.PLAIN, 30));

        labelMassa.setFont(new Font("Arial", Font.PLAIN, 30));
        labelAltura.setFont(new Font("Arial", Font.PLAIN, 30));
        labelIMC.setFont(new Font("Arial", Font.PLAIN, 30));

        panel.add(labelMassa);
        panel.add(inputFieldMassa);

        panel.add(labelAltura);
        panel.add(inputFieldAltura);

        panel.add(labelIMC);
        panel.add(inputFieldIMC);


        String[] buttonLabels = {
                "Limpar", "Sair"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            panel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (label.equals("Limpar")) {
                        inputFieldMassa.setText("");
                        inputFieldAltura.setText("");
                        inputFieldIMC.setText("");
                    } else if (label.equals("Sair")) {
                        System.exit(0);
                    }
                }
            });
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}
