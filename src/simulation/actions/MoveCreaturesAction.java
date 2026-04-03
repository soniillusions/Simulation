package simulation.actions;

import simulation.core.Coordinate;
import simulation.core.WorldMap;
import simulation.entities.Creature;
import simulation.entities.Entity;
import simulation.entities.Herbivore;
import simulation.entities.Predator;
import simulation.entities.Grass;

import java.util.List;

public class MoveCreaturesAction implements Action {

    @Override
    public void execute(WorldMap worldMap) {
        List<Creature> creatures = worldMap.getCreatures();
        for (Creature creature : creatures) {
            moveCreature(worldMap, creature);
        }
    }

    public void moveCreature(WorldMap worldMap, Creature creature) {
        Coordinate currentPosition = worldMap.getCoordinateByEntity(creature);
        if (currentPosition == null) {
            return;
        }

        if (creature.getHp() <= 0) {
            worldMap.removeEntity(currentPosition);
            return;
        }

        Coordinate targetPosition = creature.findTarget(worldMap);
        if (targetPosition == null) {
            return;
        }

        Entity targetEntity = worldMap.getEntity(targetPosition);
        if (targetEntity != null) {
            handleInteraction(worldMap, creature, targetPosition, targetEntity);
        } else {
            moveForward(worldMap, creature, currentPosition, targetPosition);
        }
    }

    public void moveForward(WorldMap worldMap, Creature creature, Coordinate currentPosition, Coordinate targetPosition) {
        if (targetPosition.getX() < 0 || targetPosition.getX() >= worldMap.getWidth() ||
                targetPosition.getY() < 0 || targetPosition.getY() >= worldMap.getHeight()) {
            return;
        }

        if (worldMap.getEntity(targetPosition) != null) {
            return;
        }

        worldMap.removeEntity(currentPosition);
        worldMap.placeEntity(targetPosition, creature);
    }

    public void handleInteraction(WorldMap worldMap, Creature creature, Coordinate targetPosition, Entity targetEntity) {
        if (creature instanceof Predator && targetEntity instanceof Herbivore) {
            Predator predator = (Predator) creature;
            Herbivore herbivore = (Herbivore) targetEntity;

            herbivore.setHp(herbivore.getHp() - predator.getDamage());
            if (herbivore.getHp() <= 0) {
                worldMap.removeEntity(targetPosition);
            }
        } else if (creature instanceof Herbivore && targetEntity instanceof Grass) {
            creature.setHp(Math.min(creature.getHp() + 3, 20));
            worldMap.removeEntity(targetPosition);
        }
    }
}
