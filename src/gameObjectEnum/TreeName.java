package gameObjectEnum;

/**
 * Version 1.1
 * Author : Sofia
 **/

public enum TreeName {
    // TYPES

    // EMPTY
    EMPTY("empty"),

    // TREES
    OAK_TREE("oak tree");

    // FINAL
    private final String name;

    // CONSTRUCTOR
    TreeName(String pName) {
        this.name = pName;
    }

    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}