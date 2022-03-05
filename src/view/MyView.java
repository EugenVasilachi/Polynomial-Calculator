package view;
import model.Monomial;
import model.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MyView extends JFrame implements ActionListener {
    private JTextField  t1, t2;
    private JTextArea t3;
    private JLabel l1, l2;
    private JPanel p1;
    private JButton b1, b2, b3, b4, b5;
    private LinkedList<Monomial> polynomial_total;

    public MyView() {
        polynomial_total = new LinkedList<Monomial>();

        this.setBackground(new Color(200,200,255));
        this.setPreferredSize(new Dimension(500,500));

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextArea();
        p1 = new JPanel();
        b1 = new JButton("+");
        b2 = new JButton("-");
        b3 = new JButton("*");
        b4 = new JButton("=");
        b5 = new JButton("CE");
        l1 = new JLabel("First polynomial");
        l2 = new JLabel("Second polynomial");

        b1.setBackground(new Color(0x283655));
        b2.setBackground(new Color(0x283655));
        b3.setBackground(new Color(0x283655));
        b4.setBackground(new Color(0x283655));
        b5.setBackground(new Color(0x283655));
        b1.setForeground(new Color(0xFFFFFF));
        b2.setForeground(new Color(0xFFFFFF));
        b3.setForeground(new Color(0xFFFFFF));
        b4.setForeground(new Color(0xFFFFFF));
        b5.setForeground(new Color(0xFFFFFF));
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        b5.setFocusable(false);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        t1.setBackground(new Color(0xADD8E6));
        t2.setBackground(new Color(0xADD8E6));
        t3.setBackground(new Color(0xADD8E6));
        t3.setEditable(false);

        p1.setLayout(null);
        p1.setBackground(new Color(0xD0E1F9));
        t1.setBounds(15, 30, 250, 30);
        t2.setBounds(15, 160, 250, 30);
        t3.setBounds(15, 270, 450, 150);
        p1.setBounds(10, 10, 500, 500);
        b1.setBounds(220, 100, 45,45);
        b2.setBounds(280, 100, 45, 45);
        b3.setBounds(340, 100, 45, 45);
        b4.setBounds(230, 200, 90, 35);
        b5.setBounds(400, 430, 60, 20);
        l1.setBounds(15, 10, 150, 25);
        l2.setBounds(15, 130, 150,25);

        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(l1);
        p1.add(l2);
        this.add(p1);

        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public LinkedList getPolynomial_total(){
        return polynomial_total;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if(event.equals("+")) {
            if(t1.getText().equals("") || t2.getText().equals(""))
                t3.setText("You have to write 2 polynomials");
            else {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                p1.handleInput(t1.getText());
                p2.handleInput(t2.getText());
                if(e.getSource() == b1){   /// ADD
                    polynomial_total = p1.add(p2);
                    t3.setText("The result:" + p1.toString() + "\n");
                }
            }
        }
        else if(event.equals("-")) {
            if(t1.getText().equals("") || t2.getText().equals(""))
                t3.setText("You have to write 2 polynomials");
            else {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                p1.handleInput(t1.getText());
                p2.handleInput(t2.getText());
                if(e.getSource() == b2){   /// SUB
                    polynomial_total = p1.sub(p2);
                    t3.setText("The result:" + p1.toString() + "\n");
                }
            }
        }
        else if(event.equals("CE")){
            t3.setText("");
        }
    }
}