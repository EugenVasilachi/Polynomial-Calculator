package test;

import model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegralTest {
    @Test
    void testIntegral() {
        var p1 = new Polynomial();
        p1.handleInput("2x^2+2x+1");
        p1.integral();
        assertEquals("0.67x^3+x^2+x", String.valueOf(p1));
    }
}
