package gameObjectEnum;

/**
 * Version 1.2
 * Author : Sofia
 **/

public enum SkillDescription {
    // TYPES

    // WOOD CUTTING
    WOODCUTTING("wood cutting is skill who can be level up by cutting trees.");

    // FINAL
    private final String name;

    // CONSTRUCTOR
    SkillDescription(String pName) {
        this.name = pName;
    }

    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}