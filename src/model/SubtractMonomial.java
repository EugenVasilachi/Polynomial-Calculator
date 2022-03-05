package model;

public class SubtractMonomial {
    public static void subMonomial(Polynomial p, Monomial m) {
        Monomial m1 = new Monomial(-m.getCoefficient(), m.getExponent());
        if(m.getExponent() > p.getPoly().getFirst().getExponent())
            p.getPoly().addFirst(m1);
        else {
            int ok = 1;
            for(int i = 0; i < p.getPoly().size() && ok == 1; i++) {
                if(p.getPoly().get(i).getExponent() == m.getExponent()) {
                    Monomial m2 = new Monomial(p.getPoly().get(i).getCoefficient() - m.getCoefficient(), m.getExponent());
                    p.getPoly().set(i, m2);
                    ok = 0;
                }
                else if(i == p.getPoly().size() - 1) {
                    p.getPoly().add(m1);
                    ok = 0;
                }
                else if(p.getPoly().get(i).getExponent() > m.getExponent() && m.getExponent() > p.getPoly().get(i+1).getExponent()){
                    p.getPoly().add(i+1, m1);
                    ok = 0;
                }
            }
        }
    }
}
