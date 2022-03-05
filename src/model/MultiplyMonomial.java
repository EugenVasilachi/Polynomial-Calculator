package model;

import java.util.LinkedList;

public class MultiplyMonomial {
    public static LinkedList<Monomial> multiply(Polynomial p1, Polynomial p2){
        LinkedList<Monomial> newPoly = new LinkedList<>();
        for(Monomial mono1 : p1.getPoly()) {
            for(Monomial mono2 : p2.getPoly()) {
                Monomial newMono = mono1.multiply(mono1, mono2);
                if(newPoly.isEmpty()) {
                    newPoly.add(newMono);
                }
                else if (newMono.getExponent() > newPoly.getFirst().getExponent()) {
                    newPoly.addFirst(newMono);
                }
                else {
                    int ok = 1;
                    for(int i = 0; i < newPoly.size() && ok == 1; i++) {
                        if(newPoly.get(i).getExponent() == newMono.getExponent()) {
                            Monomial newMono2 = new Monomial(newPoly.get(i).getCoefficient() + newMono.getCoefficient(), newMono.getExponent());
                            newPoly.set(i, newMono2);
                            ok = 0;
                        }
                        else if(i == newPoly.size() - 1) {
                            newPoly.add(newMono);
                            ok = 0;
                        }
                        else if(newPoly.get(i).getExponent() > newMono.getExponent() && newMono.getExponent() > newPoly.get(i+1).getExponent()){
                            newPoly.add(i+1, newMono);
                            ok = 0;
                        }
                    }
                }
            }
        }
        return newPoly;
    }
}
