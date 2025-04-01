package com.example.project;

public class Sprite {
    private int x, y;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    public void setX(int newX){
        x = newX;
    }
    public void setY(int newY){
        y = newY;
    }

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "("+x+","+y+")";
    }

    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        return "["+CoordToIndexY(y,size)+"]" + "["+CoordToIndexX(x,size)+"]";
    }
    

    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    // Methods I Added For Simplicity :)
    public static int IndexToCoordY(int index, int size) { // Translates the Y index to a Y coordinate. I.e. [9][x] becomes (x,0)
        int coord = (size - index - 1);
        return coord;
    }

    public static int CoordToIndexY(int coord,int size) { // Coordinated val to index Y
        return (size - coord - 1);
    }

    public static int CoordToIndexX(int coord,int size) { // Coordinated val to index X
        return (0 + coord);
    }

}
