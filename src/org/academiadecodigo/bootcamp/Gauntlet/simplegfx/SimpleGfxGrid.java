package org.academiadecodigo.bootcamp.Gauntlet.simplegfx;

import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/21/17.
 */
public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;

    private int cellSize;

    private int cols;

    private int rows;

    private Picture picture;


    public SimpleGfxGrid(int cols, int rows) {
        this.cellSize = 40;
        this.cols = cols;
        this.rows = rows;

    }


    /**
     * @see Grid#init()
     */
    @Override
    public void init() {

        picture = new Picture(PADDING, PADDING, "test/GameBackground.png");
        picture.draw();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * Obtains the width of the grid in pixels
     *
     * @return the width of the grid
     */
    public int getWidth() {
        return picture.getWidth();
    }

    /**
     * Obtains the height of the grid in pixels
     *
     * @return the height of the grid
     */
    public int getHeight() {
        return picture.getHeight();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     *
     * @return the x position of the grid
     */
    public int getX() {
        return picture.getX();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     *
     * @return the y position of the grid
     */
    public int getY() {
        return picture.getY();
    }

    /**
     * Obtains the pixel width and height of a grid position
     *
     * @return
     */
    public int getCellSize() {
        return cellSize;
    }

    /**
     */
    @Override //TODO Vero -> Remove 3rd argument when implementing representables
    public GridPosition makeGridPosition(int col, int row, String[] picsFileNames) {

        return new SimpleGfxGridPosition(col, row, this, picsFileNames);

    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     *
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {

        return row * cellSize + getY();
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     *
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {

        return column * cellSize + getX();
    }
}
