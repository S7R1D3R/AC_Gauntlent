package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by codecadet on 25/01/17.
 */
public abstract class AbstractMovable extends GameObject implements Movable {

    private int speed;                      // Speed => Number of times he moves per game loop
    private GridDirection direction;            // GridDirection that character is facing
    private GridPosition nextPos;

    public AbstractMovable(Grid grid) {
        super(grid);
    }

    public GridPosition getNextPos() {
        return nextPos;
    }

    public GridDirection getDirection() {
        return direction;
    }

    @Override
    public void move() {
        super.getPos().moveinDirection(getDirection());
    }
}
