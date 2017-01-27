package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.AbstractMovableObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

import java.util.ArrayList;

/**
 * Created by codecadet on 25/01/17.
 */
public class ActionDetector {

    ArrayList<GameObject> gameObjects;
    ArrayList<AbstractMovableObject> movableObjects;

    public ActionDetector(ArrayList<GameObject> gameObjects) {
        
        this.gameObjects = gameObjects;

        for (int i = 0; i < gameObjects.size(); i++) {
            if(gameObjects.get(i) instanceof AbstractMovableObject) {
                movableObjects.add((AbstractMovableObject)gameObjects.get(i));
            }
        }
    }

    private GridPosition getNextPos(AbstractMovableObject movable) {

        GridPosition nextPos;

        switch(movable.getDirection()) {

            case UP:
                nextPos = movable.getGrid().makeGridPosition(movable.getPos().getCol(), movable.getPos().getRow() - 1);
                break;
            case RIGHT:
                nextPos = movable.getGrid().makeGridPosition(movable.getPos().getCol() + 1, movable.getPos().getRow());
                break;
            case DOWN:
                nextPos = movable.getGrid().makeGridPosition(movable.getPos().getCol(), movable.getPos().getRow() + 1);
                break;
            case LEFT:
                nextPos = movable.getGrid().makeGridPosition(movable.getPos().getCol() - 1, movable.getPos().getRow());
                break;
            default:
                nextPos = movable.getPos();
                System.out.println("Something went terribly wrong... <= ACTION DETECTOR");
        }

        return nextPos;
    }

    public GameObject checkObjectNextPos(AbstractMovableObject movable) {

        GameObject gameObjectInNextPos = null;

        for(GameObject gameObject: gameObjects) {

            if(getNextPos(movable).equals(gameObject.getPos())) {
                gameObjectInNextPos = gameObject;
            }

        }

        return gameObjectInNextPos;
    }

    public ArrayList<AbstractMovableObject> getMovableObjects() {
        return movableObjects;
    }

    //TODO: Peter and Vero think that this action detector should choose the action of the respective movable object
    //TODO: And method checkAction should be named chooseAction and be called by each movable object
}
