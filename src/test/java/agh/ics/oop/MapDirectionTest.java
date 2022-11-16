package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    void MapDirNext(){
        MapDirection v1= MapDirection.NORTH;
        MapDirection v2= MapDirection.EAST;
        MapDirection v3= MapDirection.SOUTH;
        MapDirection v4= MapDirection.WEST;

        assertEquals(v1.next(),MapDirection.EAST);
        assertEquals(v2.next(),MapDirection.SOUTH);
        assertEquals(v3.next(),MapDirection.WEST);
        assertEquals(v4.next(),MapDirection.NORTH);
    }
}
