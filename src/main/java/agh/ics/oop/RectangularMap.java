package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    public RectangularMap(int width, int height){
        super();
        this.width=width;
        this.height=height;
    }
    @Override
    public Vector2d getLeftLowerCorner() {
        return new Vector2d(width,height);
    }

    @Override
    public Vector2d getRightHigherCorner() {
        return new Vector2d(0,0);
    }

    @Override
    public boolean canMoveTo(Vector2d pos) {
        return (pos.follows(new Vector2d(0,0)) && pos.precedes(new Vector2d(width,height)) && !this.isOccupied(pos));
    }
}
