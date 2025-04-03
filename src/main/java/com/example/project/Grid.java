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


    /* Places the sprite at it's specific coordinates as they corospond on the grid
     * For example, if the coordinates of a sprite were (3,0) it would be placed at [length - 3 - 1][0]
     */
    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[getGrid().length - s.getY()-1][s.getX()] = s;
    }

    /* Places the sprite based on it's given direction.
     * If the object it is moving towards is a trophy and the player does NOT have all of the treasures
     * then it will be forced to move in the opposite direction and back to it's original index.
     * Works by checking the direction the sprite is moving in and then replaces the index behind it with a new dot.
     * i.e, if it was moving in the "w" direction (up) it would replace the sprite in the "s" direction (down)
     * or, in simpler terms, it replaces the the index at the sprite's previous location.
     */
    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
    if (!(grid[getGrid().length - s.getY()-1][s.getX()] instanceof Trophy)) {
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
    } else {
        if (direction.equals("w")) {
            s.move("s");
    } else if (direction.equals("s")) {
            s.move("w");
    } else if (direction.equals("a")) {
            s.move("d");
    } else {
            s.move("a");
    }
        System.out.println("You still have treasures to collect!");
    }
    }

/* Loops through every index in the grid and checks what type of object it contains
 * Then, it prints an emoji corresponding to it's type.
 */
    public void display() { //print out the current grid to the screen 
        for (Sprite[] row : grid) {
            for (Sprite column : row) {
                if (column instanceof Dot) {
                    System.out.print("⬜");
                } else if (column instanceof Trophy) {
                    System.out.print("🏆");
                } else if (column instanceof Treasure) {
                    System.out.print("💰");
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
        for (Sprite[] row : grid) {
            for (Sprite column : row) {
                System.out.print("💀");
            }
            System.out.println(); 
        }
        System.out.println("YOU LOSE!");
    }

    public void win(){ //use this method to display a win 
        for (Sprite[] row : grid) {
            for (Sprite column : row) {
                System.out.print("✨");
            }
            System.out.println(); 
        }
        System.out.println("YOU WIN!");
    }
}
