package agh.ics.oop;

public class World {
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

