package org.academiadecodigo.bootcamp.Gauntlet.grid;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by codecadet on 24/01/17.
 */
public class CollisionDectector {

    private Movable[] movables;

    public CollisionDectector(Movable[] movables) {
        this.movables = movables;
    }

    public boolean isUnSafe(GridPosition pos) {

        for(Movable movable: movables) {

            if(movable.getPos() != pos && movable.getPos().equals(pos)) {
                return true;
            }

        }

        return false;
    }


    public static GameObjType getGameObjType(GameObject gameObject) {

        GameObjType gameObjType;

        switch (gameObject.getGameObjType()) {
            case ITEM:
                gameObjType = GameObjType.ITEM;
                break;
            case ENEMY:
                gameObjType = GameObjType.ENEMY;
                break;
            case PLAYER:
                gameObjType = GameObjType.PLAYER;
                break;
            case OBSTACLE:
                gameObjType = GameObjType.OBSTACLE;
                break;
            case PROJECTILE:
                gameObjType = GameObjType.PROJECTILE;
                break;
            default:
                System.out.println("Something went terribly wrong... FILE => Game.java ");
                return null;
        }

        return gameObjType;
    }
}
