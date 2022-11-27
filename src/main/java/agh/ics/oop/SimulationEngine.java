package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class SimulationEngine implements IEngine{
    public final MoveDirection[] directions;
    public final IWorldMap map;
    public final Vector2d[] positions;
    private final List<Animal> animals= new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                animals.add(animal);
            }
        }
    }
    @Override
    public void run() {
        int numbersOfAnimals=animals.size();
        for (int i=0;i<directions.length;i++){
            animals.get(i%numbersOfAnimals).move(directions[i]);
        }
    }
}
