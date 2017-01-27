package org.academiadecodigo.bootcamp.Gauntlet.Menu;

/**
 * Created by codecadet on 24/01/17.
 */
public abstract class AbstractMenu implements iMenu {

    @Override
    public void chooseOption(MenuOptions option) {

        switch (option) {

            case START:
                start();
                break;
            case MULTIPLAYER:
                multiplayer();
                break;
            case INSTRUCTIONS:
                instructions();
                break;
            case MAKEMAP:
                makeMap();
                break;
            case QUIT:
                quit();
                break;
        }
    }
}
