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
    private Picture gameObjImg; // TODO_From Vero to Joaquim: This property is not necessary here because it must be called by simpleGfxGridPosition
    private Grid grid;
    private GridPosition pos;
    private boolean destroyed;

    public GameObject(Grid grid, GridPosition pos, GameObjType gameObjType){
        this.grid = grid;
        this.pos = pos;
        this.gameObjType = gameObjType;
    }

    public Grid getGrid(){
        return grid;
    }

    public GridPosition getPos(){
        return pos;
    }

    public GameObjType getGameObjType() {
        return gameObjType;
    }

    public void destroy(){
        destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
