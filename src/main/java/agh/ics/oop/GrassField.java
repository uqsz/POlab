package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{
    protected HashMap<Vector2d,Grass> fields = new HashMap<>();

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
                fields.put(new Vector2d(x, y),new Grass(new Vector2d(x, y)));
            }
        }
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return (fields.containsKey(position) || super.isOccupied(position));
    }

    protected Vector2d getLeftLowerCorner(){
        Vector2d lowerBound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Vector2d position: fields.keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }
        for(Vector2d position: animalMap.keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }
        return lowerBound;
    }
    @Override
    protected Vector2d getRightHigherCorner(){
        Vector2d upperBound = new Vector2d(-Integer.MAX_VALUE, -Integer.MAX_VALUE);
        for(Vector2d position : fields.keySet()){
            upperBound = upperBound.upperRight(position);
        }
        for(Vector2d position: animalMap.keySet()){
            upperBound = upperBound.upperRight(position);
        }
        return upperBound;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animalMap.containsKey(position);
    }
    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) == null) {
            return fields.get(position);
        }
        return super.objectAt(position);
    }
}

