package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;
        initialize(size);
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);

        while(true){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop

            if (player.getWin() == true) {
                grid.win();
            } else if (player.getLives() <= 0) {
                grid.gameover();
            }
            grid.display();
            System.out.println(player.getCoords());
            System.out.println(player.getRowCol(size));
            System.out.println("Treasure Collected: " + player.getTreasureCount());
            System.out.println("Lives Remaining: " + player.getLives());
            System.out.println("Enter a direction (w,a,s,d) or 'q' to exit:");
            String option = scanner.nextLine();

            if (option.equals("q")) {
                break;
            }

            if (player.isValid(size, option)) {      
                player.move(option);            
                Object obj = grid.getGrid()[size - player.getY() - 1][player.getX()];
                player.interact(size,option,treasures.length,obj);
                grid.placeSprite(player,option);
            }
             else {
                System.out.println("Invalid direction!");
            }

        }
     
    }

    public void initialize(int size){
        grid = new Grid(size);
        player = new Player(0, 0);
        enemies = new Enemy[2];
        enemies[0] = new Enemy(5, 5);
        enemies[1] = new Enemy(7,8);
        treasures = new Treasure[2];
        treasures[0] = new Treasure(2, 2);
        treasures[1] = new Treasure(1,7);
        trophy = new Trophy(9, 9);

        grid.placeSprite(player);
        grid.placeSprite(enemies[0]);
        grid.placeSprite(enemies[1]);
        grid.placeSprite(treasures[0]);
        grid.placeSprite(treasures[1]);
        grid.placeSprite(trophy);
        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
   
    }

    public static void main(String[] args) {
        Game newGame = new Game(10);
        // // Row 0: [ ][ ][ ][ ][ ][ ][ ][ ][ ][W]
        // // Row 1: [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
        // // Row 2: [ ][T][ ][ ][ ][ ][ ][E][ ][ ]
        // // Row 3: [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
        // // Row 4: [ ][ ][ ][ ][ ][E][ ][ ][ ][ ]
        // // Row 5: [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
        // // Row 6: [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
        // // Row 7: [ ][ ][T][ ][ ][ ][ ][ ][ ][ ]
        // // Row 8: [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
        // // Row 9: [P][ ][ ][ ][ ][ ][ ][ ][ ][ ]
        // //         0  1  2  3  4  5  6  7  8  9

        // // Place objects on the grid
        // grid.placeSprite(player);
        // // grid.placeSprite(enemy);
        // // grid.placeSprite(enemy2);
        // // grid.placeSprite(treasure);
        // // grid.placeSprite(treasure2);
        // // grid.placeSprite(trophy); 
    }
}