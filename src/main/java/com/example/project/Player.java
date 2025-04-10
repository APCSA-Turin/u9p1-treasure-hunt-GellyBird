package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite  {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0;
        numLives = 2;
    }


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  // Just updates the x or y value of the player depending on what direction they input
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
            if (direction.equals("w")) {
                setY(getY() + 1);
              }  else if (direction.equals("a")) {
                setX(getX() - 1);
              } else if (direction.equals("s")) {
                setY(getY() - 1);
              } else {
                setX(getX() + 1);
              }
    }


    /* Checks what type of object obj is and then updates the player object accordingly.
     * For example, if it was an enemy, then the player would lose a life.
     */
    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
        if (obj instanceof Enemy) {
            numLives -= 1;
        } else if (obj instanceof Treasure && !(obj instanceof Trophy)) {
                treasureCount ++;
        } else if (obj instanceof Trophy) {
            if (treasureCount >= numTreasures) {
                win = true;
            } else {
                win = false;
            }
        }
    }

//check grid boundaries and if the input direction would be moving past them.
    public boolean isValid(int size, String direction){
        if (direction.equals("w")) {
            if (getY() + 1 == size) {
                return false;
            } else {
                return true;
            }
          }  else if (direction.equals("a")) {
            if (getX() - 1 < 0) {
                return false;
            } else {
                return true;
            }
          } else if (direction.equals("s")) {
            if (getY() - 1 < 0) {
                return false;
            } else {
                return true;
            }
          } else {
            if (getX() + 1 == size) {
                return false;
            } else {
                return true;
            }
          }
    }

    public String getRowCol(int size) {
        return "Player:" + super.getRowCol(size);
    }

    public String getCoords() {
        return "Player:" + super.getCoords();
    }
   
}



