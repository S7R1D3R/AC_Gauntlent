package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.AbstractMovableObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;
import org.academiadecodigo.bootcamp.Gauntlet.simplegfx.KeyboardInput;

import java.util.ArrayList;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Game {

    private Grid grid;
    private GridType gridType;
    private int delay;
    private ActionDetector actionDetector;
    private LevelMaker levelMaker;
    private boolean gameOver;
    private Player player;

    // KEYBOARD EVENT
    private KeyboardInput keyboardInput;


    /**
     * Constructs a new game
     */
    public Game(GridType gridType, int cols, int rows, int delay) {

        this.grid = GameObjFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;
        this.gridType = gridType;
    }


    /**
     * Create game objects in defined positions by the levelMaker
     */

    public void init(int level) {

        // Initializes the grid.
        grid.init();

        // Initializes all objects on action detector and draws them
        actionDetector = new ActionDetector(initializeGameObjects(level));


        // Sets action detector on Movable objects
        for (AbstractMovableObject movableObject : actionDetector.getMovableObjects()) {
            movableObject.setActionDetector(actionDetector);

            //Save Player as Game property to access gameOver status
            if (movableObject.getGameObjType() == GameObjType.PLAYER) {
                player = ((Player) movableObject);
            }
        }

        if (gridType == GridType.SIMPLE_GFX) {
            this.keyboardInput = new KeyboardInput(player);
            player.setKeyboard(keyboardInput);
        }

    }

    /**
     * starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (!gameOver) {

            // Pause for a while
            Thread.sleep(delay);

            // Commands objects to perform actions
            moveAllMovable();

        }
    }


    /**
     * Commands objects to perform actions
     */
    private void moveAllMovable() {

        for (AbstractMovableObject iMovableObject : actionDetector.getMovableObjects()) {


            actionDetector.setDirectionAndSpeed(iMovableObject);
            iMovableObject.move();
            actionDetector.checkCollisions(iMovableObject);
        }

        //Check if player reached exit point with princess:
        if (player.hasFinished()) {
            gameOver = true;
        }
    }





    /**
     * Instances the Level Maker and the ArrayList with all the GameObjects
     *
     * @param level
     */

    public ArrayList<GameObject> initializeGameObjects(int level) {

        levelMaker = new LevelMaker(grid);          //Instances the level maker
        return levelMaker.getLevel(level);   //Creates the ArrayList with all the gameobjects using the level maker
    }

    public Player getPlayer() {
        return player;
    }

}



