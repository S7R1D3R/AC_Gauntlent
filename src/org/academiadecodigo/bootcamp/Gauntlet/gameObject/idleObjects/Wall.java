package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Wall extends GameObject {

    /**
     * Wall constructor
     * @param grid on which wall will be placed
     * @param position on the gird
     */
    public Wall(Grid grid, GridPosition position){
        super(grid, position, GameObjType.WALL);        //ADDED CONSTRUCTOR

    }
}

