package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.view.UI;

public class FakeUI implements UI {

    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public String getInput(String prompt) {
        return input;
    }
}
