package simulation.entities;

public class Grass extends Entity {

    public Grass(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public String getSymbol() {
        return "\uD83C\uDF3F";
    }
}
