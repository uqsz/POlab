package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void objectAt() {
        GrassField map = new GrassField(0);
        Vector2d animalPosition = new Vector2d(1, 3);
        Vector2d grassPosition = new Vector2d(4, 6);
        Vector2d emptyPosition = new Vector2d(2, 6);
        Animal animal = new Animal(map, animalPosition);
        Animal animalOnGrass = new Animal(map, grassPosition);
        map.addGrass(grassPosition);
        map.place(animal);

        assertNull(map.objectAt(emptyPosition));
        assertTrue(map.objectAt(grassPosition)  instanceof Grass);
        assertTrue(map.objectAt(animalPosition) instanceof Animal);

        map.place(animalOnGrass);
        assertTrue(map.objectAt(grassPosition) instanceof Animal);
    }

    @Test
    void canMoveTo() {
        GrassField map = new GrassField(0);
        Vector2d animalPosition = new Vector2d(1, 3);
        Vector2d grassPosition = new Vector2d(4, 6);
        Vector2d emptyPosition = new Vector2d(2, 6);
        Animal animal = new Animal(map, animalPosition);
        map.addGrass(grassPosition);
        map.place(animal);

        assertFalse(map.canMoveTo(animalPosition));
        assertTrue(map.canMoveTo(grassPosition));
        assertTrue(map.canMoveTo(emptyPosition));
    }

    @Test
    void isOccupied() {
        GrassField map = new GrassField(0);
        Vector2d animalPosition = new Vector2d(1, 3);
        Vector2d grassPosition = new Vector2d(4, 6);
        Vector2d emptyPosition = new Vector2d(2, 6);
        Animal animal = new Animal(map, animalPosition);
        map.addGrass(grassPosition);
        map.place(animal);

        assertTrue(map.isOccupied(animalPosition));
        assertTrue(map.isOccupied(grassPosition));
        assertFalse(map.isOccupied(emptyPosition));
    }
    @Test
    void moved() {
        GrassField map = new GrassField(1);
        Vector2d grassPosition = new Vector2d(4, 3);
        map.addGrass(grassPosition);

        assertTrue(map.objectAt(grassPosition) instanceof Grass);
        map.moved(grassPosition);
        assertNull(map.objectAt(grassPosition));
    }

}