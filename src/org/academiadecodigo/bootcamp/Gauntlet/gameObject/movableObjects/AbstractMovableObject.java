package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.bootcamp.Gauntlet.test.Game;

/**
 * Created by codecadet on 25/01/17.
 */
public abstract class AbstractMovableObject extends GameObject implements Movable {

    private int speed;                      // Speed => Number of times he moves per game loop
    private GridDirection direction;            // GridDirection that character is facing
    private ActionDetector actionDetector;

    public AbstractMovableObject(Grid grid) {
        super(grid);
    }

    public void setActionDetector(ActionDetector actionDetector) {
        this.actionDetector = actionDetector;
    }

    /**
     *  => Sets next position so we can know if it's going to hit a wall.
     */
    public GridPosition setNextPos() {

        GridPosition nextPos = super.getGrid().makeGridPosition(0, 0);

        switch(direction) {
            case UP:
                nextPos.setPos(getPos().getRow() - 1, getPos().getCol());
                break;
            case RIGHT:
                nextPos.setPos(getPos().getRow(), getPos().getCol() + 1);
                break;
            case DOWN:
                nextPos.setPos(getPos().getRow() + 1, getPos().getCol());
                break;
            case LEFT:
                nextPos.setPos(getPos().getRow(), getPos().getCol() - 1);
                break;
            default:
                nextPos = super.getPos();
        }

    }

    public boolean checkAction() {

        for()
    }

    public GridDirection getDirection() {
        return direction;
    }

    @Override
    public void move() {

        for(Game.gameObjects)
        super.getPos().moveinDirection(getDirection());
    }
}
