package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Player extends Character {

    private int points;
    private boolean hasPrincess;
    private boolean gameOver;

    public Player(Grid grid, GridPosition position) {
        super(grid, position, GameObjType.PLAYER, 2); //TODO: change speed? (current is 3)
        initializeProjectiles(10);      //NUMBER OF BULLETS AVAILABLE FOR PLAYER
        health = 50;
        //speed = 2; //Apagar porque já estamos a passar este valor como 4to argumento do super constructor
    }

    private void initializeProjectiles(int projectilesNumber) {

        projectiles = new Projectile[projectilesNumber];
        String[] projectilesFileNames = {"test/Projectile.png"};

        for (int i = 0; i < projectilesNumber; i++) {

            projectiles[i] = (Projectile) GameObjFactory.getNewGameObj(getGrid(),
                    GameObjType.PROJECTILE, getGrid().makeGridPosition(getPos().getCol(), getPos().getRow(), projectilesFileNames));
        }
    }

    @Override   // TODO => JOAQUIM
    public void move() {

        this.getPos().moveInDirection(getDirection());
    }

    @Override
    public void doAction(GameObject gameObject) {

        switch (gameObject.getGameObjType()) {

            case WALL:
                speed = 0;
                break;
            case PLAYER:
                speed = 0; // FOR WHEN THERE IS MULTIPLAYER
                break;
            case ENEMY:
                speed = 0;
                health -= ((Enemy) gameObject).damage;
                break;
            case PROJECTILE:
                //TODO => What's happening here!!!
                break;
            case ITEM:
                collectItem((Item) gameObject);
                break;
        }

        move();
    }

    private void collectItem(Item gameObject) {

        switch (gameObject.getItemType()) {
            case POTION:
                health += ItemType.POTION.getValue();
                gameObject.getPos().hide();
                break;
            case POISON:
                health += ItemType.POISON.getValue();
                gameObject.getPos().hide();
                break;
            case PRINCESS:
                hasPrincess = true;
                //TODO: Think how to make her follow the player
                //Suggestion: update princess position to last player position (could be a private property from Player previousPos)
                gameObject.getPos().hide();
                break;
            case TREASURE:
                points += ItemType.TREASURE.getValue();
                gameObject.getPos().hide();
                break;
            case EXIT:
                if (hasPrincess) {
                    gameOver = true;
                }
                break;
            default:
                System.out.println("Something went wrong <= Player doAction()");
                break;
        }
    }

    public boolean hasFinished() {
        return gameOver;
    }

    public GameObjType checkWhatAction(GameObject gameObject) {
        return gameObject.getGameObjType();
    }

}
