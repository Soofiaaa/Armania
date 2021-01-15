package gameObjectEnum;

/**
 * Version 1.2
 * Author : Sofia
 **/

public enum EntitieName {
    // TYPES

    // EMPTY
    EMPTY("empty"),

    // ENTITIES
    CASTLE_WALL("wall of castle"),
    FOUNTAIN("fountain"),
    MAGICAL_FOUNTAIN("magical fountain"),

    // TREES
    TREE("tree"),
    OAK_TREE("oak tree"),
    HACKBERRY_TREE("hackberry tree");

    // FINAL
    private final String name;

    // CONSTRUCTOR
    EntitieName(String pName) {
        this.name = pName;
    }

    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}