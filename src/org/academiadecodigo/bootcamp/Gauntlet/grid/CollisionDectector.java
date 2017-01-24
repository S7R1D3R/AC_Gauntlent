package org.academiadecodigo.bootcamp.Gauntlet.grid;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by codecadet on 24/01/17.
 */
public class CollisionDectector {

    private GameObject[] gameObjects;

    public CollisionDectector(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    public boolean isUnSafe(GridPosition pos) {

        for(GameObject gameObject: gameObjects) {

            if(gameObject.getPos() != pos && gameObject.getPos().equals(pos)) {
                return true;
            }

        }

        return false;
    }

    public void check(GameObject gameObject) {

        for(GameObject iGameObject: gameObjects) {

            if(iGameObject == gameObject) {
                continue;
            }


        }
    }

    public
}
