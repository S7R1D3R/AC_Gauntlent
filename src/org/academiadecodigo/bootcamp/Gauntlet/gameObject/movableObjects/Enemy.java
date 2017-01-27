package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.CollisionDectector;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Enemy extends Character {
// Remember to do for loop for speed and think on how to
// smooth movement as enemies will have to move slower than
// player, but we don't want the player to move two cells at
// a time, as it would look like teletransportation

    boolean trueOrFalse;

    //TODO ENEMY TEM DE CONFIRMAR AS PAREDES
    public Enemy(Grid grid, GridPosition position) {

        super(grid, position, GameObjType.ENEMY, 1);//TODO: change speed of enemy?
<<<<<<< HEAD
        // TODO: Change when implementing representable interface
        // This piece of code will change when implementing interface representable
        // For now, we want to see things moving without animation and low performance
        health = 60;
        speed = 1;
=======

>>>>>>> 6e3ddd7044a4ad99584b41156f041d3c2ede4438
    }

    @Override
    public void move() {
        this.getPos().moveinDirection(getDirection());
    }

    private void moveTowardsPlayer(Player player) {
        int playerX = player.getPos().getCol();
        int playerY = player.getPos().getRow();

        int enemyX = this.getPos().getCol();
        int enemyY = this.getPos().getRow();

        GridDirection newDirection;

        if(trueOrFalse) {

            if (playerX > enemyX) {
                newDirection = GridDirection.RIGHT;         // MOVE RIGHT
            } else {
                newDirection = GridDirection.LEFT;          // MOVE LEFT
            }

        } else {

            if(playerY > enemyY) {
                newDirection = GridDirection.UP;            // MOVE UP
            } else {
                newDirection = GridDirection.DOWN;          // MOVE DOWN
            }
        }

        direction = newDirection;
        move();
    }

    public void doAction(GameObject gameObject) {

        switch (gameObject.getGameObjType()) {

            case WALL:
                speed = 0;
                break;
            case PLAYER:
                speed = 0;
                break;
            case ENEMY:
                speed = 0;
                break;
            case PROJECTILE:
                health -= 20;
                break;
            case POTION:

                break;
            case POISON:

                break;
            case PRINCESS:

                break;
            case EXIT:

                break;
        }
    }


}
