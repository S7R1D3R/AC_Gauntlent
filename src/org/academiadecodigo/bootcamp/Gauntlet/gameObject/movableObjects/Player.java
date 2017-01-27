package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridImage;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Player extends Character {

    private int points;
    private boolean hasPrincess;

    public Player(Grid grid, GridPosition position) {
        super(grid, position, GameObjType.PLAYER, 3); //TODO: change speed? (current is 3)
    }


    public void collect(Item item) {

    }

    @Override   // TODO => JOAQUIM
    public void move() {

    }

    public void savePrincess() {
        hasPrincess = true;
    }
}
