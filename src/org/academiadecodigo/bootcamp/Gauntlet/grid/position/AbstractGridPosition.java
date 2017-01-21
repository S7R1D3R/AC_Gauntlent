package org.academiadecodigo.bootcamp.Gauntlet.grid.position;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridColor;
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


        private int col;
        private int row;
        private GridColor color;
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
            this.color = GridColor.NOCOLOR;
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
         * @see GridPosition#getColor()
         */
        @Override
        public GridColor getColor() {
            return color;
        }

        /**
         * @see GridPosition#setColor(GridColor)
         */
        @Override
        public void setColor(GridColor color) {
            this.color = color;
            show();
        }



        /**
         * @see GridPosition#equals(GridPosition)
         */
        @Override
        public boolean equals(GridPosition pos) {
            return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
        }

        public void moveinDirection(GridDirection direction, int distance) {

        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case RIGHTUP:
                moveRightUp(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
            case RIGHTDOWN:
                moveRightDown(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFTDOWN:
                moveLeftDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case LEFTUP:
                moveLeftUp(distance);
                break;
        }

    }

        /**
         * @see GridPosition#equals(GridPosition)
         */
        @Override
        public boolean equals(GridPosition pos) {
            return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
        }

        /**
         * Moves the position up
         *
         * @param dist the number of positions to move
         */
        public void moveUp(int dist) {

            int maxRowsUp = dist < getRow() ? dist : getRow();
            setPos(getCol(), getRow() - maxRowsUp);

        }

        /**
         * Moves the position down
         *
         * @param dist the number of positions to move
         */
        public void moveDown(int dist) {

            int maxRowsDown = dist > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : dist;
            setPos(getCol(), getRow() + maxRowsDown);

        }

        /**
         * Moves the position left
         *
         * @param dist the number of positions to move
         */
        public void moveLeft(int dist) {

            int maxRowsLeft = dist < getCol() ? dist : getCol();
            setPos(getCol() - maxRowsLeft, getRow());

        }

        /**
         * Moves the position right
         *
         * @param dist the number of positions to move
         */
        public void moveRight(int dist) {
            int maxRowsRight = dist > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : dist;
            setPos(getCol() + maxRowsRight, getRow());
        }

        @Override
        public String toString() {
            return "GridPosition{" +
                    "col=" + col +
                    ", row=" + row +
                    ", getColor=" + color +
                    '}';
        }
}
