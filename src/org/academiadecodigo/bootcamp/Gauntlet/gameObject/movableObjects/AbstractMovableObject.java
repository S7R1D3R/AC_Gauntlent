package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by codecadet on 25/01/17.
 */
public abstract class AbstractMovableObject extends GameObject implements Movable {

    protected int speed;                      // Speed => Number of times he moves per game loop
    protected GridDirection direction;            // GridDirection that character is facing
    private ActionDetector actionDetector;
    // private GridPosition nextPos;            // Removing after ActionDetector is OKAY.

    public AbstractMovableObject(Grid grid, GridPosition position, GameObjType gameObjType, int speed) {
        super(grid, position, gameObjType);
        this.speed = speed;
    }

    /**
     * Sets action detector
     */
    public void setActionDetector(ActionDetector actionDetector){
        this.actionDetector = actionDetector;
    }

    /**
     * Gets action detector
     */
    public ActionDetector getActionDetector(){
        return actionDetector;
    }

    /**
     *  => Sets next position so we can know if it's going to hit a wall.
     */
    /*   TODO: JOAQUIM waiting for removal after ActionDetector is playing well
    public GridPosition setNextPos() {

        GridPosition nextPos = super.getGrid().makeGridPosition(0, 0);

        switch(direction) {
            case UP:
<<<<<<< Updated upstream
                nextPos = super.getGrid().makeGridPosition(super.getPos().getCol() - 1, super.getPos().getRow())
                break;
            case RIGHT:
                nextPos = super.getGrid().makeGridPosition(super.getPos().getCol(), super.getPos().getRow() + 1)
                break;
            case DOWN:
                nextPos = super.getGrid().makeGridPosition(super.getPos().getCol() + 1, super.getPos().getRow())
=======
                nextPos = getGrid().makeGridPosition(getPos().getCol(), getPos().getRow() - 1);
                break;
            case RIGHT:
                nextPos = getGrid().makeGridPosition(getPos().getCol() + 1, getPos().getRow() );
                break;
            case DOWN:
                nextPos = getGrid().makeGridPosition(getPos().getCol(), getPos().getRow() + 1);
>>>>>>> Stashed changes
                break;
            case LEFT:
                nextPos = super.getGrid().makeGridPosition(super.getPos().getCol() - 1, super.getPos().getRow())
                break;
            default:
                nextPos = super.getGrid().makeGridPosition(super.getPos().getCol(), super.getPos().getRow())
        }

        return nextPos;
    }
    */

    public GridDirection getDirection() {
        return direction;
    }

    public abstract void doAction(GameObject gameObject);
}
