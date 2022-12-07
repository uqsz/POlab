package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected final Map<Vector2d, Animal> animalMap=new HashMap<>();;

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())) {
            animalMap.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position) {
        return animalMap.get(position);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return (objectAt(position)!=null);
    }
    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(getLeftLowerCorner(), getRightHigherCorner());
    }

    abstract Vector2d getLeftLowerCorner();
    abstract Vector2d getRightHigherCorner();
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalMap.get(oldPosition);
        animalMap.remove(oldPosition);
        animalMap.put(newPosition, animal);
    }
}

