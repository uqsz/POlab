package agh.ics.oop;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static agh.ics.oop.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetMovesTest {
    @Test
    void final_orientation(){
        MoveDirection[] moves1 = new MoveDirection[]{FORWARD, RIGHT, FORWARD, FORWARD, LEFT, LEFT, FORWARD, BACKWARD, RIGHT};
        MoveDirection[] moves2 = new MoveDirection[]{BACKWARD, BACKWARD, LEFT, BACKWARD, RIGHT, BACKWARD, LEFT, FORWARD, LEFT};
        Animal puszek_test1 = new Animal();
        Animal puszek_test2 = new Animal();

        World.run(moves1,puszek_test1);
        World.run(moves2,puszek_test2);

        assertTrue(puszek_test1.isOriented(MapDirection.NORTH));
        assertTrue(puszek_test2.isOriented(MapDirection.SOUTH));
    }

    @Test
    void final_position(){
        MoveDirection[] moves1 = new MoveDirection[]{FORWARD, RIGHT, FORWARD, FORWARD, LEFT, LEFT, FORWARD, BACKWARD, RIGHT};
        MoveDirection[] moves2 = new MoveDirection[]{BACKWARD, BACKWARD, LEFT, BACKWARD, RIGHT, BACKWARD, LEFT, FORWARD, LEFT};
        Animal puszek_test1 = new Animal();
        Animal puszek_test2 = new Animal();

        World.run(moves1,puszek_test1);
        World.run(moves2,puszek_test2);

        assertTrue(puszek_test1.isAt(new Vector2d(4,3)));
        assertTrue(puszek_test2.isAt(new Vector2d(2,0)));
    }
    @Test
    void map_borders(){
        MoveDirection[] moves1 = new MoveDirection[]{RIGHT, FORWARD, FORWARD, FORWARD, RIGHT, BACKWARD, BACKWARD, BACKWARD, BACKWARD};
        MoveDirection[] moves2 = new MoveDirection[]{RIGHT, BACKWARD, BACKWARD, BACKWARD, RIGHT, FORWARD, FORWARD, FORWARD, LEFT, BACKWARD, FORWARD};
        Animal puszek_test1 = new Animal();
        Animal puszek_test2 = new Animal();

        World.run(moves1,puszek_test1);
        World.run(moves2,puszek_test2);

        assertTrue(puszek_test1.isAt(new Vector2d(4,4)));
        assertTrue(puszek_test2.isAt(new Vector2d(1,0)));
    }
    @Test
    void parser(){
        MoveDirection[] moves1_should_be = new MoveDirection[]{FORWARD, FORWARD, LEFT, LEFT, BACKWARD, BACKWARD, RIGHT};
        MoveDirection[] moves2_should_be = new MoveDirection[]{FORWARD, RIGHT, BACKWARD, LEFT};
        String[] dir1= new String[]{"f", "forward", "l", "left", "dfds", "backward", "b", "r", "fhfgh"};
        String[] dir2 = new String[]{"rad", "rq", "asdff", "forward", "asds", "right", "backward", "ldsa", "left"};

        MoveDirection[] moves1 = OptionsParser.parse(dir1);
        MoveDirection[] moves2 = OptionsParser.parse(dir2);

        assertTrue(Arrays.equals(moves1,moves1_should_be));
        assertTrue(Arrays.equals(moves2,moves2_should_be));
    }
}
