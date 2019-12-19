package be.holos.algo;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Dieter D'haeyere on 21/01/18.
 */
public class CalculateQuartersTest {

    @Test
    public void quartersWhenLessThanHalfAnHour() {

        final long nrOfSeconds = 1543;
        assertEquals("0:30", CalculateQuarters.calculateQuarters(nrOfSeconds));
    }

    @Test
    public void quartersWhenExactlyOneHour() {

        final long nrOfSeconds = 3600;
        assertEquals("1:00", CalculateQuarters.calculateQuarters(nrOfSeconds));
    }

    @Test
    public void quartersWhenLessThanAnHour() {

        final long nrOfSeconds = 3543;
        assertEquals("1:00", CalculateQuarters.calculateQuarters(nrOfSeconds));
    }

    @Test
    public void quartersWhenLessZeroSeconds() {

        final long nrOfSeconds = 0;
        assertEquals("0:00", CalculateQuarters.calculateQuarters(nrOfSeconds));
    }

    @Test
    public void quartersWhenExactlyHalfAnHour() {

        final long nrOfSeconds = 2700;
        assertEquals("0:45", CalculateQuarters.calculateQuarters(nrOfSeconds));
    }

    @Test
    public void quartersWhenMoreThanAnHour() {

        final long nrOfSeconds = 7200;
        assertEquals("2:00", CalculateQuarters.calculateQuarters(nrOfSeconds));
    }
}
