package model;

public class Monomial {
    private float coefficient;
    private int exponent;

    public Monomial(float coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public float getCoefficient(){
        return coefficient;
    }
    public int getExponent(){
        return exponent;
    }
    public void setCoefficient(float coefficient){
        this.coefficient = coefficient;
    }
    public void setExponent(int exponent){
        this.exponent = exponent;
    }
    public String toString(){
        String mono;
        switch(exponent){
            case 0:
                if (coefficient == (int) coefficient) {
                    mono = String.valueOf((int)coefficient);
                    return mono;
                }
                else {
                    mono = String.format("%.2f", coefficient);   // float with 2 decimals
                    return mono;
                }
            case 1:
                if(coefficient == 1.0) {
                    mono = "x";
                    return mono;
                }
                else if(coefficient == -1.0) {
                    mono = "-x";
                    return mono;
                }
                else {
                    if (coefficient == (int) coefficient) {
                        mono = String.valueOf((int)coefficient) + "x";
                        return mono;
                    }
                    else {
                        mono = String.valueOf(coefficient) + "x";
                        return mono;
                    }
                }
            default:
                if(coefficient == 1.0) {
                    mono = "x^" + String.valueOf(exponent);
                    return mono;
                }
                else if(coefficient == -1.0) {
                    mono = "-x^" + String.valueOf(exponent);
                    return mono;
                }
                else {
                    if (coefficient == (int) coefficient) {
                        mono = String.valueOf((int)coefficient) + "x^" + String.valueOf(exponent);
                        return mono;
                    }
                    else {
                        mono = String.format("%.2f", coefficient) + "x^" + String.valueOf(exponent);  // float with 2 decimals
                        return mono;
                    }
                }
        }
    }
    public Monomial multiply(Monomial m1, Monomial m2) {
        float coeff = m1.getCoefficient() * m2.getCoefficient();
        int exp = m1.getExponent() + m2.getExponent();
        return new Monomial(coeff, exp);
    }
}
