package agh.ics.oop;

class Animal {
    private Vector2d position_ = new Vector2d(2,2);
    private MapDirection orientation_ = MapDirection.NORTH;

    public String toString(){
        return position_.toString()+" "+orientation_.toString();
    }
    public boolean isAt(Vector2d position){
        return this.position_.equals(position);
    }
    public boolean isOriented(MapDirection orientation){
        return this.orientation_.equals(orientation);
    }
    public void move(MoveDirection direction){
        Vector2d left_down_corner = new Vector2d(0,0);
        Vector2d right_up_corner = new Vector2d(4,4);

        Vector2d new_position = this.position_;

        switch(direction) {
            case LEFT -> this.orientation_ = this.orientation_.previous();
            case RIGHT -> this.orientation_ = this.orientation_.next();
            case FORWARD -> new_position = new_position.add(this.orientation_.toUnitVector());
            case BACKWARD -> new_position = new_position.add(this.orientation_.toUnitVector().opposite());
        }
        if (new_position.follows(left_down_corner) && new_position.precedes(right_up_corner)) {this.position_=new_position;}//*
    }
    //Odpowiedz na podpunkt 10: nalezy stworzyc tablice 2d jako model naszej plaszczyzny, ktora bedzie przechowywala wartosci true jesli dane pole jest zajete albo false w przeciwnym wypadku,
    //przy wyykonywaniu modulu move w warunku oznaczonym "*" nalezy dodatkowo sprawdzic, czy nowa pozycja jest wolna, jesli warunki zostaną spelnione to zajac ją, zwolnic poprzednią oraz zaktualizowac pozycje obiektu
}
