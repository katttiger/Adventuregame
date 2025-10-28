package se.sprinto.hakan.adventuregame.model.characters;

public class Witch extends AbstractCharacter {
    public Witch(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    public void healPlayerNormal(Player player) {
        System.out.println("""
                The witch admires your courage and rewards you.
                Your health is increased by 10 HP.
                """);
        player.setHealth(player.getHealth() + 10);
    }

    public void healPlayerBoost(Player player) {
        System.out.println("""
                The witch admires your respect for her and rewards you.
                Your health is increased by 20 HP.
                """);
        player.setHealth(player.getHealth() + 20);
    }

    @Override
    public void attack(AbstractCharacter target) {
        System.out.println("""
                The witch casts a spell on you. 
                You feel sick and hear her cackling.
                You loose 10 HP.""");
        target.setHealth(target.getHealth() - 10);
    }
}
