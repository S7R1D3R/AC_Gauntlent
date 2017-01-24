package Menu;

/**
 * Created by codecadet on 24/01/17.
 */
public interface iMenu {

    /**
     *  MENU
     */
    void chooseOption(MenuOptions option);

    /**
     *  STARTS THE GAME
     */
    void start();


    /**
     * STARTS THE GAME WITH 2 PLAYERS
     */
    void multiplayer();

    /**
     *  SHOWS THE GAME INSTRUCTIONS
     */
    void instructions();

    /**
     *  OPEN THE MAP EDITOR
     */
    void makeMap();

    /**
     *  QUITS THE GAME
     */
    void quit();

}
