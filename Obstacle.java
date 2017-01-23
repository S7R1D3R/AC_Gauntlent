package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Obstacle extends GameObject {



    private int[][] wallPosIndex = {{0, 1, 2, 3, 4, 9, 10, 11, 12, 13, 14, 23, 24, 25, 26, 27},
                                    {13, 14, 24},
                                    {3, 4, 10, 11, 13, 14, 16, 17, 18, 19, 20, 21, 24}}; //TODO -- LISTA DE PAREDES



    private GridPosition[] wallsPositions;


    public Obstacle() {
        super();
        createWallsArray(wallPosIndex);

    }



    /**
     * CREATE ARRAY WITH ALL POSITIONS WHERE WALLS ARE GOING TO BE PLACED
     *
     * @param wallPosIndex list of indexes where walls are going to be
     * @return array with all positions where walls are
     */
    public GridPosition[] createWallsArray(int[][] wallPosIndex) {

        for (int i = 0; i < getGrid().getRows(); i++) {
            for (int j = 0; j < wallPosIndex.length; j++) {
                wallsPositions = addToArray(wallsPositions, getGrid().makeGridPosition(wallPosIndex[i][j], i));
            }
        }
        return wallsPositions;
    }




    /**
     * CREATES NEW ARRAY AND APPENDS A POSITION TO IT
     *
     * @param wallPositions array with wall positions.
     * @param pos position to append to the array
     * @return final array of Grid Positions will all wall pos'
     */

    private GridPosition[] addToArray(GridPosition[] wallPositions, GridPosition pos) {

        if (pos == null) {
            return wallPositions;
        }
        if (wallPositions == null) {
            wallPositions = new GridPosition[1];
            wallPositions[0] = pos;
            return wallPositions;
        }

        GridPosition[] newPosArray = new GridPosition[wallPositions.length + 1];

        for (int i = 0; i < wallPositions.length; i++) {
            newPosArray[i] = wallPositions[i];
        }
        newPosArray[wallPositions.length] = pos;
        return newPosArray;

    }

    public GridPosition[] getWallsPositions(){
        return wallsPositions;
    }
}

