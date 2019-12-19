package be.holos.algo;

import java.util.List;
import java.util.Optional;

/**
 * @author Dieter D'haeyere on 25/04/18.
 */
public class BalancedInhabitantsAlgo {

    public int findBalancedIndex(final List<Integer> inhabitants) {
        if (!isValidList(inhabitants)) {
            return -1;
        }

        final int nrOfInhabitants = inhabitants.size();
        boolean indexFound = false;

        int maleIndex = 0;
        int femaleIndex = nrOfInhabitants - 1;
        int nrOfMen = 0;
        int nrOfWomen = 0;
        while (!indexFound) {
            if (nrOfMen <= nrOfWomen && maleIndex < femaleIndex) {
                if (inhabitants.get(maleIndex) == 1) {
                    nrOfMen++;
                }
                maleIndex++;
            } else {
                if (inhabitants.get(femaleIndex) == 0) {
                    nrOfWomen++;
                }
                femaleIndex--;
            }
            indexFound = isValidSolution(maleIndex, femaleIndex, nrOfMen, nrOfWomen);
        }
        return maleIndex;
    }

    private boolean isValidSolution(final int maleIndex, final int femaleIndex, final int nrOfMen, final int nrOfWomen) {
        if (nrOfWomen - nrOfMen <= 0 && femaleIndex - maleIndex <= 1) {
            return true;
        }

        return false;
    }

    private boolean isValidList(final List<Integer> inhabitants) {
        if (inhabitants == null) {
            return false;
        }
        final int nrOfInhabitants = inhabitants.size();
        if (nrOfInhabitants == 0) {
            return false;
        }

        final Optional<Integer> nonMatchingInput = inhabitants.stream().filter(i -> i.intValue() != 0 && i.intValue() != 1).findFirst();
        if (nonMatchingInput.isPresent()) {
            return false;
        }
        return true;
    }
}
