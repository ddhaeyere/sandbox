package be.holos.optionals.java8;

import be.holos.optionals.classic.USB;

import java.util.Optional;

/**
 * @author Dieter D'haeyere on 28/09/17.
 */
public class J8SoundCard {

    private Optional<USB> usb;

    public Optional<USB> getUsb() {
        return usb;
    }

    public void setUsb(final Optional<USB> usb) {
        this.usb = usb;
    }
}
