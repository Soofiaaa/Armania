package gameObject;

import gameObjectEnum.SkillDescription;
import gameObjectEnum.SkillName;

/**
 * Version 1.2
 * Author : Sofia
 **/

public class SkillTable implements java.io.Serializable {
    // VARIABLES
    private Skills[] skillTable;
    private short woodCuttingXP;
    private short woodCuttingLevel = 1;
    private double xpNeeded;
    private short newXp;

    // SKILLS
    private Skills woodCutting = new Skills(SkillName.WOODCUTTING, SkillDescription.WOODCUTTING);

    // CONSTRUCTOR
    public SkillTable() {
        skillTable = new Skills[1];
        skillTable[0] = woodCutting;
    }

    // GETS
    public String getSkillTable() {
        String strSkillTable = "";
        byte number = 0;

        for (byte i = 0; i < skillTable.length; i++) {
            strSkillTable += ++number + " -> " + skillTable[i];
            if (number == skillTable.length - 1) {
                strSkillTable += "\n";
            }
        }
        return strSkillTable;
    }

    public short getWoodCuttingXP() {
        return this.woodCuttingXP;
    }

    public short getWoodCuttingLevel() {
        return this.woodCuttingLevel;
    }

    // SETS
    public void setWoodCuttingXP(short pXp) {
        this.woodCuttingXP = pXp;
    }

    public void setWoodCuttingLevel(short pLevel) {
        this.woodCuttingLevel = pLevel;
    }

    // METHODS
    public void addWoodCuttingXp(short pXp) {
        woodCuttingXP += pXp;
        newXp += pXp;
    }

    public void updateLevel(){
        if(hasEnoughXPForNextLevel()){
            this.woodCuttingLevel++;
            newXp = 0;
            System.out.println("You are now level " + woodCuttingLevel + ".");
        }
    }

    private boolean hasEnoughXPForNextLevel() {
        if (this.woodCuttingLevel == 1) {
            xpNeeded = 83;
        } else if (woodCuttingLevel >= 2 && woodCuttingLevel <= 99) {
            xpNeeded = Math.floor(((this.woodCuttingLevel - 1) + 300 * (Math.pow(2D, ((this.woodCuttingLevel - 1) / 7D)))) / 4);
        }
        return newXp >= xpNeeded;
    }
}