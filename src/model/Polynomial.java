package model;

import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Monomial> poly;

    public Polynomial(){
        poly = new LinkedList<>();
    }

    public LinkedList<Monomial> getPoly(){
        return poly;
    }

    public void handleInput(String input) {
        String[] poly_str = input.split("(?=[+-])");
        create_list(poly_str);
    }
    public void create_list(String[] poly_str) {
        for(String str : poly_str) {
            String[] split_str = str.split("[x^]");
            if(split_str.length == 3) {
                String s = split_str[0];
                switch(s){
                    case "-":
                        Monomial m1 = new Monomial(-1, Integer.parseInt(split_str[2]));
                        poly.add(m1);
                        break;
                    case "+":
                        Monomial m2 = new Monomial(1, Integer.parseInt(split_str[2]));
                        poly.add(m2);
                        break;
                    case "":
                        Monomial m3 = new Monomial(1, Integer.parseInt(split_str[2]));
                        poly.add(m3);
                        break;
                    default:
                        Monomial m4 = new Monomial(Integer.parseInt(split_str[0]), Integer.parseInt(split_str[2]));
                        poly.add(m4);
                        break;
                }
            }
            else if(split_str.length == 1){
                if(str.contains("x")){
                    switch(split_str[0]){
                        case "-":
                            Monomial m1 = new Monomial(-1, 1);
                            poly.add(m1);
                            break;
                        case "+":
                            Monomial m2 = new Monomial(1, 1);
                            poly.add(m2);
                            break;
                        default:
                            Monomial m3 = new Monomial(Integer.parseInt(split_str[0]), 1);
                            poly.add(m3);
                            break;
                    }
                }
                else {
                    Monomial mono = new Monomial(Integer.parseInt(split_str[0]), 0);
                    poly.add(mono);
                }
            }
            else if(split_str.length == 0){      /// Polynomial which starts with 'x'
                Monomial mono = new Monomial(1, 1);
                poly.add(mono);
            }
        }
    }
    public LinkedList<Monomial> add(Polynomial p) {
        for(Monomial m : p.getPoly()) {
            AddMonomial.addMonomial(this, m);
        }
        return poly;
    }
    public LinkedList<Monomial> sub(Polynomial p) {
        for(Monomial m : p.getPoly()) {
            SubtractMonomial.subMonomial(this, m);
        }
        return poly;
    }
    public LinkedList<Monomial> multiply(Polynomial p) {
        poly = MultiplyMonomial.multiply(this, p);
        return poly;
    }
    public String toString(){
        String str = "";
        for(Monomial m : poly) {
            if(m.getCoefficient() == 0)
                continue;
            if(m != poly.getFirst() && m.getCoefficient() > 0)
                str += "+" + m.toString();
            else str += m.toString();
        }
        if(str.equals(""))
            return "0";
        return str;
    }
}
