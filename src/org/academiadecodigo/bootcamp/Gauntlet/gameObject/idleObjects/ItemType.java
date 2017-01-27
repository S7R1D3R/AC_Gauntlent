package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public enum ItemType {
    // Health, Poison, End

    POTION(10, "Potion.png"),
    POISON(-10, "Poison.png"),
    TREASURE(20, "Treasure.png"),
    PRINCESS(0, "Princess.png"),
    EXIT(0, "End.png");

    private int value;
    private String[] picFileName = new String[1];

    ItemType(int value, String picFileName){
        this.value = value;
        this.picFileName[0] = picFileName;
    }

    public int getValue() {
        return value;
    }

    public String[] getPicFileName() {
        return picFileName;
    }

}
