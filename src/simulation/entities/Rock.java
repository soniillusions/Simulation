package simulation.entities;

public class Rock extends Entity {

    public Rock(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public String getSymbol() {
        return "\uD83E\uDEA8";
    }
}
