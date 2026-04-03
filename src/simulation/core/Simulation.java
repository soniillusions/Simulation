package simulation.core;

import simulation.actions.MoveCreaturesAction;
import simulation.actions.SpawnEntitiesAction;
import simulation.renderer.ConsoleRenderer;

public class Simulation {
    private WorldMap worldMap;
    private SpawnEntitiesAction spawnEntitiesAction;
    private ConsoleRenderer consoleRenderer;
    private MoveCreaturesAction moveCreaturesAction;
    private int width = 10;
    private int height = 10;

    public Simulation() {
        this.worldMap = new WorldMap(width, height);
        this.spawnEntitiesAction = new SpawnEntitiesAction();
        this.consoleRenderer = new ConsoleRenderer();
        this.moveCreaturesAction = new MoveCreaturesAction();
    }

    public void startSimulation() {
        spawnEntitiesAction.execute(worldMap);
        consoleRenderer.renderWorldState(worldMap);
        System.out.println();
        sleepSimulation();

        while (true) {
            moveCreaturesAction.execute(worldMap);
            consoleRenderer.renderWorldState(worldMap);
            System.out.println();
            sleepSimulation();
        }
    }

    public void sleepSimulation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Сон был прерван!");
            e.printStackTrace();
        }
    }
}
