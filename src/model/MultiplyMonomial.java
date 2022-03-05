package model;

import java.util.LinkedList;

public class MultiplyMonomial {
    public static LinkedList<Monomial> multiply(Polynomial p1, Polynomial p2){
        LinkedList<Monomial> newPoly = new LinkedList<>();
        for(Monomial mono : p1.getPoly()) {
            for(Monomial newMono : p2.getPoly()) {
            }
        }
        return newPoly;
    }
}
