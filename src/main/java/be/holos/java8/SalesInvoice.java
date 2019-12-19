package be.holos.java8;

import java.text.DecimalFormat;

/**
 * @author Dieter D'haeyere on 17/10/17.
 */
abstract public class SalesInvoice implements NewInt {

    abstract String doSomething();

    public static void main(final String[] args) {
        final DecimalFormat df = new DecimalFormat("0");
        df.setMaximumFractionDigits(340);

        final double value1 = 0.120d;
        final double value2 = 120.000d;
        final double value3 = 0.12012345678d;
        final double value4 = 0.120000d;
        final double value5 = 120d;

        System.out.println(df.format(value1));
        System.out.println(df.format(value2));
        System.out.println(df.format(value3));
        System.out.println(df.format(value4));
        System.out.println(df.format(value5));
    }
}
