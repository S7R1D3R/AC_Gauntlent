package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

import java.util.ArrayList;

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
        health = 1;                             // Enemies die with one hit

    }


    /**
     * Will move in direction that he's facing *speed* times.
     */

    @Override
    public void move() {

        for (int i = 0; i < this.speed; i++) {
            this.getPos().moveInDirection(getDirection());
            setNextPos();
        }
    }


    /**
     * Decides direction it will face depending on the position of the player.
     *
     * @param player
     */

    //TODO PUT PRIVATE AGAIN, public for test
    public void setDirectionTowardsPlayer(Player player) {

        int colDiff = player.getPos().getCol() - this.getPos().getCol();        //cols needed to reach player's col pos
        int rowDiff = player.getPos().getRow() - this.getPos().getRow();        //rows needed to reach player's row pos


        //if col distance between enemy and player is bigger than row distance
        if (Math.abs(colDiff) >= Math.abs(rowDiff)) {

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
     * Decides what action enemy will take depending on the gameobject on next pos
     *
     */


    public void checkObjInNextPosAndSetSpeed() {

        if (actionDetector.isNextPosWalkable(this)){
            speed = 1;
            return;
        }
        speed = 0;
    }
}


