package gameObjectEnum;

/**
 * Version 1.2
 * Author : Sofia
 **/

public enum SkillName {
    // TYPES

    // WOOD CUTTING
    WOODCUTTING("wood cutting");

    // FINAL
    private final String name;

    // CONSTRUCTOR
    SkillName(String pName) {
        this.name = pName;
    }

    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}