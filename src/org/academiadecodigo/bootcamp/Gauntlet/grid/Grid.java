package org.academiadecodigo.bootcamp.Gauntlet.grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;


/**
 * Created by s7r1d3r on 20-01-2017.
 */
public interface Grid {
    /**
     * Initializes the grid
     */
    public void init();

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    public int getCols();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    public int getRows();

    /**
     * Create a random grid position
     *
     * @return the new grid position
     */
    public GridPosition makeGridPosition();

    /**
     * Creates a a grid position in a specific column and row
     *
     * @param col   the position column
     * @param row   the position row
     * @return the new grid position
     */
    public GridPosition makeGridPosition(int col, int row);

}
