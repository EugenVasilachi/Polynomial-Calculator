package model;

public class Monomial {
    private int coefficient;
    private int exponent;

    public Monomial(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public int getCoefficient(){
        return coefficient;
    }
    public int getExponent(){
        return exponent;
    }
    public void setCoefficient(int coefficient){
        this.coefficient = coefficient;
    }
    public void setExponent(int exponent){
        this.exponent = exponent;
    }
    public String toString(){
        String mono;
        switch(exponent){
            case 0:
                mono = String.valueOf(coefficient);
                return mono;
            case 1:
                switch (coefficient) {
                    case 1:
                        mono = "x";
                        return mono;
                    case -1:
                        mono = "-x";
                        return mono;
                    default:
                        mono = String.valueOf(coefficient) + "x";
                        return mono;
                }
            default:
                switch (coefficient) {
                    case 1:
                        mono = "x^" + String.valueOf(exponent);
                        return mono;
                    case -1:
                        mono = "-x^" + String.valueOf(exponent);
                        return mono;
                    default:
                        mono = String.valueOf(coefficient) + "x^" + String.valueOf(exponent);
                        return mono;
                }
        }
    }
    public Monomial multiply(Monomial m1, Monomial m2) {
        int coeff = m1.getCoefficient() * m2.getCoefficient();
        int exp = m1.getExponent() + m2.getExponent();
        return new Monomial(coeff, exp);
    }
}
