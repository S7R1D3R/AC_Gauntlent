package org.academiadecodigo.bootcamp.Gauntlet.gameObject;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Obstacle;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Enemy;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Projectile;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.bootcamp.Gauntlet.simplegfx.SimpleGfxGrid;

/**
 * Created by codecadet on 21/01/17.
 */
public class GameObjFactory {
    // TODO: Should we try to implement the factory of factories as in the Pong skeleton?

    public static GameObject getNewGameObj(Grid grid, GameObjType gameObjType, GridPosition[] wallPositions) {
        //TODO: Giuliano. Include grid and wallPositions in the constructor of all game objects.
        GameObject newGameObj;

        switch (gameObjType) {
            case ITEM:
                newGameObj = new Item();
                break;
            case ENEMY:
                newGameObj = new Enemy();
                break;
            case PLAYER:
                newGameObj = new Player();
                break;
            case OBSTACLE: // Since everything needs obstacles in the constructor, this object should be created first using a dedicated method
                System.out.println("Call the method makeObstacles to create new obstacles");
                return null;
            case PROJECTILE:
                newGameObj = new Projectile();
                break;
            default:
                newGameObj = null;
                System.out.println("GameObjFactory => Something went really bad...");
        }

        return newGameObj;
    }

    /**
     * Make new Obstacles
     */
    public static Obstacle makeObstacles(Grid grid) {
        return new Obstacle();
    }

    /**
     *
     * @param gridType
     * @param cols
     * @param rows
     * @return
     */

    // TODO: For now we leave the creation of the Grid inside the GameObjFactory, since we are not considering other implementations
    public static Grid makeGrid(GridType gridType, int cols, int rows) {
        switch (gridType) {
            case SIMPLE_GFX:
                return new SimpleGfxGrid(cols, rows);
            default:
                return null; //TODO: For now, since we are not considering other implementation
        }
    }
}
