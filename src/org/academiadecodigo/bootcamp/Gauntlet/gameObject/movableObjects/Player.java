package org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Wall;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.bootcamp.Gauntlet.simplegfx.KeyboardInput;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Player extends Character {

    private int points;
    private boolean hasPrincess;
    private boolean gameOver;

    private KeyboardInput keyboardInput;

    public Player(Grid grid, GridPosition position) {
        super(grid, position, GameObjType.PLAYER, 2); //TODO: change speed? (current is 3)
        initializeProjectiles(10);      //NUMBER OF BULLETS AVAILABLE FOR PLAYER
        health = 50;
    }

    private void initializeProjectiles(int projectilesNumber) {

        projectiles = new Projectile[projectilesNumber];
        String[] projectilesFileNames = {"ProjectileUp.png", "ProjectileRight.png", "ProjectileDown.png", "ProjectileLeft.png"};

        for (int i = 0; i < projectilesNumber; i++) {

            projectiles[i] = (Projectile) GameObjFactory.getNewGameObj(getGrid(),
                    GameObjType.PROJECTILE, getGrid().makeGridPosition(getPos().getCol(), getPos().getRow(), projectilesFileNames));
        }
    }

    @Override   // TODO => JOAQUIM
    public void move() {


        this.getPos().moveInDirection(getDirection());
        getActionDetector().setPlayerPos(getPos());
        setNextPos();
    }

    @Override
    public void doAction(GameObject gameObjectInSamePos, GameObject gameObjectInNextPos) {
//        if(gameObjectInNextPos instanceof Wall) {
//            speed = 0;
//            return;
//        }
        if(gameObjectInSamePos == null){
            speed = 1;
            move();//PARA NAO DAR ERRO SE NAO TIVER NADA A FRENTE
            return;
        }
        switch (gameObjectInSamePos.getGameObjType()) {

            case PLAYER:
                speed = 0; // FOR WHEN THERE IS MULTIPLAYER
                break;
            case ENEMY:
                System.out.println("HEALTH IS: " + health);
                health -= ((Enemy) gameObjectInSamePos).damage;
                System.out.println("HEALTH IS NOW :" + health);
                speed = 1;
                gameObjectInSamePos.destroy();
                move();

                break;
            case PROJECTILE:
                //TODO => What's happening here!!!
                break;
            case ITEM:
                speed = 1;
                collectItem((Item) gameObjectInSamePos);
                move();
                break;
            default:
                move();
                break;
        }
        /*if(isNextPosWall()){

        }*/

    }

    private boolean isNextPosWall() {
        return actionDetector.checkObjectInNextPos(this) instanceof Wall;
    }

    private void collectItem(Item gameObject) {

        switch (gameObject.getItemType()) {
            case POTION:
                health += ItemType.POTION.getValue();
                gameObject.getPos().hide();
                break;
            case POISON:
                health += ItemType.POISON.getValue();
                gameObject.getPos().hide();
                break;
            case PRINCESS:
                hasPrincess = true;
                //TODO: Think how to make her follow the player
                //Suggestion: update princess position to last player position (could be a private property from Player previousPos)
                gameObject.getPos().hide();
                break;
            case TREASURE:
                points += ItemType.TREASURE.getValue();
                gameObject.getPos().hide();
                break;
            case EXIT:
                if (hasPrincess) {
                    gameOver = true;
                }
                break;
            default:
                System.out.println("Something went wrong <= Player doAction()");
                break;
        }
    }

    public boolean hasFinished() {
        return gameOver;
    }

    public void setDirection(GridDirection newDirection) {
        direction = newDirection;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setKeyboard(KeyboardInput keyboard) {
        keyboardInput = keyboard;
    }

    public GameObjType checkWhatAction(GameObject gameObject) {
        return gameObject.getGameObjType();
    }

}
