package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
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


    public Enemy(Grid grid, GridPosition position) {

        super(grid, position, GameObjType.ENEMY, 1);//TODO: change speed of enemy?
        health = 1;// Enemies die with one hit
        damage = 10;

    }


    /**
     * Will move in direction that he's facing *speed* times.
     */

    @Override
    public void move() {

        for (int i = 0; i < this.speed; i++) {
            this.getPos().moveInDirection(getDirection());
        }
    }


    /**
     * Decides direction it will face depending on the position of the player.
     *
     * @param playerPosition
     */

    //TODO PUT PRIVATE AGAIN, public for test
    public void setDirectionTowardsPlayer(GridPosition playerPosition) {

        int colDiff = playerPosition.getCol() - this.getPos().getCol();        //cols needed to reach player's col pos
        int rowDiff = playerPosition.getRow() - this.getPos().getRow();        //rows needed to reach player's row pos


        //if col distance between enemy and player is bigger than row distance
        if (colDiff >= rowDiff) {

            //Enemy will try to catch the player up closing up col distance first
            if (colDiff > 0) {
                this.direction = GridDirection.RIGHT;
                return;
            }
            if (colDiff < 0) {
                this.direction = GridDirection.LEFT;
                return;
            }
            if (rowDiff > 0) {
                this.direction = GridDirection.DOWN;
                return;
            }
            if (rowDiff < 0) {
                this.direction = GridDirection.UP;
                return;
            }
        }
        //Else will try to catchup closing up rows first
        else {
            if (rowDiff > 0) {
                this.direction = GridDirection.DOWN;
                return;
            }
            if (rowDiff < 0) {
                this.direction = GridDirection.UP;
                return;
            }
            if (colDiff > 0) {
                this.direction = GridDirection.RIGHT;
                return;
            }
            if (colDiff < 0) {
                this.direction = GridDirection.LEFT;
                return;
            }
        }
    }


    /**
     * Decides what action enemy will take depending on the gameobject received
     *
     * @param objectInNextPos
     */


    //para mim nao faz mesmo sentido o doAction estar no Enemy e não no action detector. para fazeres isto camos ter de
    //fazer varias iteracoes nos gameobjects para realizar o doAction, enquanto se fosse no actiondetector acho que
    //seria bem mais facil pq ja conhece tudo o que está no game.
    public void doAction(GameObject objectInCurrentPos, GameObject objectInNextPos) {
        if(objectInNextPos == null) {                         //Enemy will move if he has free space ahead
            speed = 1;
            move();
            setNextPos();
            return;
        }
        switch (objectInNextPos.getGameObjType()) {

            case WALL:                  //Enemy won't move if he encounters a wall, an item or another enemy
            case ENEMY:
            case ITEM:
                speed = 0;
                break;
            case PROJECTILE:            //Enemy will die if he collides with the player or a projectile
            case PLAYER:
                speed = 1;
                move();
                setNextPos();
                break;
            default:
                throw new EnumConstantNotPresentException(GameObjType.class, objectInNextPos.toString());
        }

        if(objectInCurrentPos == null){                         //Enemy will move if he has free space ahead
            return;
        }
        switch (objectInCurrentPos.getGameObjType()){

            case PROJECTILE:            //Enemy will die if he collides with the player or a projectile
            case PLAYER:
                destroy();
                break;
            default:
                break;
        }


    }
}
