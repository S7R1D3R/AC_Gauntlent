package org.academiadecodigo.bootcamp.Gauntlet.gameObject;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Obstacle;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Enemy;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Projectile;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.simplegfx.SimpleGfxGrid;

/**
 * Created by codecadet on 21/01/17.
 */
public class GameObjFactory {
    // TODO: Should we try to implement the factory of factories as in the Pong skeleton?

    public static GameObject getNewGameObj(Grid grid, GameObjType gameObjType) {

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
            case OBSTACLE:
                newGameObj = new Obstacle();
                break;
            case PROJECTILE:
                newGameObj = new Projectile();
                break;
            default:
                newGameObj = null;
                System.out.println("GameObjFactory => Something went really bad...");
        }

        return newGameObj;
    }

    // TODO: Should we leave the creation of the grid in here or create a dedicated factory?
    public static Grid makeGrid(int cols, int rows) {
        return new SimpleGfxGrid(cols, rows);
    }
}
