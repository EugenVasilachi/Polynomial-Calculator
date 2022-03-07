package test;

import model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddMonomialTest {

    @Test
    void testAdd() {
        var p1 = new Polynomial();
        var p2 = new Polynomial();
        p1.handleInput("x+1");
        p2.handleInput("x+2");
        p1.add(p2);
        assertEquals("2x+3", String.valueOf(p1));
    }
}
