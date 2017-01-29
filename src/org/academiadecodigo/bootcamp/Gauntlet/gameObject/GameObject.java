package org.academiadecodigo.bootcamp.Gauntlet.gameObject;

import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public abstract class GameObject{

    private GameObjType gameObjType;
    private Grid grid;
    private GridPosition pos;
    private boolean destroyed;

    /**
     * SuperClass constructor
     *
     * @param grid on which game object will be placed
     * @param pos position on the gird
     * @param gameObjType type of object
     */
    public GameObject(Grid grid, GridPosition pos, GameObjType gameObjType){
        this.grid = grid;
        this.pos = pos;
        this.gameObjType = gameObjType;
    }

    /**
     * Gets the game object's grid;
     * @return grid
     */
    public Grid getGrid(){
        return grid;
    }

    /**
     * Gets the game object's position in the grid
     * @return position
     */
    public GridPosition getPos(){
        return pos;
    }

    /**
     * Gets the game object's type
     * @return game object type
     */
    public GameObjType getGameObjType() {
        return gameObjType;
    }

    /**
     * @returns true if object is destroyed
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * Destroys the gameObject
     */
    public void destroy(){
        destroyed = true;
        getPos().hide();
    }

    @Override
    public String toString() {

        return gameObjType.toString();
    }
}
