package se.sprinto.hakan.adventuregame.view;

import java.util.Scanner;

public class ScannerUI implements UI {
    //OK att instansiera Scanner här i detta fall,
    //eftersom denna implementation ska använda just en Scanner
    //och inget annat
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void returnToMenuPrompt() {
        System.out.println("Tryck enter för att återvända till menyn.");
        scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}

