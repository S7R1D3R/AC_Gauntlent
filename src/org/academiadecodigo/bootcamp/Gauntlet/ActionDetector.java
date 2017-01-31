package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.*;

import java.util.ArrayList;

/**
 * Created by codecadet on 25/01/17.
 */
public class ActionDetector {

    private ArrayList<GameObject> gameObjects;
    private ArrayList<AbstractMovableObject> movableObjects = new ArrayList<>();
    private Player player;  //TODO WOULD BE NICE TO UPDATE EVERY TIME PLAYER MOVES

    public ActionDetector(ArrayList<GameObject> gameObjects) {

        this.gameObjects = gameObjects;

        for (GameObject iGameObject : gameObjects) {
            if (iGameObject instanceof AbstractMovableObject) {
                movableObjects.add((AbstractMovableObject) iGameObject);
            }

            if (iGameObject instanceof Player) {
                player = ((Player) iGameObject);
            }
        }
    }


    public ArrayList<AbstractMovableObject> getMovableObjects() {
        return movableObjects;
    }


    public void setDirectionAndSpeed(AbstractMovableObject iMovableObject) {

        switch (iMovableObject.getGameObjType()) {
            case ENEMY:
                ((Enemy) iMovableObject).setDirectionTowardsPlayer(player);
                 iMovableObject.setNextPos();
                 iMovableObject.checkObjInNextPosAndSetSpeed(gameObjects);
                break;
            case PLAYER:
                //TODO player.setNextPos() has to be called by keyboard event
                iMovableObject.checkObjInNextPosAndSetSpeed(gameObjects);
                break;
        }
    }

    public void checkCollisions(AbstractMovableObject movableObject) {

        ArrayList<GameObject> destroyedThisTurn = new ArrayList<>();

        for (GameObject iGameObject : gameObjects) {
            if (movableObject != iGameObject && movableObject.getPos().equals(iGameObject.getPos())) {

                switch (iGameObject.getGameObjType()) {
                    case WALL:
                        if (checkCollisionsWithWall(movableObject)){
                            destroyedThisTurn.add(movableObject);
                        }
                        break;
                    case PLAYER:
                        if (checkCollisionsWithPlayer(movableObject, iGameObject)){
                            destroyedThisTurn.add(movableObject);
                            return;
                        }

                    case ENEMY:
                        if (checkCollisionsWithEnemy(movableObject, iGameObject)){
                            if(movableObject instanceof Projectile){
                                destroyedThisTurn.add(movableObject);
                            }
                            destroyedThisTurn.add(iGameObject);
                            return;
                        }
                    case PROJECTILE:
                        if (checkCollisionsWithProjectile(movableObject, iGameObject)){
                            destroyedThisTurn.add(movableObject);
                            destroyedThisTurn.add(iGameObject);
                            return;
                        }
                        break;
                    case ITEM:
                        if (checkCollisionsWithItem(movableObject, iGameObject)){
                            destroyedThisTurn.add(iGameObject);
                            return;
                        }
                }
            }
        }
        movableObjects.removeAll(destroyedThisTurn);
        gameObjects.removeAll(destroyedThisTurn);
    }

    private boolean checkCollisionsWithWall(AbstractMovableObject movableObject) {
        if (movableObject instanceof Projectile) {
            movableObject.destroy();
            return true;
        }
        System.err.println("no movable besides projectile should collide with wall!");
        return false;
    }

    private boolean checkCollisionsWithPlayer(AbstractMovableObject movableObject, GameObject iGameObject) {
        //TODO SYNC WITH MULTIPLAYER WHEN FEATURE IS ADDED
        if (movableObject instanceof Enemy) {
            ((Player)iGameObject).decreaseHealth(((Enemy) movableObject).getDamage());
            movableObject.destroy();
            return true;
        }
        System.err.println("only enemies can collide with players");
        return false;
    }

    private boolean checkCollisionsWithEnemy(AbstractMovableObject movableObject, GameObject iGameObject) {
        if (movableObject instanceof Player) {
            ((Player) movableObject).decreaseHealth(((Enemy) iGameObject).getDamage());
            iGameObject.destroy();
            return true;
        }
        if (movableObject instanceof Projectile) {
            iGameObject.destroy();
            movableObject.destroy();
            return true;
        }
        System.err.println("only projectiles or players can collide with enemies");
        return false;
    }

    private boolean checkCollisionsWithProjectile(AbstractMovableObject movableObject, GameObject iGameObject) {
        if (movableObject instanceof Enemy) {
            movableObject.destroy();
            iGameObject.destroy();
            return true;
        }
        System.err.println("only enemies can collide with projectiles");
        return false;
    }

    private boolean checkCollisionsWithItem(AbstractMovableObject movableObject, GameObject iGameObject) {
        if (movableObject instanceof Player) {
            ((Player) movableObject).collectItem((Item) iGameObject);
            iGameObject.destroy();
            return true;
        }
        System.err.println("only players can collide with items");
        return false;
    }




}

