package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        grid = new Sprite[size][size];
        for (int i = 0; i < size ; i ++) {
            for (int j = 0; j < size; j ++) {
                grid[i][j] = new Dot(j,Sprite.IndexToCoordY(i,size));
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[Sprite.CoordToIndexY(s.getY(), size)][Sprite.CoordToIndexX(s.getX(), size)] = s;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        grid[Sprite.CoordToIndexY(s.getY(), size)][Sprite.CoordToIndexX(s.getX(), size)] = new Dot(Sprite.CoordToIndexX(s.getX(), size),Sprite.CoordToIndexY(s.getY(), size));
        s.move(direction);
        grid[Sprite.CoordToIndexY(s.getY(), size)][Sprite.CoordToIndexX(s.getX(), size)] = s;
    }


    public void display() { //print out the current grid to the screen 
    }
    
    public void gameover(){ //use this method to display a loss
    }

    public void win(){ //use this method to display a win 
    }

}