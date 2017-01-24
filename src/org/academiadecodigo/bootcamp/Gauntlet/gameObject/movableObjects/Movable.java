package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.grid.CollisionDectector;

/**
 * Created by Vero on 2017-01-24.
 */
public interface Movable {
    /**
     * Sets all movable objects to move
     */
    public void move();

    /**
     * Sets collision detector
     */
    public void setCollisionDetector(CollisionDectector collisionDetector);
}
