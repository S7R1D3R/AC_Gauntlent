package Menu;

import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;
import org.academiadecodigo.bootcamp.Gauntlet.test.Game;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 24/01/17.
 */
public class SimpleGFXMenu extends AbstractMenu {

    private Picture menuCanvas;
    private Picture showingWindow;
    private Rectangle highlight;

    public SimpleGFXMenu() {

    }

    @Override
    public void start() {

        Game game = new Game(GridType.SIMPLE_GFX, 40, 40, 200);
        game.init();
    }

    @Override
    public void multiplayer() {
        // O Game vai ter mais um constructor que quando recebe mais um inteiro, faz um segundo player.
        System.out.println("Multiplayer is unavailable yet.");
    }

    @Override
    public void instructions() {
        // Define a showingWindow como a imagem de instruções.
    }

    @Override
    public void makeMap() {
        // Vai permitir construir um mapa, fazendo um .txt ou arrastando os items.
    }

    @Override
    public void quit() {
        // Sai do jogo

        System.exit(1);
    }
}
