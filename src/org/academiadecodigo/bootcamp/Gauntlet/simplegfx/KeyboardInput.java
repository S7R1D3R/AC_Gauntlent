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

    private Player player;
    private Keyboard k;


    private boolean upPressed;
    private boolean rightPressed;
    private boolean downPressed;
    private boolean leftPressed;

    public KeyboardInput(Player player) {

        this.k = new Keyboard(this);
        this.player = player;
        keyboardInit();
    }

    @Override
    public void keyPressed(KeyboardEvent e) {


        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                player.setDirection(GridDirection.UP);
                upPressed = true;
                break;
            case KeyboardEvent.KEY_DOWN:
                player.setDirection(GridDirection.DOWN);
                downPressed = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                player.setDirection(GridDirection.LEFT);
                leftPressed = true;
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.setDirection(GridDirection.RIGHT);
                rightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                upPressed = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                downPressed = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                leftPressed = false;
                break;
            case KeyboardEvent.KEY_RIGHT:
                rightPressed = false;
                break;
        }

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void movePlayer() {
        //if()
    }

    public void keyboardInit() {

        // Sets all Keyboard Events
        KeyboardEvent eventUp = new KeyboardEvent();
        KeyboardEvent eventUpRelease = new KeyboardEvent();
        KeyboardEvent eventRight = new KeyboardEvent();
        KeyboardEvent eventRightRelease = new KeyboardEvent();
        KeyboardEvent eventDown = new KeyboardEvent();
        KeyboardEvent eventDownRelease = new KeyboardEvent();
        KeyboardEvent eventLeft = new KeyboardEvent();
        KeyboardEvent eventLeftRelease = new KeyboardEvent();

        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventUpRelease.setKey(KeyboardEvent.KEY_UP);
        eventRightRelease.setKey(KeyboardEvent.KEY_RIGHT);
        eventDownRelease.setKey(KeyboardEvent.KEY_DOWN);
        eventLeftRelease.setKey(KeyboardEvent.KEY_LEFT);

        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventUpRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventRightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventDownRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventLeftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(eventUp);
        k.addEventListener(eventRight);
        k.addEventListener(eventDown);
        k.addEventListener(eventLeft);
        k.addEventListener(eventUpRelease);
        k.addEventListener(eventRightRelease);
        k.addEventListener(eventDownRelease);
        k.addEventListener(eventLeftRelease);


//        eventUpLeft = new KeyboardEvent();
//        eventUpRight = new KeyboardEvent();
//        eventDownRight = new KeyboardEvent();
//        eventDownLeft = new KeyboardEvent();
//
//        eventDownLeft.setKey(KeyboardEvent.KEY_DOWN + KeyboardEvent.KEY_LEFT);
//        eventDownRight.setKey(KeyboardEvent.KEY_DOWN + KeyboardEvent.KEY_RIGHT);
//        eventUpLeft.setKey(KeyboardEvent.KEY_UP + KeyboardEvent.KEY_LEFT);
//        eventUpRight.setKey(KeyboardEvent.KEY_UP + KeyboardEvent.KEY_RIGHT);
//
//        eventDownRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
//        eventUpRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
//        eventDownLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
//        eventUpLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
//
//        k.addEventListener(eventUpRight);
//        k.addEventListener(eventDownRight);
//        k.addEventListener(eventDownLeft);
//        k.addEventListener(eventUpLeft);
    }
}
}

