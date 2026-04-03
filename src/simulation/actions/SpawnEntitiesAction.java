package simulation.actions;

import simulation.core.Coordinate;
import simulation.core.WorldMap;
import simulation.entities.Entity;
import simulation.entities.Grass;
import simulation.entities.Rock;
import simulation.entities.Tree;

import java.util.Map;
import java.util.Random;

public class SpawnEntitiesAction implements Action {
    private final int grassCount = 7;
    private final int rockCount = 7;
    private final int treeCount = 7;
    private Random random;

    public SpawnEntitiesAction() {
        this.random = new Random();
    }

    @Override
    public void execute(WorldMap worldMap) {
        spawnEntities(worldMap, new Grass(), grassCount);
        spawnEntities(worldMap, new Rock(), rockCount);
        spawnEntities(worldMap, new Tree(), treeCount);
    }

    public void spawnEntities(WorldMap worldMap, Entity entity, int amount) {
        for (int i = 0; i < amount; i++) {
            spawnEntityAtRandomPosition(worldMap, entity);
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
