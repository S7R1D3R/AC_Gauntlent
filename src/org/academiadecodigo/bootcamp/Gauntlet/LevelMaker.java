package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by codecadet on 24/01/17.
 */
public class LevelMaker {

    public static GridPosition[] objectInitPositions;
    public static GameObjType[] objectTypes;
    private Grid grid;
    private int roomWidth = 32;
    private int roomHeight = 18;

    public LevelMaker(Grid grid) {
        this.grid = grid;
    }

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
                    "#__#_##########__#____#__##__#I#" +
                    "#__#_____________####_#__##__###" +
                    "#__#_______#__#__#____#_###___##" +
                    "#P_#__####_#__#__#______###___##" +
                    "################################";


    public String getLevel1() {
        return level1;
    }


    public void chooseLevel(int level) {
        switch (level) {
            case 1:
                generateLevel(level1);
        }
    }


    private void generateLevel(String level) {

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
                        case 'I':
                            objectTypes[index] = GameObjType.ITEM;
                            break;
                        case 'E':
                            objectTypes[index] = GameObjType.ENEMY;
                            break;

                    }
                index++;
                }
            }

        }
    }
}
