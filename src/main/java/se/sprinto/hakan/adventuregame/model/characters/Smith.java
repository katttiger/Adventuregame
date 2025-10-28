package se.sprinto.hakan.adventuregame.model.characters;

public class Smith extends AbstractCharacter {

    public Smith(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    public void increasePlayerStrength(Player player) {
        player.setStrength(player.getStrength() + 10);
    }

    @Override
    public void attack(AbstractCharacter target) {

    }
}
