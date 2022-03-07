package test;

import model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractMonomialTest {
    @Test
    void testSub() {
        var p1 = new Polynomial();
        var p2 = new Polynomial();
        p1.handleInput("2x+1");
        p2.handleInput("x+2");
        p1.sub(p2);
        assertEquals("x-1", String.valueOf(p1));
    }
}
