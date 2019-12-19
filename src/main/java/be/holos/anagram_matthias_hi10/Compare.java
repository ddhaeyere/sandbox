package be.holos.anagram_matthias_hi10;

public class Compare {

    public boolean letsCompare(final String wordUno, final String wordDos) {
        if (wordUno.length() != wordDos.length()) {
            return false;
        }

        final int[] letters = new int[128];

        for (final char c : wordUno.toCharArray()) {

            letters[c]++;
        }

        for (int j = 0; j < wordDos.length(); j++) {

            final int c = (int) wordDos.charAt(j);

            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    private boolean areAnagrams(final String firstWord, final String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }

        String copy = secondWord;

        for (int i = 0; i < firstWord.length(); i++) {
            copy = copy.replaceFirst(firstWord.substring(i, i + 1), "");
        }
        if (copy.length() != 0) {
            return false;
        }
        return true;
    }

    public void compareChecker() {
        final Input input = new Input();
        final String firstWord = input.setInput1();
        final String secondWord = input.setInput2();
        if (letsCompare(firstWord, secondWord)) {
            System.out.println("Wat een mooie anagram!");
        } else {
            System.out.println("Dit is helemaal geen anagram!");
        }
        if (areAnagrams(firstWord, secondWord)) {
            System.out.println("Wat een mooie anagram!");
        } else {
            System.out.println("Dit is helemaal geen anagram!");
        }
    }
}
