package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void objectAt() {
        Vector2d emptyPosition = new Vector2d(1, 2);
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d animalPosition = new Vector2d(5, 6);
        Animal animal = new Animal(map, animalPosition);
        map.place(animal);

        assertNull(map.objectAt(emptyPosition));
        assertTrue(map.objectAt(animalPosition) instanceof Animal);
    }

    @Test
    void canMoveToTest() {
        Vector2d emptyPosition = new Vector2d(1, 2);
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d animalPosition = new Vector2d(5, 6);
        Animal animal = new Animal(map, animalPosition);
        map.place(animal);

        assertFalse(map.canMoveTo(animalPosition));
        assertTrue(map.canMoveTo(emptyPosition));
    }

    @Test
    void isOccupiedTest() {
        Vector2d emptyPosition = new Vector2d(1, 2);
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d animalPosition = new Vector2d(5, 6);
        Animal animal = new Animal(map, animalPosition);
        map.place(animal);

        assertTrue(map.isOccupied(animalPosition));
        assertFalse(map.isOccupied(emptyPosition));
    }
}