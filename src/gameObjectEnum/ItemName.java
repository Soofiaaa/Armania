package gameObjectEnum;

/**
 * Version 1.2
 * Author : Sofia
 **/

public enum ItemName {
    // TYPES

    // EMPTY
    EMPTY("empty"),

    // WEAPONS
    // SWORDS
    WOODEN_SWORD("wooden sword"),
    STONE_SWORD("stone sword"),

    // AXES
    WOODEN_AXE("wooden axe"),
    STONE_AXE("stone axe"),

    // WOODS
    // LOGS
    TREE_LOG("log"),
    OAK_LOG("oak log"),
    HACKBERRY_LOG("hackberry log");

    // FINAL
    private final String name;

    // CONSTRUCTOR
    ItemName(String pName) {
        this.name = pName;
    }

    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}