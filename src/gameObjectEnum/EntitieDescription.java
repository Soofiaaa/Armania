package gameObjectEnum;

/**
 * Version 1.2
 * Author : Sofia
 **/

public enum EntitieDescription {
    // TYPES

    // EMPTY
    EMPTY("An empty space with nothing on it."),

    // ENTITIES
    CASTLE_WALL("A wall from a castle."),
    FOUNTAIN("A fountain that splash water."),
    MAGICAL_FOUNTAIN("A magical fountain that might contain something in it."),

    // TREES
    TREE("A tree is the default tree.\n By cutting them you gain 25 xp in wood cutting and get an oak log."),
    OAK_TREE("An oak tree is a small tree.\nYou can cut if you have level 15 in wood cutting and gain 37.5 xp in wood cutting and get an oak log."),
    HACKBERRY_TREE("A hackberry tree is a beautiful tree that contains different color on the leaf.\nYou can cut if you have level 20 in wood cutting and gain 32 xp in wood cutting and get a hackberry log.");

    // FINAL
    private final String name;

    // CONSTRUCTOR
    EntitieDescription(String pName) {
        this.name = pName;
    }

    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}