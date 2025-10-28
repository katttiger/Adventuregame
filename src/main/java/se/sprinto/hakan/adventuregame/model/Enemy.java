package se.sprinto.hakan.adventuregame.model;

public class Enemy extends AbstractCharacter {

    public Enemy(String name, int health, int score, int strength) {
        super();
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }
}
