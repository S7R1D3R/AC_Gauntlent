package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Projectile extends AbstractMovableObject implements Movable { //CORRECTED EXTENSION TO ABSMOVOBJ


    public Projectile(Grid grid, GridPosition pos) {
        super(grid, pos, GameObjType.PROJECTILE, 3);        //ADDED CONSTRUCTOR
    }

    @Override
    public void move() {

    }


}
