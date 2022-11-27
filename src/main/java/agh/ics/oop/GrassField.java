package agh.ics.oop;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{
    private final ArrayList<Grass> fields = new ArrayList<>();

    public GrassField(int n){
        generateGrass((int) Math.sqrt(n*10));
    }

    private void generateGrass(int n){
        for(int i = 0; i< n; i++){
            int x = ThreadLocalRandom.current().nextInt(0, n);
            int y = ThreadLocalRandom.current().nextInt(0, n);
            if (isOccupied(new Vector2d(x, y))) {
                i--;
            }
            else {
                fields.add(new Grass(new Vector2d(x, y)));
            }
        }
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    protected Vector2d getLeftLowerCorner(){
        Vector2d lowerBound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Grass grass: fields){
            lowerBound = lowerBound.lowerLeft(grass.getPosition());
        }
        for(Animal animal:animalList){
            lowerBound = lowerBound.lowerLeft(animal.getPosition());
        }
        return lowerBound;
    }
    @Override
    protected Vector2d getRightHigherCorner(){
        Vector2d upperBound = new Vector2d(-Integer.MAX_VALUE, -Integer.MAX_VALUE);
        for(Grass grass: fields){
            upperBound = upperBound.upperRight(grass.getPosition());
        }
        for(Animal animal:animalList){
            upperBound = upperBound.upperRight(animal.getPosition());
        }
        return upperBound;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }

    private Grass grassAt(Vector2d position) {
        for (Grass grass : fields) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }
    @Override
    public void moved(Vector2d position) {
        if(grassAt(position) != null){
            generateGrass(1);
            fields.remove(this.grassAt(position));
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object foundObject = super.objectAt(position);
        if (foundObject == null) {
            for (Grass grass : fields) {
                if (Objects.equals(grass.getPosition(), position)) {
                    return grass;
                }
            }
        }
        return foundObject;
    }
}

