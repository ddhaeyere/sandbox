package be.holos.calculs;

/**
 * @author Dieter D'haeyere on 25/02/15.
 */
public class DoubleCalculs {

    private boolean checkIfShouldProceed(Double quantityInCarrier, Double maxQuantityInCarrier, Double quantityToStore, Double specificGravity) {
        // should not proceed if status is not OK

        Double totalQuantity = (quantityToStore  / specificGravity) + quantityInCarrier;

        System.out.println("totalQuantity = " + totalQuantity );
        boolean totalQuantityIsWithinLimit = totalQuantity <= maxQuantityInCarrier ? true : false;


        return totalQuantityIsWithinLimit;
    }


    public static void main(String[] args) {
        DoubleCalculs doubleCalculs = new DoubleCalculs();

        boolean shouldProceed = doubleCalculs.checkIfShouldProceed(new Double("1000.9"), new Double(1500), new Double(500), new Double(1));
        System.out.println("when value = 1, shouldProceed = " + shouldProceed );
        shouldProceed = doubleCalculs.checkIfShouldProceed(new Double(1000), new Double(1500), new Double(500), new Double(0.9));
        System.out.println("when value = 0.9, shouldProceed = " + shouldProceed );
        shouldProceed = doubleCalculs.checkIfShouldProceed(new Double("1000.9"), new Double(1500), new Double(500), new Double(1.1));
        System.out.println("when value = 1.1, shouldProceed = " + shouldProceed );

    }
}
