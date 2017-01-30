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
                ((Enemy) iMovableObject).setNextPos();
                ((Enemy) iMovableObject).checkObjInNextPosAndSetSpeed(gameObjects);
                break;
            case PLAYER:
                //TODO player.setNextPos() has to be called by keyboard event
                ((Player) iMovableObject).checkObjInNextPosAndSetSpeed(gameObjects);
                break;
        }
    }

    public void checkCollisions(AbstractMovableObject movableObject) {

        for (GameObject iGameObject : gameObjects) {
            if (movableObject != iGameObject && movableObject.getPos().equals(iGameObject.getPos())) {

                switch (iGameObject.getGameObjType()) {

                    case WALL:
                        checkCollisionsWithWall(movableObject);
                        break;

                    case PLAYER:
                        checkCollisionsWithPlayer(movableObject, (Player) iGameObject);
                        break;

                    case ENEMY:
                        checkCollisionsWithEnemy(movableObject, iGameObject);
                        break;

                    case PROJECTILE:
                        checkCollisionsWithProjectile(movableObject, iGameObject);
                        break;

                    case ITEM:
                        checkCollisionsWithItem(movableObject, (Item) iGameObject);
                        break;
                }
            }
        }
    }

    /**
     * Checks collsion with Item
     * @param movableObject
     * @param iGameObject
     */
    private void checkCollisionsWithItem(AbstractMovableObject movableObject, Item iGameObject) {
        if (movableObject instanceof Player) {
            ((Player) movableObject).collectItem(iGameObject);
            return;
        }
        System.err.println("only players can collide with items");
    }

    /**
     * Checks collision with projectile
     * @param movableObject
     * @param iGameObject
     */
    private void checkCollisionsWithProjectile(AbstractMovableObject movableObject, GameObject iGameObject) {
        if (movableObject instanceof Enemy) {
            movableObject.destroy();
            iGameObject.destroy();
            return;
        }
        System.err.println("only enemies can collide with projectiles");
    }

    private void checkCollisionsWithEnemy(AbstractMovableObject movableObject, GameObject iGameObject) {
        if (movableObject instanceof Player) {
            ((Player) movableObject).decreaseHealth(((Enemy) iGameObject).getDamage());
            iGameObject.destroy();
            return;
        }
        if (movableObject instanceof Projectile) {
            iGameObject.destroy();
            movableObject.destroy();
            return;
        }
        System.err.println("only projectiles or players can collide with enemies");
    }

    private void checkCollisionsWithPlayer(AbstractMovableObject movableObject, Player iGameObject) {
        //TODO SYNC WITH MULTIPLAYER WHEN FEATURE IS ADDED
        if (movableObject instanceof Enemy) {
            iGameObject.decreaseHealth(((Enemy) movableObject).getDamage());
            movableObject.destroy();
            return;
        }
        System.err.println("only enemies can collide with players");
    }

    private void checkCollisionsWithWall(AbstractMovableObject movableObject) {
        if (movableObject instanceof Projectile) {
            movableObject.destroy();
            return;
        }
        System.err.println("no movable besides projectile should collide with wall!");
    }
}

