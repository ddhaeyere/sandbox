package be.holos.algo;

/**
 * @author Dieter D'haeyere on 14/05/14.
 */
public class SomeAlgo {

    /**
     * add up two numbers and subtract 2 from the result.
     * note the final result should not be lower than 0
     *
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    public int addUpTwoIntsAndSubtractTwo(int firstNumber, int secondNumber) {
        int additionResult = addTwoInts(firstNumber, secondNumber);
        return subtractTwoFrom(additionResult);
    }

    private int addTwoInts(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    protected int subtractTwoFrom(int someNumber) {
        return someNumber - 2;
    }
}
