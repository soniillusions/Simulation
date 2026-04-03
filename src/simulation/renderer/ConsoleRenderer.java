package simulation.renderer;

import simulation.core.Coordinate;
import simulation.core.WorldMap;
import simulation.entities.Entity;

import java.util.Map;

public class ConsoleRenderer {
    public void renderWorldState(WorldMap worldMap) {
        int width = worldMap.getWidth();
        int height = worldMap.getHeight();

        Map<Coordinate, Entity> entities = worldMap.getEntities();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                Entity entity = entities.get(coordinate);

                if (entity != null) {
                    System.out.print(entity.getSymbol() + " ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}
