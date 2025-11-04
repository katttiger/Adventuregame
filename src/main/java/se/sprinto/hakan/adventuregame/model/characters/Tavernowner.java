package se.sprinto.hakan.adventuregame.model.characters;

public class Tavernowner extends AbstractCharacter {

    public Tavernowner(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    public void servePlayerGoodMeal(Player player) {
        player.setHealth(player.getHealth() + 10);
    }

    public void servePlayerLessGoodMeal(Player player) {
        player.setHealth(player.getHealth() - 10);
    }

    @Override
    public void attack(AbstractCharacter target) {
    }
}
