package be.holos.algo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Dieter D'haeyere on 14/05/14.
 */
public class SomeAlgoTest {
    private SomeAlgo someAlgo;

    @Before
    public void setUp() {
        someAlgo = new SomeAlgo();
    }

    @Test
    public void addUpTwoIntsAndSubtractTwo() {
        int result = someAlgo.addUpTwoIntsAndSubtractTwo(3,5);
        assertEquals(6, result);
    }

    @Test
    public void addUpTwoSmallIntsAndResultShouldBePositive() {
        int result = someAlgo.addUpTwoIntsAndSubtractTwo(1,0);
        assertEquals(0, result);

    }

    @Test
    public void testSubtractTwo() {
        int result = someAlgo.subtractTwoFrom(6);
    }

}
