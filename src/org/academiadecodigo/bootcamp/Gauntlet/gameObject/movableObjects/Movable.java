package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public interface Movable extends GridPosition{
    // TODO => VERONICA (GLORIA)
    public void move();


    /**
     * Moves this grid position towards a specified direction
     *
     * @param direction the direction to move to
     * @param distance  the number of positions to move
     */
    public void moveInDirection(GridDirection direction, int distance);


}
