package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Direction;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public abstract class Character extends GameObject {

    private int health;                     // Health Points
    private int damage;                     // Damage that this character's projectiles will do
    private Direction direction;            // Direction that character is facing
    private Projectile projectile;          // Projectile that character will fire

    public Character() {
        super();
    }


    public abstract void move();            // SETTER : Sets a new GridPosition for the character


    public void shoot() {                   // Shoots a projectile

    }


    public boolean isDead() {               // Checks if character is dead
        return health <= 0;                // is dead!

    }

}
