package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] directions) {
        int i=0;
        MoveDirection[] tab = new MoveDirection[directions.length];
        for (String element : directions) {
            switch (element) {
                case "forward", "f" -> {tab[i] = MoveDirection.FORWARD; i++;}
                case "backward", "b" -> {tab[i] = MoveDirection.BACKWARD; i++;}
                case "left", "l" -> {tab[i] = MoveDirection.LEFT; i++;}
                case "right", "r" -> {tab[i] = MoveDirection.RIGHT;i++;}
                default -> { }
            }
        }
        return Arrays.copyOfRange(tab,0,i);
    }
}
