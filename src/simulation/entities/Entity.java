package simulation.entities;

public abstract class Entity {
    private Coordinate coordinate;

    public Entity(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public abstract String getSymbol();
}
