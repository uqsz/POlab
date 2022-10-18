package agh.ics.oop;

import static java.lang.Math.*;

public class Vector2d {
    public int x;
    public int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public boolean precedes(Vector2d other){
        if (this.x <= other.x && this.y <= other.y)
            return true;
        else return false;
    }
    public boolean follows(Vector2d other){
        if (this.x >= other.x && this.y >= other.y)
            return true;
        else return false;
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(this.x+other.x,this.y+other.y);
    }
    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x-other.x,this.y-other.y);
    }
    public Vector2d upperRight(Vector2d other){
        return new Vector2d(max(this.x,other.x), max(this.y,other.y));
    }
    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(min(this.x,other.x), min(this.y,other.y));
    }
    public Vector2d opposite(){
        return new Vector2d(negateExact(this.x),negateExact(this.y));
    }
    public boolean equals(Vector2d other){
        if (this.x == other.x && this.y == other.y)
            return true;
        else return false;
    }

}
