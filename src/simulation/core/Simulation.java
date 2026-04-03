package simulation.core;

import simulation.actions.SpawnEntitiesAction;
import simulation.renderer.ConsoleRenderer;

public class Simulation {
    private WorldMap worldMap;
    private SpawnEntitiesAction spawnEntitiesAction;
    private ConsoleRenderer consoleRenderer;
    private int width = 10;
    private int height = 10;

    public Simulation() {
        this.worldMap = new WorldMap(width, height);
        this.spawnEntitiesAction = new SpawnEntitiesAction();
        this.consoleRenderer = new ConsoleRenderer();
    }

    public void startSimulation() {
        spawnEntitiesAction.execute(worldMap);
        consoleRenderer.renderWorldState(worldMap);
    }
}
