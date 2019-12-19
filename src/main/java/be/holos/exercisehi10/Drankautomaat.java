package be.holos.exercisehi10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Drankautomaat {

    static int cola = 5;
    static int fanta = 5;
    static int water = 5;
    static int keuze;
    static int maxHoeveelheid = 50;

    public static void main(final String[] args) {
        System.out.println("Welkom bij onze drankautomaat." + "\n" + "\n" + "Wij bieden Cola, Fanta & Chaudfontaine aan:" +
                "\n" + "\n" + "Cola = Knop 1" + "\n" + "\n" + "Fanta = Knop 2" + "\n" + "\n" + "Chaudfontaine = Knop 3" + "\n" + "\n" +
                "Uw keuze =" + "\n");
        while (true) {
            invoer();
            if (keuze == 123) {
                Admin.hoeveelheidView();
            } else if (keuze == 321) {
                Admin.hoeveelheidManagement();
            } else {
                Consument.klantKoopt();
            }
        }
    }

    public static int invoer() {

        final Scanner artikel = new Scanner(System.in);
        boolean validData = false;

        do {

            try {
                keuze = artikel.nextInt();
                if (keuze <= 3 && keuze > 0 || keuze == 123 || keuze == 321) {
                    validData = true;
                } else {
                    System.out.println("\n" + "Deze knop is niet bruikbaar." + "\n");
                    validData = false;
                }
            } catch (final InputMismatchException e) {

                System.out.println("\n" + "Druk op één van de juiste knoppen." + "\n");
                artikel.next();
            }
        } while (validData == false);
        return keuze;
    }
}

class Consument {

    public static void klantKoopt() {

        final int mijnKeuze = Drankautomaat.keuze;

        if (mijnKeuze == 1) {
            if (Drankautomaat.cola > 0) {
                System.out.println("\n" + "Geniet van uw Cola." + "\n");
                Drankautomaat.cola = Drankautomaat.cola - 1;
            } else {
                System.out.println("\n" + "Helaas, Cola is niet meer verkrijbraag." + "\n");
            }
        } else if (mijnKeuze == 2) {
            if (Drankautomaat.fanta > 0) {
                System.out.println("\n" + "Geniet van uw Fanta." + "\n");
                Drankautomaat.fanta = Drankautomaat.fanta - 1;
            } else {
                System.out.println("\n" + "Helaas, Fanta is niet meer verkrijbraag." + "\n");
            }
        } else if (mijnKeuze == 3) {
            if (Drankautomaat.water > 0) {
                System.out.println("\n" + "Geniet van uw Chaudfontaine." + "\n");
                Drankautomaat.water = Drankautomaat.water - 1;
            } else {
                System.out.println("\n" + "Helaas, Chaudfontaine is niet meer verkrijbraag." + "\n");
            }
        }
    }
}

class Admin {

    public static void hoeveelheidView() {

        int view;
        final Scanner artikelView = new Scanner(System.in);
        boolean validData = false;

        System.out.println("\n" + "Welkom Admin." + "\n" + "\n" + "De hoeveelheid Cola, Fanta & Chaudfontaine in stock:" +
                "\n" + "\n" + "Cola = Knop 1" + "\n" + "\n" + "Fanta = Knop 2" + "\n" + "\n" + "Chaudfontaine = Knop 3" + "\n" + "\n" +
                "Uw keuze =" + "\n");

        do {

            try {
                view = artikelView.nextInt();
                if (view <= 3 && view > 0) {
                    if (view == 1) {
                        System.out.println("\n" + "Hoeveelheid Cola: " + Drankautomaat.cola + "\n");
                    } else if (view == 2) {
                        System.out.println("\n" + "Hoeveelheid Fanta: " + Drankautomaat.fanta + "\n");
                    } else if (view == 3) {
                        System.out.println("\n" + "Hoeveelheid Chaudfontaine: " + Drankautomaat.water + "\n");
                    }
                    validData = false;
                } else if (view == 123) {
                    System.out.println("\n" + "Welkom bij onze drankautomaat." + "\n" + "\n" + "Wij bieden Cola, Fanta & Chaudfontaine aan:" +
                            "\n" + "\n" + "Cola = Knop 1" + "\n" + "\n" + "Fanta = Knop 2" + "\n" + "\n" + "Chaudfontaine = Knop 3" + "\n" + "\n" +
                            "Uw keuze =" + "\n");
                    validData = true;
                } else {
                    System.out.println("\n" + "Deze knop is niet bruikbaar." + "\n");
                    validData = false;
                }
            } catch (final InputMismatchException e) {

                System.out.println("\n" + "Druk op één van de juiste knoppen." + "\n");
                artikelView.next();
            }
        } while (validData == false);
    }

    public static void hoeveelheidManagement() {

        int view2;
        int hoeveelheid;
        final Scanner artikelView2 = new Scanner(System.in);
        boolean validData = false;

        System.out.println("\n" + "Welkom Admin." + "\n" + "\n" + "De hoeveelheid Cola, Fanta of Chaudfontaine bijvullen:" +
                "\n" + "\n" + "Cola = Knop 1" + "\n" + "\n" + "Fanta = Knop 2" + "\n" + "\n" + "Chaudfontaine = Knop 3" + "\n" + "\n" +
                "Uw keuze =" + "\n");

        do {

            try {
                view2 = artikelView2.nextInt();
                if (view2 <= 3 && view2 > 0) {
                    if (view2 == 1) {
                        System.out.println("\n" + "Hoeveelheid Cola: " + Drankautomaat.cola + "\n");
                    } else if (view2 == 2) {
                        System.out.println("\n" + "Hoeveelheid Fanta: " + Drankautomaat.fanta + "\n");
                    } else if (view2 == 3) {
                        System.out.println("\n" + "Hoeveelheid Chaudfontaine: " + Drankautomaat.water + "\n");
                    }
                    validData = false;
                } else if (view2 == 321) {
                    System.out.println("\n" + "Welkom bij onze drankautomaat." + "\n" + "\n" + "Wij bieden Cola, Fanta & Chaudfontaine aan:" +
                            "\n" + "\n" + "Cola = Knop 1" + "\n" + "\n" + "Fanta = Knop 2" + "\n" + "\n" + "Chaudfontaine = Knop 3" + "\n" + "\n" +
                            "Uw keuze =" + "\n");
                    validData = true;
                } else {
                    System.out.println("\n" + "Deze knop is niet bruikbaar." + "\n");
                    validData = false;
                }
            } catch (final InputMismatchException e) {

                System.out.println("\n" + "Druk op één van de juiste knoppen." + "\n");
                artikelView2.next();
            }
        } while (validData == false);
    }
}
