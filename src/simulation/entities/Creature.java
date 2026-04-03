package simulation.entities;

public abstract class Creature extends Entity {
    private int hp;
    private int speed;

    public Creature(int hp, int speed) {
        this.hp = hp;
        this.speed = speed;
    }

    @Override
    public String getSymbol() {
        return "";
    }

    public int getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }
}
