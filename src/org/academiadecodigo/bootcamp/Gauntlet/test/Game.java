package org.academiadecodigo.bootcamp.Gauntlet.test;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;
import org.academiadecodigo.bootcamp.Gauntlet.LevelMaker;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Game {

    private Grid grid;
    private GridType gridType;
    private int delay;
    private GameObject[] gameObjects;
    private ActionDetector actionDetector;
    private LevelMaker levelMaker;
    private boolean gameOver;


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

        // Creates the level
        levelMaker = new LevelMaker(grid, level);
        levelMaker.chooseLevel(level);

        // Initializes (and draws) all objects.
        initializeGameObjects();

        // Creates ActionDetector
        this.actionDetector = new ActionDetector(this.gameObjects);


    }

    /**
     * starts the animation
     * @throws InterruptedException
     */
    public void start() throws InterruptedException{

        while (!gameOver) {

            // Pause for a while
            Thread.sleep(delay);

            moveMovableObjects();
        }
    }

    /**
     * Move all movable objects
     */
    private void moveMovableObjects() {

        for (Movable movableObject : actionDetector.getMovableObjects()) {

            movableObject.move();

        }

    }


    public static void endGame() {
        // TODO: (GIULIANO): We are using a boolean isGameFinished so this function should some how modify it. What should we put inside this function? Princess? Life? Should we return the boolean or should this method change a boolean property?

    }

    private void initializeGameObjects() {

        GridPosition[] objectInitPositions = levelMaker.getObjectInitPositions();
        GameObjType[] objectTypes = levelMaker.getObjectTypes();
        this.gameObjects = new GameObject[objectTypes.length];


        for (int i = 0; i < objectInitPositions.length; i++) {

            GameObjType objType = objectTypes[i];

            this.gameObjects[i] =
                    GameObjFactory.getNewGameObj(grid,
                            objType, objectInitPositions[i]);


        }
    }


}
