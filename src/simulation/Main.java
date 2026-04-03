package simulation;

import simulation.entities.Coordinate;
import simulation.entities.Grass;

public class Main {
    static void main() {
        Coordinate coordinate = new Coordinate(0, 1);
        Grass grass = new Grass(coordinate);
        String symbol = grass.getSymbol();
        System.out.println(symbol);
    }
}