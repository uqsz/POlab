package agh.ics.oop;
import java.util.Arrays;

public class World {
    public static MoveDirection[] convert(String[] directions) {
        int i=0;
        MoveDirection[] tab = new MoveDirection[directions.length];
        for (String element : directions) {
            switch (element) {
                case "f": tab[i]=MoveDirection.FORWARD; i++; break;
                case "b": tab[i]=MoveDirection.BACKWARD; i++; break;
                case "l": tab[i]=MoveDirection.LEFT; i++; break;
                case "r": tab[i]=MoveDirection.RIGHT; i++; break;
                default: break;
            };
        }
        MoveDirection result[] = Arrays.copyOfRange(tab,0,i);
        return result;
    }
    public static void run(MoveDirection[] tab){
        for(MoveDirection element : tab){
            System.out.println(switch(element) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
            });
        }
    }

    public static void main(String[] args) {
        System.out.println("Start");
        MoveDirection[] moves=convert(args);
        run(moves);
        System.out.println("Stop");
    }
}

