package simulation.entities;

public class Predator extends Creature {
    private int damage;

    public Predator(int hp, int speed, int damage) {
        super(hp, speed);
        this.damage = damage;
    }

    @Override
    public String getSymbol() {
        return "\uD83D\uDC3A";
    }

    public int getDamage() {
        return damage;
    }
}
