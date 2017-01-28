package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Item extends GameObject {
    ItemType itemType;                  // Defines what behaviour the item will have


    public Item(Grid grid, GridPosition position) {
        super(grid, position, GameObjType.ITEM);

    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType){
        this.itemType = itemType;
    }

}
