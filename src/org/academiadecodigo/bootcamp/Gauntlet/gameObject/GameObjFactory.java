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

    public static GameObject getNewGameObj(Grid grid, GameObjType gameObjType, GridPosition position) {
        GameObject newGameObj;

        switch (gameObjType) {
            case ITEM:
                newGameObj = new Item(grid, position);
                break;
            case ENEMY:
                newGameObj = new Enemy(grid, position);
                break;
            case PLAYER:
                newGameObj = new Player(grid, position);
                break;
            case WALL:
                newGameObj = new Obstacle(grid, position);
                return null;
            case PROJECTILE:
                newGameObj = new Projectile(grid, position);
                break;
            default:
                newGameObj = null;
                System.out.println("GameObjFactory => Something went really bad...");
        }

        return newGameObj;
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
