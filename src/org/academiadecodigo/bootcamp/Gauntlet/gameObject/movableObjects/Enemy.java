package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Enemy extends Character {
// TODO: Vero will look into  Peter's code and see if can implement the "police/Ambulance" chase code
private void moveToCloserDrunk() {

    for (Car drunkCar : drunkCars) {

        if (getPos().equals(drunkCar.getPos())) {
            drunkCar.crash();
            drunkCar.arrest();
        } else {
            setChaseDirection(drunkCar);
        }
    }
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
