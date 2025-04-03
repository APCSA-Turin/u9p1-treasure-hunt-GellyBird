package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        grid = new Sprite[size][size];
        for (int i = 0; i < size ; i ++) {
            for (int j = 0; j < size; j ++) {
                grid[i][j] = new Dot(j,size - i-1);
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[getGrid().length - s.getY()-1][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        if (direction.equals("w")) {
                placeSprite(new Dot((s.getX()),(s.getY()-1)));
        } else if (direction.equals("s")) {
                placeSprite(new Dot((s.getX()),(s.getY()+1)));
        } else if (direction.equals("a")) {
                placeSprite(new Dot((s.getX()+1),(s.getY())));
        } else {
                placeSprite(new Dot((s.getX()-1),(s.getY())));
            }
        placeSprite(s);
    }


    public void display() { //print out the current grid to the screen 
        for (Sprite[] row : grid) {
            for (Sprite column : row) {
                if (column instanceof Dot) {
                    System.out.print("⬜");
                } else if (column instanceof Trophy) {
                    System.out.print("🏆");
                } else if (column instanceof Treasure) {
                    System.out.print("🪙");
                } else if (column instanceof Enemy) {
                    System.out.print("🐊");
                } else if (column instanceof Player) {
                    System.out.print("🦜");
                }
            }
            System.out.println(); 
        }
    }
    
    public void gameover(){ //use this method to display a loss
    }

    public void win(){ //use this method to display a win 
    }

}