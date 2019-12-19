package be.holos.optionals;

import be.holos.optionals.classic.Computer;
import be.holos.optionals.classic.SoundCard;
import be.holos.optionals.classic.USB;
import be.holos.optionals.java8.J8Computer;
import be.holos.optionals.java8.J8SoundCard;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;

/**
 * @author Dieter D'haeyere on 28/09/17.
 */
public class OptionalsTest {

    private Computer desktop;

    private Computer raspBerryPi;

    private Optional<J8Computer> j8Desktop;

    private Optional<J8Computer> j8RaspBerryPi;

    @Before
    public void setup() {
        desktop = givenADesktop();
        raspBerryPi = givenARaspBerryPi();

        j8Desktop = givenAJ8Desktop();
        j8RaspBerryPi = givenAJ8RaspBerryPi();
    }

    @Test(expected = NullPointerException.class)
    public void traditionalGetVersionWithoutNPECheckForRaspBerryPi() {
        final String version = traditionalGetVersionWithoutNPECheck(raspBerryPi);
    }

    @Test
    public void traditionalGetVersionWithoutNPECheckForDesktop() {
        final String version = traditionalGetVersionWithoutNPECheck(desktop);
        System.out.println("traditional version without npe check : " + version);
        assertEquals("1.0", version);
    }

    @Test
    public void traditionalGetVersionWitNPECheckForRaspBerryPi() {
        final String version = traditionalGetVersionWithNPECheck(raspBerryPi);
        System.out.println("traditional version : " + version);
        assertEquals(null, version);
    }

    @Test
    public void traditionalGetVersionWithNPECheckForDesktop() {
        final String version = traditionalGetVersionWithNPECheck(desktop);
        System.out.println("traditional version with npe check : " + version);
        assertEquals("1.0", version);
    }

    @Test
    public void java8GetVersionForDesktop() {
        final String version = java8getVersion(j8Desktop);

        System.out.println("j8 version : " + version);

        assertEquals("1.0", version);
    }

    @Test
    public void java8GetVersionForRaspBerryPi() {
        final String version = java8getVersion(j8RaspBerryPi);
        System.out.println("j8 version : " + version);
        assertEquals("UNKNOWN", version);
    }

    private String traditionalGetVersionWithoutNPECheck(final Computer computer) {
        return computer.getSoundCard().getUsb().getVersion();
    }

    private String traditionalGetVersionWithNPECheck(final Computer computer) {

        if (computer != null) {
            final SoundCard soundCard = computer.getSoundCard();
            if (soundCard != null) {
                final USB usb = soundCard.getUsb();
                if (usb != null) {
                    return usb.getVersion();
                }
            }
        }
        return null;
    }

    @Test(expected = IllegalStateException.class)
    public void testOptionalThrowsException() {
        final USB usb = new USB();
        final Optional<USB> usbOptional = Optional.empty();

        Optional.ofNullable(usb);

        final String version = usbOptional.orElseThrow(IllegalStateException::new).getVersion();
    }

    private String java8getVersion(final Optional<J8Computer> computer) {

        final String version = computer.flatMap(J8Computer::getSoundCard)
                .flatMap(J8SoundCard::getUsb)
                .map(USB::getVersion)
                .orElse("UNKNOWN");

        //        final String version = computer.flatMap(J8Computer::getSoundCard)
        //                .flatMap(J8SoundCard::getUsb)
        //                .map(USB::getVersion)
        //                .orElseThrow(IllegalArgumentException::new);

        return version;
    }

    @Test
    public void testFilterOptionals() {
        final Optional<J8SoundCard> j8SoundCard = j8Desktop.flatMap(J8Computer::getSoundCard);
        final Optional<USB> usbOptional = j8SoundCard.flatMap(J8SoundCard::getUsb).filter(usb -> "1.0".equals(usb.getVersion()));
        usbOptional.ifPresent(theUsb -> System.out.println("version:" + theUsb.getVersion()));

        final Optional<USB> maybeUSB = j8SoundCard.flatMap(J8SoundCard::getUsb);
        maybeUSB.filter(usb -> "1.0".equals(usb.getVersion()))
                .ifPresent(theUsb -> System.out.println("ok"));
    }

    private Computer givenADesktop() {
        final USB usb = new USB();
        usb.setVersion("1.0");

        final SoundCard soundCard = new SoundCard();
        soundCard.setUsb(usb);

        final Computer desktop = new Computer();
        desktop.setSoundCard(soundCard);

        return desktop;
    }

    private Computer givenARaspBerryPi() {
        return new Computer();
    }

    private Optional<J8Computer> givenAJ8RaspBerryPi() {
        final Optional<J8SoundCard> emptySoundCard = Optional.empty();
        final J8Computer raspBerryPi = new J8Computer();
        raspBerryPi.setSoundCard(emptySoundCard);
        return Optional.of(raspBerryPi);
    }

    private Optional<J8Computer> givenAJ8Desktop() {
        final USB usb = new USB();
        usb.setVersion("1.0");

        final Optional<USB> usbOptional = Optional.of(usb);

        final J8SoundCard soundCard = new J8SoundCard();
        soundCard.setUsb(usbOptional);

        final J8Computer desktop = new J8Computer();
        final Optional<J8SoundCard> soundCardOptional = Optional.of(soundCard);
        desktop.setSoundCard(soundCardOptional);

        return Optional.of(desktop);
    }
}
