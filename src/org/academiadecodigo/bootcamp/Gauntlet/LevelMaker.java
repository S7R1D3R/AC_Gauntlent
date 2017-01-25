package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by codecadet on 24/01/17.
 */
public class LevelMaker {

    private GridPosition[] objectInitPositions;
    private GameObjType[] objectTypes;
    private Grid grid;
    private int roomWidth = 32;
    private int roomHeight = 18;
    private int numGameObjects;

    public LevelMaker(Grid grid, int level) {
        this.grid = grid;
        chooseLevel(level);
    }

    /**
     * LEVEL 1 STRING
     */
    private String level1 =
            "################################" +
                    "######____######________#####__#" +
                    "#_____________##_________#_____#" +
                    "#___##_____##_##_######__#___#E#" +
                    "#E#_##__#####_#__#I___#__##_##E#" +
                    "###_##__#_____#__#____#__##_####" +
                    "#____#__#_____#__####_#_______##" +
                    "#____#__#___###_____#_#_______##" +
                    "#____#_##___#___###_#_#__##____#" +
                    "#____#I#___#####____#_#__#___#_#" +
                    "#__#####___#_____####_#__#####_#" +
                    "#__#_______#_____#____#______#_#" +
                    "#__#_______####__#____#__##__#_#" +
                    "#__#_##########__#____#__##__#X#" +
                    "#__#_____________####_#__##__###" +
                    "#__#_______#__#__#____#_###___##" +
                    "#P_#__####_#__#__#______###___##" +
                    "################################";


    /**
     * CHOOSE LEVEL NUMBER TO GENERATE CORRESPONDING LEVEL
     *
     * @param level number
     */


    public void chooseLevel(int level) {
        switch (level) {
            case 1:
                generateLevel(level1);
        }
    }

    /**
     * READS THE LEVEL STRING AND GENERATES LEVEL
     *
     * @param level string representing gameobjects' positions
     */

    private void generateLevel(String level) {

        getNumGameObjects(level);

        this.objectInitPositions = new GridPosition[this.numGameObjects];
        this.objectTypes = new GameObjType[this.numGameObjects];
        int index = 0;

        for (int i = 0; i < roomHeight; i++) {
            for (int j = 0; j < roomWidth; j++) {

                if (level.charAt(i) != '_') {

                    objectInitPositions[index] = grid.makeGridPosition(j, i);
                    switch (level.charAt(i)) {
                        case '#':
                            objectTypes[index] = GameObjType.WALL;
                            break;
                        case 'P':
                            objectTypes[index] = GameObjType.PLAYER;
                            break;
                        case 'E':
                            objectTypes[index] = GameObjType.ENEMY;
                            break;
                        case 'X':
                            objectTypes[index] = GameObjType.EXIT;
                            break;
                        case '+':
                            objectTypes[index] = GameObjType.POTION;
                            break;
                        case '-':
                            objectTypes[index] = GameObjType.POISON;
                            break;
                        case '*':
                            objectTypes[index] = GameObjType.PRINCESS;
                            break;

                    }
                    index++;
                }
            }

        }

    }

    public GridPosition[] getObjectInitPositions() {
        return objectInitPositions;
    }

    public GameObjType[] getObjectTypes() {
        return objectTypes;
    }

    private void getNumGameObjects(String level) {

        for (int i = 0; i < level.length() ; i++) {

            if(level.charAt(i) != '_') {
                this.numGameObjects++;
            }
        }
    }
}
