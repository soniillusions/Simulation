package simulation.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import simulation.entities.Creature;
import simulation.entities.Entity;

import java.util.HashMap;

public class WorldMap {
    private Map<Coordinate, Entity> entities;
    private Map<Entity, Coordinate> entityToCoordinate;
    private final int width;
    private final int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
        this.entityToCoordinate = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void placeEntity(Coordinate coordinate, Entity entity) {
        entities.put(coordinate, entity);
        entityToCoordinate.put(entity, coordinate);
    }

    public void removeEntity(Coordinate coordinate) {
        Entity entity = entities.remove(coordinate);
        if (entity != null) {
            entityToCoordinate.remove(entity);
        }
    }

    public Coordinate getCoordinateByEntity(Entity entity) {
        return entityToCoordinate.get(entity);
    }

    public Entity getEntity(Coordinate coordinate) {
        return entities.get(coordinate);
    }

    public Map<Coordinate, Entity> getEntities() {
        return entities;
    }

    public List<Creature> getCreatures() {
        List<Creature> creatures = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }
        return creatures;
    }
}
