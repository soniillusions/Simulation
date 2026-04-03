package simulation.entities;

public class Tree extends Entity {

    public Tree(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public String getSymbol() {
        return "\uD83C\uDF33";
    }
}
