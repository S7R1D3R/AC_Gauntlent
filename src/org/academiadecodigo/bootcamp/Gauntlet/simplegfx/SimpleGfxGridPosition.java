package org.academiadecodigo.bootcamp.Gauntlet.simplegfx;

import org.academiadecodigo.bootcamp.Gauntlet.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by codecadet on 1/21/17.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    //TODO: Joaquim. Change all methods of Rectangle for Picture methods
    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    //TODO: If we decide to remove this constructor, we'll have to remove it also in the interface Grid and in SimplGFXGrid as well. So let's leave it for now.
    // In order to create any position, we need to know the wallsPositions
    public SimpleGfxGridPosition(SimpleGfxGrid grid, GridPosition[] wallPositions){

        //TODO:
        super((int) (Math.random() * grid.getCols()),
                (int) (Math.random() * grid.getRows()),
                grid, wallPositions);

        this.simpleGfxGrid = grid;

        rectangle = new Rectangle(super.getCol()*simpleGfxGrid.getCellSize() + simpleGfxGrid.getX(),
                super.getRow()*simpleGfxGrid.getCellSize() + simpleGfxGrid.getY(),
                simpleGfxGrid.getCellSize(), simpleGfxGrid.getCellSize());

        rectangle.setColor(SimpleGfxColorMapper.getColor(super.getColor()));

        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid, GridPosition[] wallPositions){
        super(col, row, grid, wallPositions);

        this.simpleGfxGrid = grid;

        rectangle = new Rectangle(super.getCol()*simpleGfxGrid.getCellSize() + simpleGfxGrid.getX(),
                super.getRow()*simpleGfxGrid.getCellSize() + simpleGfxGrid.getY(),
                simpleGfxGrid.getCellSize(), simpleGfxGrid.getCellSize());

        rectangle.setColor(SimpleGfxColorMapper.getColor(super.getColor()));

        show();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int prevX = simpleGfxGrid.columnToX(this.getCol()); // pixels
        int prevY = simpleGfxGrid.rowToY(super.getRow()); // pixels

        super.moveInDirection(direction, distance);

        int dx = simpleGfxGrid.columnToX(super.getCol()) - prevX;
        int dy = simpleGfxGrid.rowToY(super.getRow()) - prevY;

        rectangle.translate(dx, dy);

    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));

    }
}
}
