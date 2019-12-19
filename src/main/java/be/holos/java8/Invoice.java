package be.holos.java8;

import java.util.Scanner;

/**
 * @author Dieter D'haeyere on 17/10/17.
 */
public class Invoice implements Comparable {

    int id = 0;

    public Invoice() {
        this(10);
    }

    public Invoice(final int id) {
        this.id = id;
    }

    public void display() {
        class Decrementer {

            public void decrement() {
                id--;
            }
        }
        final Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("id : " + id);
    }

    public String formatId(final String id) {

        return id + "_Invoice";
    }
    //
    //    public Integer getNumber() throws NoSuchMethodException {
    //        try {
    //            System.out.println(c.getMethod("getNumber", null).toString());
    //            System.out.println(c.getDeclaredMethod("setNumber", Integer.class).toString());
    //        } catch (final NoSuchMethodException nse) {
    //            throw new NoSuchMethodException("kj");
    //        }
    //    }

    public void meth(final Object arg) {
        if (arg instanceof NewInt) {

        }
    }

    public static void main(final String[] args) {
        final String string = "Test null Test 1 2 3 test";
        System.out.println(string.indexOf("test"));
        final StringBuilder str = new StringBuilder();

        final Scanner scanner = new Scanner("Test null Test 1 2 3 test");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.print(scanner.nextInt() + " ");
            } else {
                scanner.next();
            }
        }
    }

    @Override
    public int compareTo(final Object o) {
        final Invoice e = (Invoice) o;
        return this.id - e.id;
    }

    public String toString() {
        return "" + this.id;
    }
}
