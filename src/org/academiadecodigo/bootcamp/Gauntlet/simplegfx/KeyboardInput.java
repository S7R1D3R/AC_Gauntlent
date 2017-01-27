package org.academiadecodigo.bootcamp.Gauntlet.simplegfx;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
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
    KeyboardEvent eventUp;
    KeyboardEvent eventUpRight;
    KeyboardEvent eventRight;
    KeyboardEvent eventDownRight;
    KeyboardEvent eventDown;
    KeyboardEvent eventDownLeft;
    KeyboardEvent eventLeft;
    KeyboardEvent eventUpLeft;

    boolean upIsPressed;
    boolean RightIsPressed;
    boolean DownIsPressed;
    boolean LeftIsPressed;

    public KeyboardInput() {
        this.k = new Keyboard(this);
        keyboardInit();
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {








        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

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
        eventUp = new KeyboardEvent();
        eventUpRight = new KeyboardEvent();
        eventRight = new KeyboardEvent();
        eventDownRight = new KeyboardEvent();
        eventDown = new KeyboardEvent();
        eventDownLeft = new KeyboardEvent();
        eventLeft = new KeyboardEvent();
        eventUpLeft = new KeyboardEvent();

        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUpRight.setKey(KeyboardEvent.KEY_UP + KeyboardEvent.KEY_RIGHT);
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventDownRight.setKey(KeyboardEvent.KEY_DOWN + KeyboardEvent.KEY_RIGHT);
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDownLeft.setKey(KeyboardEvent.KEY_DOWN + KeyboardEvent.KEY_LEFT);
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventUpLeft.setKey(KeyboardEvent.KEY_UP + KeyboardEvent.KEY_LEFT);

        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventUpRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventDownRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventDownLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventUpLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(eventUp);
        k.addEventListener(eventUpRight);
        k.addEventListener(eventRight);
        k.addEventListener(eventDownRight);
        k.addEventListener(eventDown);
        k.addEventListener(eventDownLeft);
        k.addEventListener(eventLeft);
        k.addEventListener(eventUpLeft);
    }
}

