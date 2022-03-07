package test;

import model.Monomial;
import model.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyMonomialTest {
    @Test
    void testMultiply() {
        var p1 = new Polynomial();
        var p2 = new Polynomial();
        p1.handleInput("x+1");
        p2.handleInput("x+2");
        LinkedList<Monomial> result = p1.multiply(p2);
        Polynomial p3 = new Polynomial(result);
        assertEquals("x^2+3x+2", String.valueOf(p3));
    }
}
