package Model;

import javax.swing.*;

public class GuIfFrom {
    private JButton submitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton closeButton;

    public GuIfFrom(){
        this.setContentPanel(PanelMain);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    };

    public static void main(String[] args) {
        GuIfFrom mainscreen = new GuIfFrom();
        mainscreen.setVisible(true);

    }
}

