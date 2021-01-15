package gameObjectEnum;

/**
 * Version 1.2
 * Author : Sofia
 **/

public enum ItemDescription {
    // TYPES

    // EMPTY
    EMPTY("An empty slot."),

    // WEAPONS
    // SWORDS
    WOODEN_SWORD("The wooden sword is the default sword. It does a damage of"),
    STONE_SWORD("The stone sword is the second sword you can get at level"),

    // AXES
    WOODEN_AXE("The wooden axe is the default axe. It does a damage of "),
    STONE_AXE("The stone axe can be handle at level 10 in wood cutting. It does a damage of "),

    // WOODS
    // LOGS
    TREE_LOG("A log that can be obtain by cutting a tree."),
    OAK_LOG("An oak log that can be obtain by cutting an oak tree."),
    HACKBERRY_LOG("A hackberry log that can be obtain by cutting a hackberry tree.");

    // FINAL
    private final String name;

    // CONSTRUCTOR
    ItemDescription(String pName) {
        this.name = pName;
    }

    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}