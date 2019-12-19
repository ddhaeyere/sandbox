package be.holos.algo;

/**
 * @author Dieter D'haeyere on 21/01/18.
 */
public class CalculateQuarters {

    public static final int HALF_OUR_IN_SECONDS = 1800;
    public static final int THREE_QUARTERS_IN_SECONDS = 2700;
    public static final int HOUR_IN_SECONDS = 3600;
    private static final long QUARTER_IN_SECONDS = 900;

    public static String calculateQuarters(final long nrOfSeconds) {

        final long nrOfHours = nrOfSeconds / HOUR_IN_SECONDS;
        final long restInSeconds = nrOfSeconds % HOUR_IN_SECONDS;

        if (restInSeconds == 0) {
            return nrOfHours + ":00";
        }

        if (restInSeconds <= QUARTER_IN_SECONDS) {
            return nrOfHours + ":15";
        }

        if (restInSeconds <= HALF_OUR_IN_SECONDS) {
            return nrOfHours + ":30";
        }
        if (restInSeconds <= THREE_QUARTERS_IN_SECONDS) {
            return nrOfHours + ":45";
        }

        return nrOfHours + 1 + ":00";
    }
}
