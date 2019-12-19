package be.holos.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dieter D'haeyere on 30/12/15.
 */
public class StringPlayGroundTest {

    StringPlayGround stringPlayGround;

    @Before
    public void setUp() {
        stringPlayGround = new StringPlayGround();
    }

    @Test
    public void testRevertString() {
        final String revertedString = stringPlayGround.revertString("12345");
        assertEquals(revertedString, "54321");
    }

    @Test
    public void testFetchSerialNoDescription1() {
        final String serialNoDescription = stringPlayGround.fetchSerialNoDescription("-Dana AutomociÛn S.A. (GBP)--VOORAS SAM.--");
        assertEquals("-Dana AutomociÛn S.A. (GBP)", serialNoDescription);
    }

    @Test
    public void testFetchSerialNoDescription2() {
        final String serialNoDescription = stringPlayGround.fetchSerialNoDescription("-Dana AutomociÛn S.A. (GBP)-VOORAS SAM.-");
        assertEquals("-Dana AutomociÛn S.A. (GBP)", serialNoDescription);
    }

    @Test
    public void testFetchSerialNoLineNoDescription1() {
        final String serialNoLineNoDescription = stringPlayGround.fetchSerialNoLineNoDescription("-Dana AutomociÛn S.A. (GBP)-VOORAS SAM.-");
        assertEquals("VOORAS SAM.", serialNoLineNoDescription);
    }

    @Test
    public void testFetchSerialNoLineNoDescription2() {
        final String serialNoLineNoDescription = stringPlayGround.fetchSerialNoLineNoDescription("-Dana AutomociÛn S.A. (GBP)--VOORAS SAM.--");
        assertEquals("VOORAS SAM.", serialNoLineNoDescription);
    }

    @Test
    public void tesConcat() {
        assertEquals("abc/cd", "abc" + '/' + "cd");
    }
}
