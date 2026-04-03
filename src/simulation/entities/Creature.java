package simulation.entities;

import simulation.core.Coordinate;
import simulation.core.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Creature extends Entity {
    private int hp;
    private int speed;
    private Random random;

    public Creature(int hp, int speed) {
        this.hp = hp;
        this.speed = speed;
        this.random = new Random();
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Coordinate findTarget(WorldMap worldMap) {
        Coordinate currentPosition = worldMap.getCoordinateByEntity(this);

        boolean canTop = checkTop(worldMap, currentPosition);
        boolean canBottom = checkBottom(worldMap, currentPosition);
        boolean canLeft = checkLeft(worldMap, currentPosition);
        boolean canRight = checkRight(worldMap, currentPosition);

        List<Coordinate> availableMoves = new ArrayList<>();

        if (canTop) {
            availableMoves.add(new Coordinate(currentPosition.getX(), currentPosition.getY() - 1));
        }
        if (canBottom) {
            availableMoves.add(new Coordinate(currentPosition.getX(), currentPosition.getY() + 1));
        }
        if (canLeft) {
            availableMoves.add(new Coordinate(currentPosition.getX() - 1, currentPosition.getY()));
        }
        if (canRight) {
            availableMoves.add(new Coordinate(currentPosition.getX() + 1, currentPosition.getY()));
        }

        if (availableMoves.isEmpty()) {
            return currentPosition;
        }

        return availableMoves.get(random.nextInt(availableMoves.size()));
    }

    public boolean checkTop(WorldMap worldMap, Coordinate currentPosition) {
        int y = currentPosition.getY();
        if (y <= 0) {
            return false;
        }
        Coordinate nextPosition = new Coordinate(currentPosition.getX(), y - 1);
        return worldMap.getEntity(nextPosition) == null;
    }

    public boolean checkBottom(WorldMap worldMap, Coordinate currentPosition) {
        int y = currentPosition.getY();
        if (y >= worldMap.getHeight() - 1) {
            return false;
        }
        Coordinate nextPosition = new Coordinate(currentPosition.getX(), y + 1);
        return worldMap.getEntity(nextPosition) == null;
    }

    public boolean checkLeft(WorldMap worldMap, Coordinate currentPosition) {
        int x = currentPosition.getX();
        if (x <= 0) {
            return false;
        }
        Coordinate nextPosition = new Coordinate(x - 1, currentPosition.getY());
        return worldMap.getEntity(nextPosition) == null;
    }

    public boolean checkRight(WorldMap worldMap, Coordinate currentPosition) {
        int x = currentPosition.getX();
        if (x >= worldMap.getWidth() - 1) {
            return false;
        }
        Coordinate nextPosition = new Coordinate(x + 1, currentPosition.getY());
        return worldMap.getEntity(nextPosition) == null;
    }
}
