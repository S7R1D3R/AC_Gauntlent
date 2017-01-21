package org.academiadecodigo.bootcamp.Gauntlet.grid.position;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridColor;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;

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
}
