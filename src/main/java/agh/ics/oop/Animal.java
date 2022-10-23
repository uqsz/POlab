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
        Vector2d up = new Vector2d(0,1);
        Vector2d right = new Vector2d(1,0);
        Vector2d down = new Vector2d(0,-1);
        Vector2d left = new Vector2d(-1,0);

        Vector2d left_down_corner = new Vector2d(0,0);
        Vector2d right_up_corner = new Vector2d(4,4);

        Vector2d new_position = this.position_;

        if (direction == MoveDirection.LEFT){
            this.orientation_=this.orientation_.previous();
        }
        else if (direction == MoveDirection.RIGHT) {
            this.orientation_=this.orientation_.next();
        }
        else if (direction == MoveDirection.FORWARD){
            new_position = new_position.add(switch(this.orientation_){
                case NORTH -> up;
                case EAST -> right;
                case SOUTH -> down;
                case WEST -> left;
            });
        }
        else if (direction == MoveDirection.BACKWARD){
            new_position = new_position.add(switch(this.orientation_){
                case NORTH -> down;
                case EAST -> left;
                case SOUTH -> up;
                case WEST -> right;
            });
        }
        if (new_position.follows(left_down_corner) && new_position.precedes(right_up_corner)) {this.position_=new_position;}//*
    }
    //Odpowiedz na podpunkt 10: nalezy stworzyc tablice 2d jako model naszej plaszczyzny, ktora bedzie przechowywala wartosci true jesli dane pole jest zajete przez zwierzaka albo false w przeciwnym wypadku,
    //przy wykonywaniu modulu move, w warunku oznaczonym "*" nalezy dodatkowo sprawdzic, czy nowa pozycja jest wolna, jesli warunki zostaną spelnione ti zajac ją, zwolnic poprzednią oraz zaktualizowac pozycje obiektu
}
