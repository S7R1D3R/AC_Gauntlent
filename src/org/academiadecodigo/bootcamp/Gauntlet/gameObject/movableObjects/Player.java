package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridImage;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

import static com.sun.java.accessibility.util.EventID.ITEM;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Player extends Character {

    private int points;
    private boolean hasPrincess;

    public Player(Grid grid, GridPosition position) {
        super(grid, position, GameObjType.PLAYER, 3, picsFileNames); //TODO: change speed? (current is 3)
<<<<<<< HEAD

        String[] picsFileNames = {"PlayerUp.png", "PlayerRight.png", "PlayerDown.png", "PlayerLeft.png"};
        setGameObjImgs(picsFileNames);
=======
=======
        super(grid, position, GameObjType.PLAYER, 3); //TODO: change speed? (current is 3)

<<<<<<< HEAD
=======

        String[] picsFileNames = {"PlayerUp.png", "PlayerRight.png", "PlayerDown.png", "PlayerLeft.png"};
        setGameObjImgs(picsFileNames);
>>>>>>> 437a4d2163bda4c71bfc20047bcd1e1c87bff451
>>>>>>> bdbb9d1de1d30dbb2daefcc7c141a2805ea0015d
>>>>>>> 93712793b6c00d284981d67132546afd0e37a3cf
    }

    @Override   // TODO => JOAQUIM
    public void move() {

    }

    @Override
    public void doAction(GameObject gameObject) {

        switch (gameObject.getGameObjType()) {

            case WALL:
                speed = 0;
                break;
            case PLAYER:
                speed = 0; // FOR WHEN THERE IS MULTIPLAYER
                break;
            case ENEMY:
                speed = 0;
                health -= 10;
                break;
            case PROJECTILE:
                break;
            case ITEM:
                
                switch (((Item) gameObject).getItemType()) {
                    case POTION:
                        health += ItemType.POTION.getValue();
                        break;
                    case POISON:
                        health += ItemType.POISON.getValue();
                        break;
                    case PRINCESS:
                        savePrincess();
                        break;
                    case TREASURE:
                        points += ItemType.TREASURE.getValue();
                        break;
                    case EXIT:
                        //TODO: Create method to end Game
                        break;
                    default:
                        System.out.println("Something went wrong <= Player doAction()");
                        break;
            }
                move();
        }
    }

    public void savePrincess() {
        hasPrincess = true;
    }

    public GameObjType checkWhatAction(GameObject gameObject) {
        return gameObject.getGameObjType();
    }

}
