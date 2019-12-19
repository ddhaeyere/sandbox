package be.holos.fractals;

/**
 * @author Dieter D'haeyere on 24/01/17.
 */
public class ComplexNumberCalculator {

    public static ComplexNumber add(final ComplexNumber operand1, final ComplexNumber operand2) {
        return new ComplexNumber(operand1.getX() + operand2.getX(), operand1.getY() + operand2.getY());
    }

    public static ComplexNumber multiply(final ComplexNumber operand1, final ComplexNumber operand2) {
        return new ComplexNumber(operand1.getX() * operand2.getX() - operand1.getY() * operand2.getY(), operand1.getX() * operand2.getY() + operand1.getY() * operand2.getX());
    }

    public static double abs(final ComplexNumber operand1) {
        return Math.sqrt(Math.pow(operand1.getX(), 2.0) + Math.pow(operand1.getY(), 2.0));
    }

    public static ComplexNumber sqr(final ComplexNumber complexNumber) {
        return multiply(complexNumber, complexNumber);
    }
}
