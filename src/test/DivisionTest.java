package test;

import model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionTest {
    @Test
    void testDivision() {
        var p1 = new Polynomial();
        var p2 = new Polynomial();
        p1.handleInput("x^2-1");
        p2.handleInput("x+1");
        Polynomial[] p3;
        p3 = p1.division(p2);
        assertEquals("x-1", String.valueOf(p3[0]));
        assertEquals("0", String.valueOf(p3[1]));
    }
}
