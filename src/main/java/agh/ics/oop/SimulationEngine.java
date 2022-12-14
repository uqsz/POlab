package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine{
    public MoveDirection[] directions;
    public IWorldMap map;
    private final Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.canMoveTo(position)) {
                map.place(new Animal(map, position));
                animal.addObserver((IPositionChangeObserver) map);
            }
        }
    }
    @Override
    public void run() {
        int AnimalsNumber = positions.length;
        for (int i=0;i<directions.length;i++){
            Animal newAnimal = (Animal) map.objectAt(positions[i%AnimalsNumber]);
            newAnimal.move(directions[i]);
            positions[i%AnimalsNumber] = newAnimal.getPosition();
        }
    }
}
