package agh.ics.oop;

public class World {
    public static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    public static final Vector2d UPPER_BOUND = new Vector2d(4,4);
    public static void run(MoveDirection[] tab, Animal pet){
        for(MoveDirection element : tab){
            switch(element) {
                case FORWARD -> pet.move(MoveDirection.FORWARD);
                case BACKWARD -> pet.move(MoveDirection.BACKWARD);
                case LEFT -> pet.move(MoveDirection.LEFT);
                case RIGHT -> pet.move(MoveDirection.RIGHT);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Start");
        Animal puszek = new Animal();
        System.out.println(puszek);
        System.out.println("Stop");
    }
}

