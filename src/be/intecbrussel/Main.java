package be.intecbrussel;

import be.intecbrussel.DO_NOT_TOUCH.ErrorSystem;
import be.intecbrussel.DO_NOT_TOUCH.InternalApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new InternalApp().start(); // DO NOT TOUCH

        // Hieronder plaats je de code.
        // Met de methode getError(), krijg je een error,
        // Met de methode fixError(String error, level), kan je de behandelde error opslaan.
        //---------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int input;
        String error = "";

        System.out.println("\nPlease enter the priority level for all the errors below!\nLevels: 1.LOW - 2.MEDIUM - 3.HIGH - 4.NO_ISSUE ");
        while (true) {
            i++;
            error = getError();

            if (error == null) {
                break;
            }

            System.out.println("\n" + i + " - " + error);
            input = scanner.nextInt();

            while (input < 1 || input > 4) {
                System.out.println("Invalid level! Please enter 1, 2, 3, or 4 to give a priority level to the error.");
                input = scanner.nextInt();
            }
            String result = "";

            switch (input) {
                case 1:
                    result = "LOW - " + error;
                    fixError(result, PriorityLevel.LOW.getDescription());
                    break;
                case 2:
                    result = "MEDIUM - " + error;
                    fixError(result, PriorityLevel.MEDIUM.getDescription());
                    break;
                case 3:
                    result = "HIGH - " + error;
                    fixError(result, PriorityLevel.HIGH.getDescription());
                    break;
                case 4:
                    result = "NO ISSUE - " + PriorityLevel.NO_ISSUE.getDescription();
                    System.out.println(result);
                    break;
            }
        }
        //---------------------------------------------------

        printOverview();
    }

    // ---------------------------
    // DO NOT TOUCH ANYTHING BELOW
    // ---------------------------
    private static String getError() {
        return ErrorSystem.pollError();
    }

    private static void fixError(String error, Object level) {
        ErrorSystem.handledError(error, level);
    }

    private static void printOverview(){
        System.out.println("---------------------------\n");
        System.out.println("       HANDLED ERROR       \n");
        System.out.println("---------------------------\n");

        for (String handledError : ErrorSystem.getHandledErrors()) {
            System.out.println(handledError);
        }


        System.out.println("---------------------------\n");
        System.out.println("      UNHANDLED ERROR      \n");
        System.out.println("---------------------------\n");

        for (String unHandledError : ErrorSystem.getUnHandledErrors()) {
            System.out.println(unHandledError);
        }
    }
}