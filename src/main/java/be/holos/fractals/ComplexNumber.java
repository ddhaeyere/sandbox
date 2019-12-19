package be.holos.fractals;

/**
 * @author Dieter D'haeyere on 24/01/17.
 */
public class ComplexNumber {

    private final double x;
    private final double y;

    public ComplexNumber(final double real, final double y) {
        this.x = real;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
