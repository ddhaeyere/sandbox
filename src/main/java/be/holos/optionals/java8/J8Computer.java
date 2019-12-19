package be.holos.optionals.java8;

import java.util.Optional;

/**
 * @author Dieter D'haeyere on 28/09/17.
 */
public class J8Computer {

    private Optional<J8SoundCard> soundCard;

    public Optional<J8SoundCard> getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(final Optional<J8SoundCard> soundCard) {
        this.soundCard = soundCard;
    }
}
