package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class RectangularMap extends AbstractWorldMap {
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
    protected Vector2d getLeftLowerCorner() {
        return new Vector2d(width,height);
    }

    @Override
    protected Vector2d getRightHigherCorner() {
        return new Vector2d(0,0);
    }

    @Override
    public boolean canMoveTo(Vector2d pos) {
        return (pos.follows(new Vector2d(0,0)) && pos.precedes(new Vector2d(width,height)) && !this.isOccupied(pos));
    }
}
