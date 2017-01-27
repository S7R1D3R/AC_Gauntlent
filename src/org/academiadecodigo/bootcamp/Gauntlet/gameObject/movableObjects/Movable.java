package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;


/**
 * Created by Vero on 2017-01-24.
 */
public interface Movable {
    /**
     * Sets all movable objects to move
     */
    public void move();
    /**
     * Sets action detector
     */
    public void setActionDetector(ActionDetector actionDetector);


    /**
     * Gets action detector
     */
    public ActionDetector getActionDetector();
}
