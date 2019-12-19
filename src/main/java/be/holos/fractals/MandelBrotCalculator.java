package be.holos.fractals;

/**
 * @author Dieter D'haeyere on 25/01/17.
 */
public class MandelBrotCalculator {

    private static final int NR_OF_ITERATIONS = 500;
    private static final double MANDELBROT_LIMIT = 2;

    public static double calculateMandelBrotNumber(final ComplexNumber complexNumber) {
        ComplexNumber previous = new ComplexNumber(0, 0);
        ComplexNumber next = new ComplexNumber(0, 0);
        for (int i = 0; i < NR_OF_ITERATIONS; i++) {
            next = ComplexNumberCalculator.add(ComplexNumberCalculator.sqr(previous), complexNumber);
            previous = next;
        }

        return ComplexNumberCalculator.abs(next);
    }

    public static boolean isMandelBrotPoint(final ComplexNumber complexNumber) {
        if (calculateMandelBrotNumber(complexNumber) < MANDELBROT_LIMIT) {
            return true;
        }
        return false;
    }
}
