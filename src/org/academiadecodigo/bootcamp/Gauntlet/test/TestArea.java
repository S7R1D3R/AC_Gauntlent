package org.academiadecodigo.bootcamp.Gauntlet.test;


import org.academiadecodigo.bootcamp.Gauntlet.logicEngine.Game;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;

/**
 * Created by codecadet on 1/21/17.
 */
public class TestArea {

    public static void main(String[] args) throws InterruptedException {

        int delay = 200;
        Game game = new Game(GridType.SIMPLE_GFX, 42, 18, delay);

       game.init(1);


        try {
            game.start();
        } catch (InterruptedException e) {
            e.printStackTrace();


       /* //Test grid initialization
        Grid grid = GameObjFactory.makeGrid(GridType.SIMPLE_GFX, 42, 18);
        grid.init();
        LevelMaker levelMaker = new LevelMaker(grid);          //Instances the level maker
        ArrayList<GameObject> gameObjects = levelMaker.getLevel(1);   //Creates the ArrayList with all the gameobjects using the level maker
        System.out.println(gameObjects.toString());

        Player player = null;
        //Selecting player to make Player-specific tests
        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Player) {

                player = (Player) gameObject;
                break;
            }
        }*/


        /**
         * ENEMIES MOVEMENT TEST A BRUTA :)
         */
        /*for (int i = 0; i < 20; i++) {


            for (GameObject enemy : gameObjects) {

                if (enemy instanceof Enemy) {

                    System.out.println("Enemy direction is :" + ((Enemy) enemy).getDirection());
                    ((Enemy) enemy).setDirectionTowardsPlayer(player);
                    System.out.println("Enemy direction is now: "  + ((Enemy) enemy).getDirection());
                    System.out.println("enemy pos is: " + enemy.getPos().toString());
                    ((Enemy) enemy).move();
                    System.out.println("enemy NEW pos is: " + enemy.getPos().toString());
                    Thread.sleep(delay);
                }
            }
        }
    }
        //Testing moveInDirection() from simpleGFXGridPosition
        System.out.println("Grid rows (should be 18): " + grid.getRows() + " and cols (should be 32):" + grid.getCols());
        System.out.println("Player initial position (should be C=1,R=16): " + player.getPos());

        move(player, GridDirection.DOWN, delay);
        move(player, GridDirection.DOWN, delay);
        move(player, GridDirection.UP, delay);
        move(player, GridDirection.UP, delay);
        move(player, GridDirection.RIGHT, delay);
        move(player, GridDirection.RIGHT, delay);
        move(player, GridDirection.LEFT, delay);
        for (int i = 0; i < 8; i++) {
            move(player, GridDirection.UP, delay);

        }
        move(player, GridDirection.RIGHT, delay);
        for (int i = 0; i < 4; i++) {
            move(player, GridDirection.UP, delay);

        }
        for (int i = 0; i < 10; i++) {
            move(player, GridDirection.RIGHT, delay);

        }
        for (int i = 0; i < 3; i++) {
            move(player, GridDirection.UP, delay);

        }
        for (int i = 0; i < 7; i++) {
            move(player, GridDirection.DOWN, delay);

        }
        for (int i = 0; i < 19; i++) {
            move(player, GridDirection.RIGHT, delay);

        }
    }

    private static void move(Player player, GridDirection direction, int delay) throws InterruptedException {
        switch (direction) {
            case DOWN:
                player.getPos().moveInDirection(GridDirection.DOWN);
                break;
            case UP:
                player.getPos().moveInDirection(GridDirection.UP);
                break;
            case RIGHT:
                player.getPos().moveInDirection(GridDirection.RIGHT);
                break;
            case LEFT:
                player.getPos().moveInDirection(GridDirection.LEFT);
                break;
        }
        System.out.println("Attempting to move " + direction + " . Current pos: " + player.getPos());
        Thread.sleep(delay);
    }*/

     }


    // Test loading image
//        Picture picture2 = new Picture(10, 10, "test/GameBackground.png");
//        picture2.draw();
//
//        Picture picture = new Picture(10, 10, "test/End.png");
//        picture.draw();
}}

