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

    private KeyboardEvent eventUpPressed;
    private KeyboardEvent eventRightPressed;
    private KeyboardEvent eventDownPressed;
    private KeyboardEvent eventLeftPressed;

    private KeyboardEvent eventUpReleased;
    private KeyboardEvent eventRightReleased;
    private KeyboardEvent eventDownReleased;
    private KeyboardEvent eventLeftReleased;

    private boolean upPressed;
    private boolean rightPressed;
    private boolean downPressed;
    private boolean leftPressed;

    public KeyboardInput(Player player) {
        this.k = new Keyboard(this);
        this.player = player;
        keyboardInit(this.player);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                upPressed = true;
                //System.out.println("UP WAS PRESSED");
                break;
            case KeyboardEvent.KEY_RIGHT:
                rightPressed = true;
                //System.out.println("RIGHT WAS PRESSED");
                break;
            case KeyboardEvent.KEY_DOWN:
                downPressed = true;
                //System.out.println("DOWN WAS PRESSED");
                break;
            case KeyboardEvent.KEY_LEFT:
                leftPressed = true;
                //System.out.println("LEFT WAS PRESSED");
                break;
        }

        setPlayerDirection();
        player.setNextPos();
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                upPressed = false;
                break;
            case KeyboardEvent.KEY_RIGHT:
                rightPressed = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                downPressed = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                leftPressed = false;
                break;
        }

        setPlayerDirection();
        player.setNextPos();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void setPlayerDirection() {

        if (upPressed) {
            player.setDirection(GridDirection.UP);
            return;
        }
        if (rightPressed) {
            player.setDirection(GridDirection.RIGHT);
            return;
        }
        if (downPressed) {
            player.setDirection(GridDirection.DOWN);
            return;
        }
        if (leftPressed) {
            player.setDirection(GridDirection.LEFT);
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

