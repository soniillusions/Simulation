package simulation.core;

import java.util.Map;

import simulation.entities.Entity;

import java.util.HashMap;

public class WorldMap {
    private Map<Coordinate, Entity> entities;
    private final int width;
    private final int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }

    public Map<Coordinate, Entity> getEntities() {
        return entities;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void placeEntity(Coordinate coordinate, Entity entity) {
        entities.put(coordinate, entity);
    }

    public Entity getEntity(Coordinate coordinate) {
        return entities.get(coordinate);
    }
}
