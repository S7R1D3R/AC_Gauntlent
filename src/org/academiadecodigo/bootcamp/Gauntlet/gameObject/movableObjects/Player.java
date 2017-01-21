package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridImages;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Player extends Character {
    private int points;

    public Player() {
        super();
        this.setGrid(Gri);
        this.setPos(grid.makeGridPosition(0, 15));
    }


    public void collect(Item item) {

    }

    @Override   // TODO => JOAQUIM
    public void move() {

    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {

    }

    public GridPosition getPos() {
        return super.getPos();
    }

    @Override
    public int getCol() {
        return super.getPos().getCol();
    }

    @Override
    public int getRow() {
        return super.getPos().getRow();
    }

    @Override
    public void setPos(int col, int row) {
        super.getPos().setPos(col, row);
    }

    @Override
    public GridImages getColor() {
        return this.;
    }

    @Override
    public void setColor(GridImages color) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public boolean equals(GridPosition position) {
        return false;
    }
}
