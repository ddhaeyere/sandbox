package be.holos.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dieter D'haeyere on 01/02/17.
 */
public class IteratorMain {

    public static void main(final String[] args) {
        final List<String> listOfStrings = new ArrayList<String>();
        listOfStrings.add("a");
        listOfStrings.add("b");
        listOfStrings.add("c");
        System.out.println(listOfStrings);

        removeBs(listOfStrings);
        System.out.println(listOfStrings);
    }

    private static void removeBs(final List<String> listOfStrings) {
        final Iterator<String> stringIterator = listOfStrings.iterator();
        while (stringIterator.hasNext()) {
            final String text = stringIterator.next();
            if ("b".equals(text)) {
                stringIterator.remove();
            }
        }
    }
}
