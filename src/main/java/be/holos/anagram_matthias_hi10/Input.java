package be.holos.anagram_matthias_hi10;

import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    public String setInput1() {
        System.out.println("Geef het eerste woord in: ");
        final String wordOne = scanner.nextLine();
        return wordOne;
    }

    public String setInput2() {
        System.out.println("Geef het tweede woord in: ");
        final String wordTwo = scanner.nextLine();
        return wordTwo;
    }
}
