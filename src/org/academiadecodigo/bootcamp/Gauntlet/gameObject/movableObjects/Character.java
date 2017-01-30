package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public abstract class Character extends AbstractMovableObject {

    protected int health;                        // Health Points
    protected int damage;                        // Damage that this character's projectiles will do
    protected Projectile[] projectiles;          // Projectile that character will fire


    public Character(Grid grid, GridPosition position, GameObjType gameObjType, int speed) {
        super(grid, position, gameObjType, speed);
    }


    public abstract void move();            // SETTER : Sets a new GridPosition for the character

    public int getDamage() {
        return damage;
    }


    //public void shoot() { };                 // Shoots a projectile. For now only the player shoots

}
