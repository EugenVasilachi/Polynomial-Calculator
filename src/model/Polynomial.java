package model;

import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Monomial> poly;

    public Polynomial(){
        poly = new LinkedList<>();
    }
    public Polynomial(Monomial mono) {
        poly = new LinkedList<>();
        poly.add(mono);
    }
    public Polynomial(LinkedList<Monomial> list) {
        poly = list;
    }

    public LinkedList<Monomial> getPoly(){
        return poly;
    }
    public void setPoly(LinkedList<Monomial> poly){
        this.poly = poly;
    }


    public void handleInput(String input) {
        if(input.equals(""))
            return;
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
        //poly = MultiplyMonomial.multiply(this, p);
        //return poly;
        return MultiplyMonomial.multiply(this, p);
    }
    public void derivative() {
        LinkedList<Monomial> newPoly = new LinkedList<>();
        for(Monomial mono : poly) {
            if(mono.getExponent() > 1) {
                Monomial newMono = new Monomial(mono.getCoefficient() * mono.getExponent(), mono.getExponent() - 1);
                newPoly.add(newMono);
            }
            else if(mono.getExponent() == 1) {
                Monomial newMono = new Monomial(mono.getCoefficient(), 0);
                newPoly.add(newMono);
            }
        }
        poly = newPoly;
    }
    public void integral() {
        LinkedList<Monomial> newPoly = new LinkedList<>();
        for(Monomial mono : poly) {
            if(mono.getExponent() == 0) {
                Monomial newMono = new Monomial(mono.getCoefficient(), 1);
                newPoly.add(newMono);
            }
            else {
                Monomial newMono = new Monomial((float) mono.getCoefficient() / (mono.getExponent() + 1), mono.getExponent() + 1);
                newPoly.add(newMono);
            }
        }
        poly = newPoly;
    }
    public Polynomial[] division(Polynomial q){
        Polynomial p = this;
        Polynomial diffPoly = new Polynomial();
        Polynomial quotient = new Polynomial();
        Polynomial reminder = new Polynomial();
        Monomial newMono = new Monomial(0, 0);
        while(p.getPoly().getFirst().getExponent() >= q.getPoly().getFirst().getExponent()) {
            newMono.setCoefficient(p.getPoly().getFirst().getCoefficient() / q.getPoly().getFirst().getCoefficient());
            newMono.setExponent(p.getPoly().getFirst().getExponent() - q.getPoly().getFirst().getExponent());
            Monomial newMono2 = new Monomial(newMono.getCoefficient(), newMono.getExponent());
            quotient.getPoly().add(newMono2);
            diffPoly.setPoly(q.multiply(new Polynomial(newMono)));
            LinkedList<Monomial> list = p.sub(diffPoly);
            list.removeFirst();
            p.setPoly(list);
        }
        if(!p.getPoly().isEmpty())
            reminder.setPoly(p.getPoly());
        Polynomial[] result = new Polynomial[2];
        result[0] = quotient;
        result[1] = reminder;
        return result;
    }
    public String toString(){
        if(poly.isEmpty())
            return "";
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
