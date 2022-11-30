package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{
    protected ArrayList<Animal> animalList = new ArrayList<>();

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal:animalList){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);

        return map.draw(getLeftLowerCorner(), getRightHigherCorner());
    }

    abstract Vector2d getLeftLowerCorner();
    abstract Vector2d getRightHigherCorner();

    public abstract void moved(Vector2d position);
}

