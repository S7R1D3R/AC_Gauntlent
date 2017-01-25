package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public abstract class Character extends AbstractMovable {

    private int health;                     // Health Points
    private int damage;                     // Damage that this character's projectiles will do
    private Projectile projectile;          // Projectile that character will fire

    public Character(Grid grid) {
        super(grid);
    }


    public abstract void move();            // SETTER : Sets a new GridPosition for the character


    public void shoot() {                   // Shoots a projectile

    }


    public boolean isDead() {               // Checks if character is dead
        return health <= 0;                // is dead!

    }

}
