package org.academiadecodigo.bootcamp.Gauntlet.grid.position;


import org.academiadecodigo.bootcamp.Gauntlet.grid.GridImage;

/**
 * A position on the grid
 */
public interface GridPosition {

    /**
     * Gets the position column in the grid
     *
     * @return the position column
     */
    public int getCol();

    /**
     * Gets the position row in the grid
     *
     * @return the position row
     */
    public int getRow();

    /**
     * Updates the position column and row
     *
     * @param col the new position column
     * @param row the new position row
     */
    public void setPos(int col, int row);

    /**
     * Gets the position getGridImage
     *
     * @return the position getGridImage
     */
    public GridImage getGridImage();

    /**
     * Changes the getGridImage of this grid position
     *
     * @param gridImages the new position getGridImage
     */
    public void setImage(GridImage gridImages);

    /**
     * Displays the position in the grid
     */
    public void show();

    /**
     * Hides the position in the grid
     */
    public void hide();


    /**
     * Tests equality with another position
     *
     * @param position the position to test against
     * @return true if positions are equal
     */
    public boolean equals(GridPosition position);

}
