package agh.ics.oop;

class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    public Animal(IWorldMap map) {
        this.map = map;
        this.orientation = MapDirection.NORTH;
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map=map;
        this.position=initialPosition;
        this.orientation=MapDirection.NORTH;
    }
    public Vector2d getPosition() {
        return position;
    }
    public String toString(){
        return switch(this.orientation){
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public boolean isOriented(MapDirection orientation){
        return this.orientation.equals(orientation);
    }
    public void move(MoveDirection direction){
        Vector2d newPosition = this.position;

        switch(direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> newPosition = newPosition.add(this.orientation.toUnitVector());
            case BACKWARD -> newPosition = newPosition.add(this.orientation.toUnitVector().opposite());
        }
        if (this.map.canMoveTo(newPosition)) {this.position=newPosition;}
    }
}
