package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridColor;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

import java.util.Stack;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Obstacle extends GameObject {
    // TODO => PETER

    private GridPosition[][] posMatrix;

    public Obstacle(GridPosition pos) {
        super(pos);
        createLabyrinth(posMatrix, Player.getInitPos());

    }

    private void createLabyrinth(GridPosition[][] posMatrix, GridPosition initPos) {

        GridPosition[][] neighbours = findNeighbours(posMatrix, initPos);
        for (int i = 0; i < neighbours.length; i++) {
            GridPosition pos = neighbours[i][i];
            if (pos != null && !pos.isVisited()) {
                createLabyrinth(posMatrix, pos);
                pos.visit();

            }
        }
    }

    private GridPosition[][] findNeighbours(GridPosition[][] posMatrix, GridPosition initPos) {

        GridPosition[][] neighbours = new GridPosition[3][3];
        int i = initPos.getCol();
        int j = initPos.getRow();
        if (i <= 0) {
            i++;
            if (j <= 0) {
                j++;
            }
            if (j + 1 >= getGrid().getRows()) {
                j--;
            }
            neighbours.add(setPos());
        if (i + 1 >= getGrid().getCols()){
            i--;
            if (j <= 0) {
                j++;
            }
            if (j + 1 >= getGrid().getRows()) {
                j--;
            }

        }


            //LABIRINTO COM INICIO BAIXO ESQUERDA e FIM CIMA DIREITA

        /*posMatrix = new GridPosition[getGrid().getCols()][getGrid().getRows()];
        GridPosition[] visitedCells = new GridPosition[getGrid().getCols()*getGrid().getRows()];

        for (int i = 0; i < posMatrix.length; i++) {
            for (int j = 0; j < posMatrix[0].length; j++) {

            }

        }*/


            Stack
    }


}
