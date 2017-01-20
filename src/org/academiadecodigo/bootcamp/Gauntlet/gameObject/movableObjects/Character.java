package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Direction;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public abstract class Character extends GameObject implements Movable {

    private int health;                     // Health Points, when 0 = dead
    private int damage;                     // Damage that projectiles will make
    private Direction direction;            // Direction that character is pointing
    private Projectile projectile;          // Projectile that character will fire

    public abstract void move();            // SETTER : Sets a new GridPosition for the character

    public void shoot() {                   //
        projectile.move(direction);
    }
    public boolean isDead() {               // Checks if character is dead
        if (health <= 0) return true;       // is dead!
        return false;                       // alive!
    }

}
