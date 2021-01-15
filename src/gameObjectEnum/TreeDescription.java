package gameObjectEnum;

/**
 * Version 1.1
 * Author : Sofia
 **/

public enum TreeDescription {
    // TYPES

    // EMPTY
    EMPTY("An empty space."),

    // TREES
    OAK_TREE("Oak tree are the default tree. By cutting them you gain 25 xp in wood cutting.");

    // FINAL
    private final String name;

    // CONSTRUCTOR
    TreeDescription(String pName) {
        this.name = pName;
    }

    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}
