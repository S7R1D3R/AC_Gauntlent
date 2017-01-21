package org.academiadecodigo.bootcamp.Gauntlet.gameObject;

import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public abstract class GameObject{

    private GameObjType gameObjType;
    private Picture gameObjImg;
    private Grid grid;
    private GridPosition pos;

    public GameObject(){
        
    }

    public void setGrid(Grid grid){
        this.grid = grid;
    }

    public Grid getGrid(){
        return grid;
    }

    public GridPosition getPos(){
        return pos;
    }


}
