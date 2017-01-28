package org.academiadecodigo.bootcamp.Gauntlet.test;


import org.academiadecodigo.bootcamp.Gauntlet.Game;
import org.academiadecodigo.bootcamp.Gauntlet.LevelMaker;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

/**
 * Created by codecadet on 1/21/17.
 */
public class TestArea {

    public static void main(String[] args) {

        Game game = new Game(GridType.SIMPLE_GFX, 42, 18, 200);

        //Test grid initialization
        Grid grid = GameObjFactory.makeGrid(GridType.SIMPLE_GFX, 42, 18);
        grid.init();
        LevelMaker levelMaker = new LevelMaker(grid);          //Instances the level maker
        ArrayList<GameObject> gameObjects = levelMaker.getLevel(1);   //Creates the ArrayList with all the gameobjects using the level maker
        System.out.println(gameObjects.toString());


        //Testing method moveInDirection



//        game.init(1);


//        try {
//            game.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        // Test loading image
//        Picture picture2 = new Picture(10, 10, "test/GameBackground.png");
//        picture2.draw();
//
//        Picture picture = new Picture(10, 10, "test/End.png");
//        picture.draw();
    }
}
