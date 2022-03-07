package test;

import model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DerivativeTest {
    @Test
    void testDerivative() {
        var p1 = new Polynomial();
        p1.handleInput("x^2+2x+1");
        p1.derivative();
        assertEquals("2x+2", String.valueOf(p1));
    }
}
