package org.academiadecodigo.bootcamp.Gauntlet.grid.position;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridImage;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;

/**
 * Created by peter on 20-01-2017.
 */
    /**
     * Base skelleton for a grid position
     *
     * @see GridPosition
     */
public abstract class AbstractGridPosition implements GridPosition{
// TODO: Veronica

        private int col;
        private int row;
        private GridImage gridImage; // TODO: This is the only property constraining our code to simpleGFX, go back to color?
        private Grid grid;

        /**
         * Construct a new grid position at a specific column and row
         *
         * @param col   the column of the grid position
         * @param row   the row of the grid position
         * @param grid  the grid in which the position will be displayed
         */
        public AbstractGridPosition(int col, int row, Grid grid) {
            this.col = col;
            this.row = row;
            this.grid = grid;
        }

        public Grid getGrid() {
            return grid;
        }

        /**
         * @see GridPosition#setPos(int, int)
         */
        @Override
        public void setPos(int col, int row) {
            this.col = col;
            this.row = row;
            show();
        }

        /**
         * @see GridPosition#getCol()
         */
        @Override
        public int getCol() {
            return col;
        }

        /**
         * @see GridPosition#getRow()
         */
        @Override
        public int getRow() {
            return row;
        }

        /**
         * @see GridPosition#getGridImage()
         */
        @Override
        public GridImage getGridImage() {
            return gridImage;
        }

        /**
         * @see GridPosition#setImage(GridImage)
         */
        @Override
        public void setImage(GridImage gridImage) {
            this.gridImage = gridImage;
            show();
        }

        @Override
        public void moveInDirection(GridDirection direction) {
        // TODO: For now we move always one cell at a time. Later: Think on how to smooth the movement, so objects move in pixels not in columns

        switch (direction) {

            case UP:
                moveUp();
                break;
            case RIGHT:
                moveRight();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;

        }

    }

        /**
         * @see GridPosition#equals(GridPosition)
         */
        @Override
        public boolean equals(GridPosition pos) {
            return this.col == pos.getCol() && this.row == pos.getRow();
        }

        //TODO: For now edge of the grid is edge of the room. Later: include roomWalls in wallsPositions
        /**
         * Moves the position up one cell
         */
        public void moveUp() {

            if (getRow() == 0) {
                return;
            }

            setPos(getCol(), getRow() - 1);

        }

        /**
         * Moves the position down
         */
        public void moveDown() {

            if (getRow() == getGrid().getRows() - 1) {
                return;
            }

            setPos(getCol(), getRow() + 1);
        }

        /**
         * Moves the position left
         */
        public void moveLeft() {

            if (getCol() == 0) {
                return;
            }

            setPos(getCol() - 1, getRow());

        }

        /**
         * Moves the position right
         */
        public void moveRight() {

            if (getCol() == getGrid().getCols() - 1) {
                return;
            }

            setPos(getCol() + 1, getRow());

        }

        @Override
        public String toString() {
            return "GridPosition{" +
                    "col=" + col +
                    ", row=" + row +
                    ", getGridImage=" + gridImage +
                    '}';
        }
}
