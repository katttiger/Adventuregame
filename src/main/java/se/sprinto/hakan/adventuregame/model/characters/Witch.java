package se.sprinto.hakan.adventuregame.model.characters;

public class Witch extends AbstractCharacter {
    public Witch(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    public void healPlayerNormal(Player player) {
        player.setHealth(player.getHealth() + 10);
    }

    public void healPlayerBoost(Player player) {
        player.setHealth(player.getHealth() + 20);
    }

    @Override
    public void attack(AbstractCharacter target) {

        target.setHealth(target.getHealth() - 10);
    }
}
