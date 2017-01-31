package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.bootcamp.Gauntlet.simplegfx.KeyboardInput;

import java.util.ArrayList;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Player extends Character {

    private int points;
    private boolean hasPrincess;
    private boolean reachedEnd;

    private KeyboardInput keyboardInput;

    public Player(Grid grid, GridPosition position) {
        super(grid, position, GameObjType.PLAYER, 1); //TODO: change speed? (current is 3)
//        initializeProjectiles(10);      //NUMBER OF BULLETS AVAILABLE FOR PLAYER
        health = 500;
    }

    private void initializeProjectiles(int projectilesNumber) {

        projectiles = new Projectile[projectilesNumber];
        String[] projectilesFileNames = {"ProjectileUp.png", "ProjectileRight.png", "ProjectileDown.png", "ProjectileLeft.png"};

        for (int i = 0; i < projectilesNumber; i++) {

            projectiles[i] = (Projectile) GameObjFactory.getNewGameObj(getGrid(),
                    GameObjType.PROJECTILE, getGrid().makeGridPosition(getPos().getCol(), getPos().getRow(), projectilesFileNames));
        }
    }


    @Override
    public void move() {

        for (int i = 0; i < speed; i++) {
            this.getPos().moveInDirection(getDirection());
            setNextPos();
            // Move projectiles with player (not visible)
            /*for (int j = 0; j < projectiles.length; j++) {
                projectiles[j].getPos().moveInDirection(getDirection());
                projectiles[j].getPos().hide();
            }*/
        }
    }


    public void checkObjInNextPosAndSetSpeed(ArrayList<GameObject> gameObjects) {
        for (GameObject iGameObject : gameObjects) {
            if (!iGameObject.getPos().equals(getNextPos())) {
                continue;
            }
            switch (iGameObject.getGameObjType()) {

                case WALL:
                case PLAYER:
                    speed = 0; // FOR WHEN THERE IS MULTIPLAYER
                    return;
                case ENEMY:
                case PROJECTILE:
                case ITEM:
                    speed = 1;
                    return;
            }
        }
        speed = 1;
    }


    public void collectItem(Item gameObject) {

        switch (gameObject.getItemType()) {
            case POTION:
            case POISON:
                System.out.println("Health pre-" + gameObject.getItemType() + ": " + getHealth());
                health += gameObject.getItemType().getValue();
                System.out.println("Health pos-" + gameObject.getItemType() + ": " + getHealth());
                break;
            case PRINCESS:
                hasPrincess = true;
                //TODO: Think how to make her follow the player
                //Suggestion: update princess position to last player position (could be a private property from Player previousPos)
                break;
            case TREASURE:
                points += ItemType.TREASURE.getValue();

                break;
            case EXIT:
                if (hasPrincess) {
                    reachedEnd = true;
                }
                break;
            default:
                System.out.println("Something went wrong <= Player checkObjInNextPosAndSetSpeed()");
                break;
        }
    }

    public boolean hasFinished() {
        return reachedEnd;
    }

    public void setDirection(GridDirection newDirection) {
        direction = newDirection;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setKeyboard(KeyboardInput keyboard) {
        keyboardInput = keyboard;
    }

    public void decreaseHealth(int damage) {

        if (health > damage) {
            health -= damage;
        } else {
            destroy();
            /*for (int i = 0; i < projectiles.length; i++) {
                projectiles[i].destroy();
            }*/
        }
    }
}
