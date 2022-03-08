package controller;

import model.Monomial;
import model.Polynomial;
import view.MyView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MyController implements ActionListener {
    private MyView myGUI;
    private Polynomial polynomial_total;
    private LinkedList<Monomial> poly_list;

    private void Start() {
        myGUI = new MyView(this);
        myGUI.setVisible(true);
        polynomial_total = new Polynomial();
        poly_list = new LinkedList<>();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.handleInput(myGUI.getT1().getText());
        if (event.equals("+")) {
            p2.handleInput(myGUI.getT2().getText());
            if (myGUI.getT1().getText().equals("") || myGUI.getT2().getText().equals(""))
                myGUI.getT3().setText("You have to write 2 polynomials");
            else {
                if (e.getSource() == myGUI.getB1()) {   /// ADD
                    poly_list = p1.add(p2);
                    myGUI.getT3().setText("The result:" + p1 + "\n");
                }
            }
        } else if (event.equals("-")) {
            p2.handleInput(myGUI.getT2().getText());
            if (myGUI.getT1().getText().equals("") || myGUI.getT2().getText().equals(""))
                myGUI.getT3().setText("You have to write 2 polynomials");
            else {
                if (e.getSource() == myGUI.getB2()) {   /// SUB
                    poly_list = p1.sub(p2);
                    myGUI.getT3().setText("The result:" + p1 + "\n");
                }
            }
        } else if (event.equals("*")) {
            p2.handleInput(myGUI.getT2().getText());
            if (myGUI.getT1().getText().equals("") || myGUI.getT2().getText().equals(""))
                myGUI.getT3().setText("You have to write 2 polynomials");
            else {
                if (e.getSource() == myGUI.getB3()) {   /// MULTIPLY
                    polynomial_total.setPoly(p1.multiply(p2));
                    myGUI.getT3().setText("The result:" + polynomial_total.toString() + "\n");
                }
            }
        } else if (event.equals("/")) {
            p2.handleInput(myGUI.getT2().getText());
            if (myGUI.getT1().getText().equals("") || myGUI.getT2().getText().equals(""))
                myGUI.getT3().setText("You have to write 2 polynomials");
            else {
                if (e.getSource() == myGUI.getB4()) {   /// DIVISION
                    Polynomial[] result1 = p1.division(p2);
                    myGUI.getT3().setText("The result: the quotient:" + result1[0].toString() + "\n" +
                            "the reminder: " + result1[1].toString() + "\n");
                }
            }
        } else if (event.equals("derivative")) {
            if (myGUI.getT1().getText().equals(""))
                myGUI.getT3().setText("You have to write a polynomial");
            else {
                if (e.getSource() == myGUI.getB6()) {   /// DERIVATIVE
                    p1.derivative();
                    myGUI.getT3().setText("The result:" + p1 + "\n");
                }
            }
        } else if (event.equals("integral")) {
            if (myGUI.getT1().getText().equals(""))
                myGUI.getT3().setText("You have to write a polynomial");
            else {
                if (e.getSource() == myGUI.getB7()) {   /// INTEGRAL
                    p1.integral();
                    myGUI.getT3().setText("The result:" + p1 + "+c\n");
                }
            }
        } else if (event.equals("CE")) {
            myGUI.getT3().setText("");
        }
    }


    public static void main(String[] args) {
        MyController controller = new MyController();

        controller.Start();
    }
}
