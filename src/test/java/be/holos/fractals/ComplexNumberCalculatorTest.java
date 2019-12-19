package be.holos.fractals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dieter D'haeyere on 24/01/17.
 */
public class ComplexNumberCalculatorTest {

    @Test
    public void absOfOrigin() {
        final ComplexNumber origin = new ComplexNumber(0, 0);
        assertEquals(0.0D, ComplexNumberCalculator.abs(origin), 0.000001D);
    }

    @Test
    public void absOfRegular() {
        final ComplexNumber origin = new ComplexNumber(4, 3);
        assertEquals(5.0D, ComplexNumberCalculator.abs(origin), 0.000001D);
    }
}
