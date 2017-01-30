package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.Item;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 24/01/17.
 */
public class LevelMaker {

    private Grid grid;

    public LevelMaker(Grid grid) {
        this.grid = grid;
    }

    /**
     * LEVEL 1 STRING
     */
    private final String level1 =
                    "################################" +
                    "######__++######_______+#####__#" +
                    "#_____________##_________#_____#" +
                    "#___##_____##_##_######__#___#_#" +
                    "#_#_##__#####_#-_#*___#__##_##_#" +
                    "###_##__#_____#__#____#__##_####" +
                    "#____#__#____-#_-####_#_______##" +
                    "#EE__#__#___###_____#_#_______##" +
                    "#____#_##+__#___###_#_#__##____#" +
                    "#____#+#EE_#####____#_#__#___#_#" +
                    "#__#####___#_____####_#__#####_#" +
                    "#__#_______#_____#____#______#_#" +
                    "#__#_______####__#____#__##__#_#" +
                    "#__#_##########_+#____#__##__#X#" +
                    "#__#E____________####_#__##__###" +
                    "#__#-______#__#__#____#_###___##" +
                    "#P_#__####_#__#__#______###___##" +
                    "################################";


    /**
     * CHOOSE LEVEL NUMBER TO GENERATE CORRESPONDING LEVEL
     *
     * @param level number
     */


    public ArrayList<GameObject> getLevel(int level) {

        if (level == 1) {
            return generateLevel(level1);
        }
        return null;
    }

    /**
     * READS THE LEVEL STRING AND GENERATES LEVEL
     *
     * @param level in  predefined for of string
     * @return ArrayList an array list with all the gameobjects(each one with grid, pos, and gameobjtype
     */
    public ArrayList<GameObject> generateLevel(String level) {

        int roomWidth = 32;            //Room Width
        int roomHeight = 18;           //Room Height

        List<GameObject> gameObjects = new ArrayList<>();       //Level maker does not need to know how many gameobjects exist
        int charCount  = 0;

        for (int col = 0; col < roomHeight; col++) {
            for (int row = 0; row < roomWidth; row++) {

                GameObjType objType;       //game type to be used in gameobj factory below
                ItemType itemType = null;  //needs to be initialized, it isn't used in all cases
                String[] picsFileNames;

                if (level.charAt(charCount) != '_') {           //if symbol read doesn't correspond to free space

                    switch (level.charAt(charCount)) {          //changes type corresponding to symbol read
                        case '#':
                            objType = GameObjType.WALL;
                            picsFileNames = new String[]{"WallBlock.png"};
                            break;
                        case 'P':
                            objType = GameObjType.PLAYER;
                            picsFileNames = new String[]{"PlayerUp.png", "PlayerRight.png", "PlayerDown.png", "PlayerLeft.png"};
                            break;
                        case 'E':
                            objType = GameObjType.ENEMY;
                            picsFileNames = new String[]{"EnemyUp.png", "EnemyRight.png", "EnemyDown.png", "EnemyLeft.png"};
                            break;
                        case 'X':
                            objType = GameObjType.ITEM;
                            itemType = ItemType.EXIT;
                            picsFileNames = itemType.getPicFileName();
                            break;
                        case '+':
                            objType = GameObjType.ITEM;
                            itemType = ItemType.POTION;
                            picsFileNames = itemType.getPicFileName();
                            break;
                        case '-':
                            objType = GameObjType.ITEM;
                            itemType = ItemType.POISON;
                            picsFileNames = itemType.getPicFileName();
                            break;
                        case '*':
                            objType = GameObjType.ITEM;
                            itemType = ItemType.PRINCESS;
                            picsFileNames = itemType.getPicFileName();
                            break;
                        default:
                            throw new NullPointerException();
                    }


                    createAllObjects(gameObjects, row, col, objType, itemType, picsFileNames);
                }
            charCount++;
            }
        }
        return(ArrayList<GameObject>)gameObjects;     //returns gameObjects list
    }


    private void createAllObjects(List<GameObject> gameObjects, int row, int col, GameObjType objType, ItemType itemType, String[] picsFileNames) {

        //Creates new game object
        GameObject newGameObject = GameObjFactory.getNewGameObj(grid, objType, grid.makeGridPosition(row, col, picsFileNames));

        //Adds all itemtypes to all items
        if (objType == GameObjType.ITEM) {
            ((Item) newGameObject).setItemType(itemType);
        }

        //Displays new game object on graphic
        newGameObject.getPos().show();

        //Adds all new gameobjects to object list
        gameObjects.add(newGameObject);
    }
}



