package org.academiadecodigo.bootcamp.Gauntlet.simplegfx;

import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/21/17.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {
    //TODO Veronica
    private Picture[] pictures;
    private int picIndex = 0;
    private SimpleGfxGrid simpleGfxGrid;


    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid, String[] picsFileNames) {

        super(col, row, grid);

        this.simpleGfxGrid = grid;

        createInitialPictures(picsFileNames);
    }

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {

        super(col, row, grid);

        this.simpleGfxGrid = grid;

    }

    /**
     * Create initial images
     */
    private void createInitialPictures(String[] picsFileNames) {

        pictures = new Picture[picsFileNames.length];

        for (int i = 0; i < picsFileNames.length; i++) {

            int xPos = simpleGfxGrid.columnToX(getCol());
            int yPos = simpleGfxGrid.rowToY(getRow());

            pictures[i] = new Picture(xPos, yPos, picsFileNames[i]);
        }
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        pictures[picIndex].draw();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        pictures[picIndex].delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection)
     */
    @Override
    public void moveInDirection(GridDirection direction) {
        int prevPicIndex = picIndex;
        //Update index to select picture in given direction @see LevelMaker
        switch (direction) {
            case DOWN:
                picIndex = 0;
                break;
            case LEFT:
                picIndex = 1;
                break;
            case UP:
                picIndex = 2;
                break;
            case RIGHT:
                picIndex = 3;
                break;
            default:
                picIndex = 0;
        }

        // Remove current picture from Canvas (if there is a change in direction)
        if (picIndex != prevPicIndex) {
            pictures[prevPicIndex].delete();
        }

        // Save previous position
        int prevX = simpleGfxGrid.columnToX(getCol()); // pixels
        int prevY = simpleGfxGrid.rowToY(getRow()); // pixels

        super.moveInDirection(direction);

        int dx = simpleGfxGrid.columnToX(getCol()) - prevX;
        int dy = simpleGfxGrid.rowToY(getRow()) - prevY;

        // Update position of all pictures
        for (int i = 0; i < pictures.length; i++) {

            pictures[i].translate(dx, dy);
        }

        //Show picture in given direction
        if (picIndex != prevPicIndex) {
            pictures[picIndex].draw();
        }
    }

}
