package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    private final List<Animal> map;
    private final MapVisualizer mapVisualizer;

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
        this.map=new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
    }
    @Override
    public String toString() {
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(width,height));
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }
    @Override
    public boolean canMoveTo(Vector2d pos) {
        return (pos.follows(new Vector2d(0,0)) && pos.precedes(new Vector2d(width,height)) && !this.isOccupied(pos));
    }
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            map.add(animal);
            return true;
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : map) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }
}
