package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2dTest {
    @Test
    void VectorEquals() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(2, 1);

        assertEquals(v1.equals(v2), true);
        assertEquals(v2.equals(v3), false);
    }

    @Test
    void VectorToString() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(v1.toString(), "(1,2)");
        assertEquals(v2.toString(), "(-3,2)");
        assertEquals(v3.toString(), "(-2,-1)");

    }

    @Test
    void VectorPrecedes(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(v1.precedes(v2),false);
        assertEquals(v2.precedes(v3),false);
        assertEquals(v3.precedes(v1),true);
    }

    @Test
    void VectorFollows(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(v1.follows(v3),true);
        assertEquals(v3.follows(v2),false);
        assertEquals(v2.follows(v2),true);
    }

    @Test
    void VectorUpperRight(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(v1.upperRight(v2),new Vector2d(1,2));
        assertEquals(v2.upperRight(v3),new Vector2d(-2,2));
        assertEquals(v3.upperRight(v1),new Vector2d(1,2));
    }

    @Test
    void VectorLowerLeft(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(v1.lowerLeft(v2),new Vector2d(-3,2));
        assertEquals(v2.lowerLeft(v3),new Vector2d(-3,-1));
        assertEquals(v3.lowerLeft(v1),new Vector2d(-2,-1));
    }

    @Test
    void VectorAdd(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(v1.add(v2),new Vector2d(-2,4));
        assertEquals(v2.add(v3),new Vector2d(-5,1));
        assertEquals(v2.add(v2),new Vector2d(-6,4));
    }

    @Test
    void VectorSubstruct(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, -1);

        assertEquals(v1.subtract(v2),new Vector2d(4,0));
        assertEquals(v2.subtract(v3),new Vector2d(-1,3));
        assertEquals(v3.subtract(v1),new Vector2d(-3,-3));
    }

    @Test
    void VectorOpposite(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, 2);
        Vector2d v3 = new Vector2d(-2, 0);

        assertEquals(v1.opposite(),new Vector2d(-1,-2));
        assertEquals(v2.opposite(),new Vector2d(3,-2));
        assertEquals(v3.opposite(),new Vector2d(2,0));

    }
}