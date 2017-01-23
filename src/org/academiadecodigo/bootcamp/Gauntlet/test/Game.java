package org.academiadecodigo.bootcamp.Gauntlet.test;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Obstacle;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Game {

    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Type of graphical grid
     */
    private GridType gridType;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * Player
     */
    private Player player;

    /**
     * Obstacles
     */
    private Obstacle obstacle; //TODO: rename walls?

    /**
     * Constructs a new game
     */
    public Game(GridType gridType, int cols, int rows, int delay) {

        grid = GameObjFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;
        this.gridType = gridType;
    }

    public static void endGame() {

    }

    /**
     * Create game objects and add a grid
     */
    //TODO: Incomplete
    public void init() {

        grid.init();

        // First object to be created are the walls, then create all other characters using that info in the constructor
        obstacle = GameObjFactory.makeObstacles(grid);

        player = (Player) GameObjFactory.getNewGameObj(grid, GameObjType.PLAYER, obstacle.getWallsPositions); //TODO: Fix name of

    }


}
