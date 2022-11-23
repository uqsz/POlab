package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {
    @Test
    void defaultTest() {
        String[] args= {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(2, 0)));
        assertTrue(map.isOccupied(new Vector2d(3, 5)));
    }
    @Test
    void borderTest() {
        String[] args= {"f", "b", "r", "l", "f", "f", "r", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f","f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f",};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(3, 6);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(0, 3)));
        assertTrue(map.isOccupied(new Vector2d(3, 6)));
    }

    @Test
    void readTest() {
        String[] args= {"rad", "rq", "asdff", "forward", "asds", "right", "backward", "ldsa", "left", "forward", "forward", "right", "left", "asd", "dsad", "asd", "dsa", "f", "l", "l", "left", "f", "right", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4),  new Vector2d(9,9) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(0, 3)));
        assertTrue(map.isOccupied(new Vector2d(4, 4)));
        assertTrue(map.isOccupied(new Vector2d(8, 10)));
    }
}
