package agh.ics.oop;

import java.util.List;

public class GrassField implements IWorldMap{
    private int fieldsAmount;
    private final List<Vector2d> fields;

    public GrassField(int n){
        this.fieldsAmount=n;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
