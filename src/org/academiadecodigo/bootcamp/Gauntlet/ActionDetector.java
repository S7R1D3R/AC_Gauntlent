package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.AbstractMovableObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by codecadet on 25/01/17.
 */
public class ActionDetector {

    ArrayList<GameObject> gameObjects;
    ArrayList<AbstractMovableObject> movableObjects = new ArrayList<>();
    GridPosition playerPos;  //TODO WOULD BE NICE TO UPDATE EVERY TIME PLAYER MOVES

    public ActionDetector(ArrayList<GameObject> gameObjects) {

        this.gameObjects = gameObjects;

        for (int i = 0; i < gameObjects.size(); i++) {
            if (gameObjects.get(i) instanceof AbstractMovableObject) {
                movableObjects.add((AbstractMovableObject) gameObjects.get(i));
            }
            // * NEW * INSTANCES ACTION DETECTOR KNOWLEDGE ABOUT PLAYER POS
            if (gameObjects.get(i) instanceof Player) {
                playerPos = gameObjects.get(i).getPos();
            }
        }
    }


    //também acho que o getNextPos se pode pedir directamente ao movable object (criando um movable.getNextPos() em vez
    //de estar no action detector


    public GameObject checkObjectInNextPos(AbstractMovableObject absMovObj) {
        //** CORRECTED **
        for (GameObject gameObject : gameObjects) {

            if (absMovObj.getNextPos().equals(gameObject.getPos())) {
                return gameObject;
            }
        }
        return null;
    }

    public GameObject checkObjectInSamePos(AbstractMovableObject absMovObj) {
        //** CORRECTED **
        for (GameObject iGameObject : gameObjects) {

            if (absMovObj != iGameObject && absMovObj.getPos().equals(iGameObject.getPos())) {
                return iGameObject;
            }
        }
        return null;
    }


    public ArrayList<AbstractMovableObject> getMovableObjects() {
        return movableObjects;
    }

    public GridPosition getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(GridPosition pos) {
        playerPos = pos;
    }


    public void removeMovableObject(AbstractMovableObject movableObject) {
        Iterator<AbstractMovableObject> it = movableObjects.iterator();
       while(it.hasNext()){
           if(it.next().equals(movableObject)){
               it.remove();
           }

        }

    }
}
