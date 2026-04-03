package simulation.actions;

import simulation.core.Coordinate;
import simulation.core.WorldMap;
import simulation.entities.*;

import java.util.Map;
import java.util.Random;

public class SpawnEntitiesAction implements Action {
    private final int grassCount = 7;
    private final int rockCount = 7;
    private final int treeCount = 7;
    private final int herbivoreCount = 5;
    private final int predatorCount = 3;
    private Random random;

    public SpawnEntitiesAction() {
        this.random = new Random();
    }

    @Override
    public void execute(WorldMap worldMap) {
        spawnEntities(worldMap, new Grass(), grassCount);
        spawnEntities(worldMap, new Rock(), rockCount);
        spawnEntities(worldMap, new Tree(), treeCount);
        spawnCreatures(worldMap, herbivoreCount, predatorCount);
    }

    public void spawnEntities(WorldMap worldMap, Entity entity, int amount) {
        for (int i = 0; i < amount; i++) {
            spawnEntityAtRandomPosition(worldMap, entity);
        }
    }

    public void spawnCreatures(WorldMap worldMap, int herbivoreCount, int predatorCount) {
        for (int i = 0; i < herbivoreCount; i++) {
            Herbivore herbivore = new Herbivore(10, 1);
            spawnEntityAtRandomPosition(worldMap, herbivore);
        }

        for (int i = 0; i < predatorCount; i++) {
            Predator predator = new Predator(10, 1, 3);
            spawnEntityAtRandomPosition(worldMap, predator);
        }
    }

    public void spawnEntityAtRandomPosition(WorldMap worldMap, Entity entity) {
        int maxAttempts = worldMap.getWidth() * worldMap.getHeight();
        for (int i = 0; i < maxAttempts; i++) {
            int x = random.nextInt(worldMap.getWidth());
            int y = random.nextInt(worldMap.getHeight());

            Coordinate coordinate = new Coordinate(x, y);
            Map<Coordinate, Entity> entities = worldMap.getEntities();
            if (entities.get(coordinate) != null) {
                continue;
            } else {
                worldMap.placeEntity(coordinate, entity);
                break;
            }
        }
    }
}
