package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.grid.CollisionDectector;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Enemy extends Character {
// TODO: Vero will look into  Peter's code and see if can implement the "police/Ambulance" chase code
// Remember to do for loop for speed and think on how to
// smooth movement as enemies will have to move slower than
// player, but we don't want the player to move two cells at
// a time, as it would look like teletransportation

    //TODO ENEMY TEM DE CONFIRMAR AS PAREDES

    private CollisionDectector collisionDectector;

    public Enemy(Grid grid) {
        super(grid);
    }

    private void moveTowardsPlayer() {







    /*for (Car drunkCar : drunkCars) {

        if (getPos().equals(drunkCar.getPos())) {
            drunkCar.crash();
            drunkCar.arrest();
        } else {
            setChaseDirection(drunkCar);
        }
    }*/
}

    public void setCollisionDectector(CollisionDectector collisionDectector) {
        this.collisionDectector = collisionDectector;
    }

    private void setChaseDirection(Car drunkCar) {
        if (getPos().getRow() < drunkCar.getPos().getRow()) {
            while (changeDirection() != Direction.DOWN) {
                changeDirection();
            }
        }
        if (getPos().getRow() > drunkCar.getPos().getRow()) {
            while (changeDirection() != Direction.UP) {
                changeDirection();
            }
        }
        if (getPos().getCol() < drunkCar.getPos().getCol()) {
            while (changeDirection() != Direction.RIGHT) {
                changeDirection();
            }
        }
        if (getPos().getCol() > drunkCar.getPos().getCol()) {
            while (changeDirection() != Direction.LEFT) {
                changeDirection();
            }
        }
    }

}
