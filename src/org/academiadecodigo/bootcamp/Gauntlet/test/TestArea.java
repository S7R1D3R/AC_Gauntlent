package org.academiadecodigo.bootcamp.Gauntlet.test;


import org.academiadecodigo.bootcamp.Gauntlet.Game;
import org.academiadecodigo.bootcamp.Gauntlet.LevelMaker;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;

import java.util.ArrayList;

/**
 * Created by codecadet on 1/21/17.
 */
public class TestArea {

    public static void main(String[] args) throws InterruptedException {

        int delay = 200;
        Game game = new Game(GridType.SIMPLE_GFX, 42, 18, delay);

        //Test grid initialization
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
    }

//        game.init(1);


//        try {
//            game.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    // Test loading image
//        Picture picture2 = new Picture(10, 10, "test/GameBackground.png");
//        picture2.draw();
//
//        Picture picture = new Picture(10, 10, "test/End.png");
//        picture.draw();
}

