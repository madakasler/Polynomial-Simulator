package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

    private JFrame framePP;

    private JPanel panel;

    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;

    private JTextField polinom1;
    private JTextField polinom2;
    private JTextField textField_2;
    private JTextArea textArea_1;
    private JTextArea textArea_2;

    private JRadioButton rButton;
    private JRadioButton rButton_1;
    private JRadioButton rButton_2;
    private JRadioButton rButton_3;
    private ButtonGroup checkboxes;

    private JButton button;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    public View() {
        initialize();
    }
    private void textFields() {
        // testFields
        polinom1 = new JTextField();
        polinom1.setColumns(10);
        polinom1.setBounds(5, 30, 350, 30);
        panel.add(polinom1);

        polinom2 = new JTextField();
        polinom2.setColumns(10);
        polinom2.setBounds(5, 120, 350, 30);
        panel.add(polinom2);

      textArea_1=new JTextArea();
        textArea_1.setColumns(10);
        textArea_1.setBounds(5, 220, 350, 30);
        textArea_1.setEditable(false);
        panel.add(textArea_1);

        textArea_2=new JTextArea();
        textArea_2.setColumns(10);
        textArea_2.setBounds(5, 280, 350, 30);
        textArea_2.setEditable(false);
        panel.add(textArea_2);
    }

    private void labels() {
        // labels
        label = new JLabel("Primul polinom:");
        label.setBounds(5, 2, 143, 20);
        panel.add(label);


        label_1 = new JLabel("Al doilea polinom:");
        label_1.setBounds(5, 90, 143, 22);
        panel.add(label_1);


        label_2 = new JLabel("Rezultat:");
        label_2.setBounds(5, 190, 143, 22);
        panel.add(label_2);

        label_3 = new JLabel("Rest:");
        label_3.setBounds(5, 260, 143, 22);
        panel.add(label_3);


    }



    private void buttons() {

        // buton
        button = new JButton("Adunare");
        button.setFocusable(false);

        button1 = new JButton("Scadere");
        button1.setFocusable(false);

        button2 = new JButton("Inmultire");
        button2.setFocusable(false);

        button3 = new JButton("Impartire");
        button3.setFocusable(false);

        button4 = new JButton("Derivare");
        button4.setFocusable(false);

        button5 = new JButton("Integrare");
        button5.setFocusable(false);

        button6 = new JButton("Rest");
        button6.setFocusable(false);


        button.setBounds(420, 20, 99, 22);
        button1.setBounds(420, 60, 99, 22);
        button2.setBounds(420, 100, 99, 22);
        button3.setBounds(420, 140, 99, 22);
        button4.setBounds(420, 180, 99, 22);
        button5.setBounds(420, 220, 99, 22);
        button6.setBounds(420, 260, 99, 22);
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);

    }

    private void initialize() {

//frameul
        framePP = new JFrame();
        framePP.setTitle("Calculator polinoame");
        framePP.setSize(1000, 500);
        framePP.setBounds(500, 300, 600, 500);
        framePP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePP.getContentPane().setLayout(null);

//panel
        panel = new JPanel();
        panel.setBounds(29, 74, 600, 500);
        framePP.getContentPane().add(panel);
        panel.setLayout(null);

        labels();
        textFields();
        buttons();

        framePP.setVisible(true);
    }

    private String getPolynomial1(){
        return polinom1.getText();
    }
    private String getPolynomial2(){
        return polinom2.getText();
    }
    public void sum(ActionListener listenerForSum)
    {
         button.addActionListener(listenerForSum);
    }
     public void dif(ActionListener listenerForDif)
     {
         button1.addActionListener(listenerForDif);
     }
    public void mul(ActionListener listenerForMul)
    {
        button2.addActionListener(listenerForMul);
    }
    public void div(ActionListener listenerForDiv)
    {
        button3.addActionListener(listenerForDiv);
    }
    public void deriv(ActionListener listenerForDeriv)
    {
        button4.addActionListener(listenerForDeriv);
    }
    public void div1(ActionListener listenerForDeriv1)
    {
        button6.addActionListener(listenerForDeriv1);
    }
    public void integrare(ActionListener listenerForIntegrare)
    {
        button5.addActionListener(listenerForIntegrare);
    }
    public void setText(String text)
    {
        textArea_1.setText(text);
    }
    public void setText1(String text)
    {
        textArea_2.setText(text);
    }
    public String getPol1()
    {
        return polinom1.getText();

    }
    public String getPol2()
    {
        return polinom2.getText();
    }


}
