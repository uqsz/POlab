package agh.ics.oop;

import static agh.ics.oop.World.UPPER_BOUND;

class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    public String toString(){
        return position.toString()+" "+orientation.toString();
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
        if (newPosition.follows(World.LOWER_BOUND) && newPosition.precedes(World.UPPER_BOUND)) {this.position=newPosition;}//*
    }
    //Odpowiedz na podpunkt 10: nalezy stworzyc tablice 2d jako model naszej plaszczyzny, ktora bedzie przechowywala wartosci true jesli dane pole jest zajete albo false w przeciwnym wypadku,
    //przy wyykonywaniu modulu move w warunku oznaczonym "*" nalezy dodatkowo sprawdzic, czy nowa pozycja jest wolna, jesli warunki zostaną spelnione to zajac ją, zwolnic poprzednią oraz zaktualizowac pozycje obiektu
}
