package be.holos.string;

/**
 * @author Dieter D'haeyere on 30/12/14.
 */
public class StringPlayGround {


    public String revertString(String stringToRevert) {
        return new StringBuilder(stringToRevert).reverse().toString();
    }

    public String fetchSerialNoDescription(String description) {

        int length = description.length();

        int startOfFirstDashesIndex = getStartOfFirstDashesIndex(description, length);

        return description.substring(0,startOfFirstDashesIndex);

    }

    public String fetchSerialNoLineNoDescription(String description) {
        int length = description.length();
        int beginningOfLastDashesIndex = getBeginningOfLastDashesIndex(description, length);


        int endOfFirstDashesIndex = getEndOfFirstDashesIndex(description, beginningOfLastDashesIndex);
        return description.substring(endOfFirstDashesIndex, beginningOfLastDashesIndex);
    }

    private int getStartOfFirstDashesIndex(String description, int length) {
        int beginningOfLastDashesIndex = getBeginningOfLastDashesIndex(description, length);

        int endOfFirstDashesIndex = beginningOfLastDashesIndex - 1;
        boolean endOfFirstDashesFound = false;

        while(!endOfFirstDashesFound) {
            if(description.charAt(endOfFirstDashesIndex)!='-') {
                endOfFirstDashesIndex--;
            } else {
                endOfFirstDashesFound = true;
            }

        }

        int startOfFirstDashesIndex = endOfFirstDashesIndex;
        while(description.charAt(startOfFirstDashesIndex)=='-') {
            startOfFirstDashesIndex--;
        }
        startOfFirstDashesIndex++;
        return startOfFirstDashesIndex;
    }

    private int getBeginningOfLastDashesIndex(String description, int length) {
        int beginningOfLastDashesIndex = length-1;
        boolean beginningOfLastDashesFound = false;
        while(!beginningOfLastDashesFound) {
            if(description.charAt(beginningOfLastDashesIndex)=='-') {
                beginningOfLastDashesIndex--;
            } else {
                beginningOfLastDashesFound = true;
                beginningOfLastDashesIndex++;
            }
        }
        return beginningOfLastDashesIndex;
    }




    private int getEndOfFirstDashesIndex(String description, int beginningOfLastDashesIndex) {
        int endOfFirstDashesIndex = beginningOfLastDashesIndex -1;
        boolean startOfFirstDashesFound = false;

        while(!startOfFirstDashesFound) {
            if(description.charAt(endOfFirstDashesIndex)!='-') {
                endOfFirstDashesIndex--;
            } else {
                startOfFirstDashesFound = true;
                endOfFirstDashesIndex++;
            }

        }
        return endOfFirstDashesIndex;
    }


    public static void main (String[] args) {
        String text = "In that case, I will continue like this. It might be fun. I wonder how long it will take to write this kind of text though. Anyway, like this the details in the language might be harder to find. Except if I write a small program to do this faster like I did just now :p";

        String invertedString = new StringBuilder(text).reverse().toString();
        System.out.println(invertedString);



    }


}
