package gameObject;

import gameObjectEnum.SkillDescription;
import gameObjectEnum.SkillName;

/**
 * Version 1.2
 * Author : Sofia
 **/

public class Skills implements java.io.Serializable {
    // VARIABLES
    private SkillName name;
    private SkillDescription description;

    // CONSTRUCTOR

    // WOOD CUTTING
    public Skills(SkillName pName, SkillDescription pDescription) {
        this.name = pName;
        this.description = pDescription;
    }

    // GETS
    public SkillName getName() {
        return this.name;
    }

    public SkillDescription getDescription() {
        return this.description;
    }

    // SETS
    public void setName(SkillName pName) {
        this.name = pName;
    }

    public void setDescription(SkillDescription pDescription) {
        this.description = pDescription;
    }

    // TO STRING
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}