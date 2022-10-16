package agh.ics.oop;
import java.util.Arrays;

public class World {
    public static Direction[] convert(String[] directions) {
        int i=0;
        Direction[] tab = new Direction[directions.length];
        for (String direction : directions) {
            switch (direction) {
                case "f":
                    tab[i]=Direction.FORWARD;
                    i++;
                    break;
                case "b":
                    tab[i]=Direction.BACKWARD;
                    i++;
                    break;
                case "l":
                    tab[i]=Direction.LEFT;
                    i++;
                    break;
                case "r":
                    tab[i]=Direction.RIGHT;
                    i++;
                    break;
                default:
                    break;
            };
        }
        Direction dir[] = Arrays.copyOfRange(tab,0,i);
        return dir;
    }
    public static void run(Direction[] tab){
        for(Direction direction : tab){
            String text = switch(direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
            };
            System.out.println(text);
        }
    }
    public static void main(String[] args) {
        System.out.println("Start");
        Direction[] dir=convert(args);
        run(dir);
        System.out.println("Stop");
    }
}

