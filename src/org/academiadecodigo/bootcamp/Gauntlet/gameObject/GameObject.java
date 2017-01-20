package org.academiadecodigo.bootcamp.Gauntlet.gameObject;

import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public abstract class GameObject implements GridPosition {
    Grid grid;
    GridPosition pos;
}
