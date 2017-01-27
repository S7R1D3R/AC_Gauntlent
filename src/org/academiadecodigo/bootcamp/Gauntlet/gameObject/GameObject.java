package org.academiadecodigo.bootcamp.Gauntlet.gameObject;

import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public abstract class GameObject{

    private GameObjType gameObjType;
    private Picture[] gameObjImgs; //TODO: Vero -> Remove when implementing representable
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

    /** //TODO: Vero -> Remove when implementing representable
     * Set images for game object. Call only at the beginning.
     */
    public void setGameObjImgs(String[] picsFileNames) {

        gameObjImgs = new Picture[picsFileNames.length];

        for (int i = 0; i < picsFileNames.length; i++) {

            gameObjImgs[i] = new Picture(pos.getCol(), pos.getRow(), picsFileNames[i]);
        }
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
    }
}
