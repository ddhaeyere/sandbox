package be.holos.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author Dieter D'haeyere on 25/04/18.
 */
public class BalancedInhabitantsAlgoTest {

    @Test
    public void testSimpleCase() {
        final List<Integer> listOfInhabitants = Arrays.asList(1, 1, 1, 1, 0, 0, 0, 0);
        final BalancedInhabitantsAlgo algo = new BalancedInhabitantsAlgo();
        final int foundIndex = algo.findBalancedIndex(listOfInhabitants);
        System.out.println(foundIndex);
        assertEquals(3, foundIndex);
    }

    @Test
    public void testMixedCase() {
        final List<Integer> listOfInhabitants = Arrays.asList(1, 0, 1, 0, 1, 0, 1, 0);
        final BalancedInhabitantsAlgo algo = new BalancedInhabitantsAlgo();
        final int foundIndex = algo.findBalancedIndex(listOfInhabitants);
        System.out.println(foundIndex);
        assertEquals(3, foundIndex);
    }

    @Test
    public void testExtremeCase() {
        final List<Integer> listOfInhabitants = Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1);
        final BalancedInhabitantsAlgo algo = new BalancedInhabitantsAlgo();
        final int foundIndex = algo.findBalancedIndex(listOfInhabitants);
        System.out.println(foundIndex);
        assertEquals(1, foundIndex);
    }

    @Test
    public void testExtremeCase2() {
        final List<Integer> listOfInhabitants = Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1);
        final BalancedInhabitantsAlgo algo = new BalancedInhabitantsAlgo();
        final int foundIndex = algo.findBalancedIndex(listOfInhabitants);
        System.out.println(foundIndex);
        assertEquals(2, foundIndex);
    }

    @Test
    public void testAnotherCase() {
        final List<Integer> listOfInhabitants = Arrays.asList(1, 1, 1, 1, 0, 1, 0, 1);
        final BalancedInhabitantsAlgo algo = new BalancedInhabitantsAlgo();
        final int foundIndex = algo.findBalancedIndex(listOfInhabitants);
        System.out.println(foundIndex);
        assertEquals(2, foundIndex);
    }
}
