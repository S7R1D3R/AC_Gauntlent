package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridColor;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Player extends Character {
    private int points;
    private static GridPosition INIT_POS;

    public Player(GridPosition INIT_POS) {

        this.INIT_POS = INIT_POS;
        INIT_POS.setColor(GridColor.GREEN);


}


    public void collect(Item item) {

    }

    @Override   // TODO => JOAQUIM
    public void move() {

    }

    public static GridPosition getInitPos() {
        return INIT_POS;
    }
}
