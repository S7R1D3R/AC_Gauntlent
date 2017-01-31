package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

import java.util.ArrayList;

/**
 * Created by codecadet on 25/01/17.
 */
public abstract class AbstractMovableObject extends GameObject implements Movable {

    protected int speed;                      // Speed => Number of times he moves per game loop
    protected GridDirection direction;            // GridDirection that character is facing
    protected ActionDetector actionDetector;
    private GridPosition nextPos;            // Removing after ActionDetector is OKAY.

    public AbstractMovableObject(Grid grid, GridPosition position, GameObjType gameObjType, int speed) {
        super(grid, position, gameObjType);
        this.speed = speed;
        direction = GridDirection.DOWN;
        setNextPos();
    }

    /**
     * Sets action detector
     */
    public void setActionDetector(ActionDetector actionDetector) {
        this.actionDetector = actionDetector;
    }

    /**
     * Gets action detector
     */
    public ActionDetector getActionDetector() {
        return actionDetector;
    }

    /**
     * => Sets next position so we can know if it's going to hit a wall.
     */
    //TODO: JOAQUIM waiting for removal after ActionDetector is playing well
    public void setNextPos() {

        switch (this.direction) {
            case UP:
                nextPos = getGrid().makeGridPosition(getPos().getCol(), getPos().getRow() - 1);
                break;
            case RIGHT:
                nextPos = getGrid().makeGridPosition(getPos().getCol() + 1, getPos().getRow() );
                break;
            case DOWN:
                nextPos = getGrid().makeGridPosition(getPos().getCol(), getPos().getRow() + 1);
                break;
            case LEFT:
                nextPos = getGrid().makeGridPosition(getPos().getCol() - 1, getPos().getRow());
                break;
            default:
                nextPos = getGrid().makeGridPosition(getPos().getCol(), getPos().getRow());
        }

    }


    public GridDirection getDirection() {
        return direction;
    }

    public abstract void checkObjInNextPosAndSetSpeed();

    public GridPosition getNextPos() {
        return nextPos;
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
       return "Gameobjtype is: " + getGameObjType().toString() +  "   direction is: "  + direction + " Pos is : " + getPos().toString() + "  nextposis: " + getNextPos();
    }
}
