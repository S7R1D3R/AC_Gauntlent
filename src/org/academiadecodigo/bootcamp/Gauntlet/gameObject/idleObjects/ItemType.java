package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public enum ItemType {
    // TODO => GIULIANO
    // Health, Poison, End

    POTION(10),
    POISON(-10),
    PRINCESS(0),
    EXIT(0);

    private int value;

    ItemType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
