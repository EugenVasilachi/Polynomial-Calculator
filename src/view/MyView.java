package view;
import controller.MyController;

import javax.swing.*;
import java.awt.*;

public class MyView extends JFrame {
    private JTextField  t1, t2;
    private JTextArea t3;
    private JLabel l1, l2;
    private JPanel p1;
    private JButton b1, b2, b3, b4, b5, b6, b7;

    public JTextField getT1() {
        return t1;
    }
    public JTextField getT2() {
        return t2;
    }
    public JTextArea getT3() {
        return t3;
    }
    public JButton getB1() {
        return b1;
    }
    public JButton getB2() {
        return b2;
    }
    public JButton getB3() {
        return b3;
    }
    public JButton getB4() {
        return b4;
    }
    public JButton getB5() {
        return b5;
    }
    public JButton getB6() {
        return b6;
    }
    public JButton getB7() {
        return b7;
    }
    public void setT1(JTextField t1) {
        this.t1 = t1;
    }

    public MyView(MyController controller) {

        this.setBackground(new Color(200,200,255));
        this.setPreferredSize(new Dimension(500,500));

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextArea();
        p1 = new JPanel();
        b1 = new JButton("+");
        b2 = new JButton("-");
        b3 = new JButton("*");
        b4 = new JButton("/");
        b5 = new JButton("CE");
        b6 = new JButton("derivative");
        b7 = new JButton("integral");
        l1 = new JLabel("First polynomial");
        l2 = new JLabel("Second polynomial");

        b1.setBackground(new Color(0x283655));
        b2.setBackground(new Color(0x283655));
        b3.setBackground(new Color(0x283655));
        b4.setBackground(new Color(0x283655));
        b5.setBackground(new Color(0x283655));
        b6.setBackground(new Color(0x283655));
        b7.setBackground(new Color(0x283655));
        b1.setForeground(new Color(0xFFFFFF));
        b2.setForeground(new Color(0xFFFFFF));
        b3.setForeground(new Color(0xFFFFFF));
        b4.setForeground(new Color(0xFFFFFF));
        b5.setForeground(new Color(0xFFFFFF));
        b6.setForeground(new Color(0xFFFFFF));
        b7.setForeground(new Color(0xFFFFFF));
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        b5.setFocusable(false);
        b6.setFocusable(false);
        b7.setFocusable(false);
        b1.addActionListener(controller);
        b2.addActionListener(controller);
        b3.addActionListener(controller);
        b4.addActionListener(controller);
        b5.addActionListener(controller);
        b6.addActionListener(controller);
        b7.addActionListener(controller);

        t1.setBackground(new Color(0xADD8E6));
        t2.setBackground(new Color(0xADD8E6));
        t3.setBackground(new Color(0xADD8E6));
        t3.setEditable(false);

        p1.setLayout(null);
        p1.setBackground(new Color(0xD0E1F9));
        t1.setBounds(15, 40, 250, 30);
        t2.setBounds(15, 160, 250, 30);
        t3.setBounds(15, 270, 450, 150);
        p1.setBounds(10, 10, 500, 500);
        b1.setBounds(280, 65, 45,45);
        b2.setBounds(340, 65, 45, 45);
        b3.setBounds(400, 65, 45, 45);
        b4.setBounds(290, 230, 90, 35);
        b5.setBounds(400, 430, 60, 20);
        b6.setBounds(280, 120, 170, 30);
        b7.setBounds(280, 160, 170, 30);
        l1.setBounds(15, 20, 150, 25);
        l2.setBounds(15, 140, 150,25);

        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(l1);
        p1.add(l2);
        this.add(p1);

        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}