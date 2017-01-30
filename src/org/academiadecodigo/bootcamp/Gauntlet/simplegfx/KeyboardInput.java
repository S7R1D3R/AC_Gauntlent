package org.academiadecodigo.bootcamp.Gauntlet.simplegfx;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridDirection;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 21/01/17.
 */
public class KeyboardInput implements KeyboardHandler, MouseHandler {

    Player player;
    Keyboard k;

    KeyboardEvent eventUpPressed;
    KeyboardEvent eventRightPressed;
    KeyboardEvent eventDownPressed;
    KeyboardEvent eventLeftPressed;

    KeyboardEvent eventUpReleased;
    KeyboardEvent eventRightReleased;
    KeyboardEvent eventDownReleased;
    KeyboardEvent eventLeftReleased;

    boolean upIsPressed;
    boolean rightIsPressed;
    boolean downIsPressed;
    boolean leftIsPressed;

    public KeyboardInput(Player player) {
        this.k = new Keyboard(this);
        this.player = player;
        keyboardInit(this.player);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                upIsPressed = true;
                //System.out.println("UP WAS PRESSED");
                break;
            case KeyboardEvent.KEY_RIGHT:
                rightIsPressed = true;
                //System.out.println("RIGHT WAS PRESSED");
                break;
            case KeyboardEvent.KEY_DOWN:
                downIsPressed = true;
                //System.out.println("DOWN WAS PRESSED");
                break;
            case KeyboardEvent.KEY_LEFT:
                leftIsPressed = true;
                //System.out.println("LEFT WAS PRESSED");
                break;
        }

        setPlayerDirection();
        //player.move();
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                upIsPressed = false;
                break;
            case KeyboardEvent.KEY_RIGHT:
                rightIsPressed = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                downIsPressed = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                leftIsPressed = false;
                break;
        }

        setPlayerDirection();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void setPlayerDirection() {

        if (!(upIsPressed && rightIsPressed && downIsPressed && leftIsPressed)) {
            player.setSpeed(0);
        }
/*
        if(upIsPressed && rightIsPressed) {
            player.setDirection(GridDirection.UPRIGHT);
            return;
        } else if(downIsPressed && rightIsPressed) {
            player.setDirection(GridDirection.DOWNRIGHT);
            return;
        } else if(downIsPressed && leftIsPressed) {
            player.setDirection(GridDirection.DOWNLEFT);
            return;
        } else if(upIsPressed && leftIsPressed) {
            player.setDirection(GridDirection.UPLEFT);
            return;
        } else*/
        if (upIsPressed) {
            player.setDirection(GridDirection.UP);
            return;
        }
        if (rightIsPressed) {
            player.setDirection(GridDirection.RIGHT);
            return;
        }
        if (downIsPressed) {
            player.setDirection(GridDirection.DOWN);
            return;
        }
        if (leftIsPressed) {
            player.setDirection(GridDirection.LEFT);
            return;
        }
    }

    public void keyboardInit(Player player) {

        this.player = player;

        // Sets all Keyboard Events
        eventUpPressed = new KeyboardEvent();
        eventRightPressed = new KeyboardEvent();
        eventDownPressed = new KeyboardEvent();
        eventLeftPressed = new KeyboardEvent();

        eventUpReleased = new KeyboardEvent();
        eventRightReleased = new KeyboardEvent();
        eventDownReleased = new KeyboardEvent();
        eventLeftReleased = new KeyboardEvent();

        eventUpPressed.setKey(KeyboardEvent.KEY_UP);
        eventRightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        eventDownPressed.setKey(KeyboardEvent.KEY_DOWN);
        eventLeftPressed.setKey(KeyboardEvent.KEY_LEFT);

        eventUpReleased.setKey(KeyboardEvent.KEY_UP);
        eventRightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        eventDownReleased.setKey(KeyboardEvent.KEY_DOWN);
        eventRightReleased.setKey(KeyboardEvent.KEY_RIGHT);

        eventUpPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventRightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventDownPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventLeftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        eventUpReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventRightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventDownReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventLeftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(eventUpPressed);
        k.addEventListener(eventRightPressed);
        k.addEventListener(eventDownPressed);
        k.addEventListener(eventLeftPressed);

        k.addEventListener(eventUpReleased);
        k.addEventListener(eventRightReleased);
        k.addEventListener(eventDownReleased);
        k.addEventListener(eventLeftReleased);
    }
}

