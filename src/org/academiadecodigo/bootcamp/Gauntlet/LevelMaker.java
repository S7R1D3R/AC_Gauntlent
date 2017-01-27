package org.academiadecodigo.bootcamp.Gauntlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
                    "######E_++######EE_____+#####__#" +
                    "#_____________##_________#_____#" +
                    "#___##_____##_##_######__#___#E#" +
                    "#E#_##__#####_#-_#*___#__##_##E#" +
                    "###_##__#E____#__#____#__##_####" +
                    "#____#__#E___-#_-####_#_______##" +
                    "#____#__#___###_____#_#_______##" +
                    "#____#_##+__#_EE###_#_#__##____#" +
                    "#__EE#+#___#####____#_#__#___#_#" +
                    "#__#####___#_____####_#__#####_#" +
                    "#__#EE_____#EE___#____#______#_#" +
                    "#__#_______####__#____#__##__#_#" +
                    "#__#_##########_+#____#__##__#X#" +
                    "#__#______E______####_#__##__###" +
                    "#__#-______#EE#EE#____#_###___##" +
                    "#P_#__####E#EE#EE#______###___##" +
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

        for (int i = 0; i < roomHeight; i++) {
            for (int j = 0; j < roomWidth; j++) {

                GameObjType objType;       //game type to be used in gameobj factory below
                ItemType itemType = null;  //needs to be initialized, it isn't used in all cases
                String[] picsFileNames;

                if (level.charAt(charCount) != '_') {           //if symbol read doesn't correspond to free space

                    switch (level.charAt(charCount)) {          //changes type corresponding to symbol read
                        case '#':
                            objType = GameObjType.WALL;
                            picsFileNames = new String[]{"test/WallBlock.png"};
                            break;
                        case 'P':
                            objType = GameObjType.PLAYER;
                            picsFileNames = new String[]{"test/PlayerDown.png", "test/PlayerLeft.png", "test/PlayerUp.png", "test/PlayerRight.png"};
                            break;
                        case 'E':
                            objType = GameObjType.ENEMY;
                            picsFileNames = new String[]{"test/EnemyDown.png", "test/EnemyLeft.png", "test/EnemyUp.png", "test/EnemyRight.png"};
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


                    createAllObjects(gameObjects, j, i, objType, itemType, picsFileNames);
                }
            charCount++;
            }
        }
        return(ArrayList<GameObject>)gameObjects;     //returns gameObjects list
    }


    private void createAllObjects(List<GameObject> gameObjects, int i, int j, GameObjType objType, ItemType itemType, String[] picsFileNames) {

        //Creates new game object

        GameObject newGameObject = GameObjFactory.getNewGameObj(grid, objType, grid.makeGridPosition(i, j, picsFileNames));
        newGameObject.getPos().show();



        if (objType == GameObjType.ITEM) {
            //Adds all itemtypes to all items
            ((Item) newGameObject).setItemType(itemType);
        }

        //Adds all new gameobjects to object list
        gameObjects.add(newGameObject);
    }
}



