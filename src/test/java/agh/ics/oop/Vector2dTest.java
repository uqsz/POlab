package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void VectorEquals() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(2, 1);

        assertEquals(v1, v2);
        assertNotEquals(v2, v3);
        assertNotEquals(v1, v3);
    }

    @Test
    void VectorToString() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals("(1,2)",v1.toString());
        assertEquals("(-3,2)",v2.toString());
        assertEquals("(-2,-1)",v3.toString());

    }

    @Test
    void VectorPrecedes(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertFalse(v1.precedes(v2));
        assertFalse(v2.precedes(v3));
        assertTrue(v3.precedes(v1));
    }

    @Test
    void VectorFollows(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertTrue(v1.follows(v3));
        assertFalse(v3.follows(v2));
        assertTrue(v2.follows(v2));
    }

    @Test
    void VectorUpperRight(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(new Vector2d(1,2), v1.upperRight(v2));
        assertEquals(new Vector2d(-2,2), v2.upperRight(v3));
        assertEquals(new Vector2d(1,2), v3.upperRight(v1));
    }

    @Test
    void VectorLowerLeft(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(new Vector2d(-3,2), v1.lowerLeft(v2));
        assertEquals(new Vector2d(-3,-1), v2.lowerLeft(v3));
        assertEquals(new Vector2d(-2,-1), v3.lowerLeft(v1));
    }

    @Test
    void VectorAdd(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(new Vector2d(-2,4), v1.add(v2));
        assertEquals(new Vector2d(-5,1), v2.add(v3));
        assertEquals(new Vector2d(-6,4), v2.add(v2));
    }

    @Test
    void VectorSubstruct(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(new Vector2d(4,0), v1.subtract(v2));
        assertEquals(new Vector2d(-1,3), v2.subtract(v3));
        assertEquals(new Vector2d(-3,-3), v3.subtract(v1));
    }

    @Test
    void VectorOpposite(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, 0);

        assertEquals(new Vector2d(-1,-2), v1.opposite());
        assertEquals(new Vector2d(3,-2), v2.opposite());
        assertEquals(new Vector2d(2,0), v3.opposite());
    }
}