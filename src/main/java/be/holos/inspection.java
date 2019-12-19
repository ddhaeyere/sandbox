package be.holos;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Dieter D'haeyere on 08/05/15.
 */
public class inspection {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class type = Double.class;
        Serializable hundred = (Serializable) type.getConstructor(Class.class).newInstance("100");

        System.out.println(hundred);
    }
}
