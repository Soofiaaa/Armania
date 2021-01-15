package gameObject;

import audio.Audio;
import gameObjectEnum.EntitieDescription;
import gameObjectEnum.EntitieName;

import java.util.concurrent.TimeUnit;

/**
 * Version 1.2
 * Author : Sofia
 **/

public class Entities implements Runnable, java.io.Serializable {
    // VARIABLES
    private EntitieName name;
    private EntitieDescription description;
    private short levelNeeded;
    private short health;
    private short defaultHealth;
    private Items drop;
    private short dropTime;
    private short xp;
    private Entities entity;
    private Audio audio = new Audio();

    // NUMBERS
    private short number1;
    private short number2;
    private short number3;
    private short number4;

    // CONSTRUCTORS

    // DEFAULT
    public Entities() {
    }

    public Entities(Entities entities) {
        this.entity = entities;
    }

    // OBJECT
    public Entities(EntitieName pName, EntitieDescription pDescription) {
        this.name = pName;
        this.description = pDescription;
    }

    // TREE
    public Entities(EntitieName pName, EntitieDescription pDesc, short pLevelNeeded, short pHealth, short pDefaultHealth, Items pDrop, short pDropTime, short pXp) {
        this.name = pName;
        this.description = pDesc;
        this.levelNeeded = pLevelNeeded;
        this.health = pHealth;
        this.defaultHealth = pDefaultHealth;
        this.drop = pDrop;
        this.dropTime = pDropTime;
        this.xp = pXp;
    }

    // GETS
    public EntitieName getName() {
        return this.name;
    }

    public EntitieDescription getDescription() {
        return this.description;
    }

    public short getHealth() {
        return this.health;
    }

    public short getDefaultHealth() {
        return this.defaultHealth;
    }

    public Items getDrop() {
        return this.drop;
    }

    public short getDropTime() {
        return this.dropTime;
    }

    public short getXp() {
        return this.xp;
    }

    // SETS
    public void setName(EntitieName pName) {
        this.name = pName;
    }

    public void setDescription(EntitieDescription pDescription) {
        this.description = pDescription;
    }

    public void setHealth(short pHealth) {
        this.health = pHealth;
    }

    public void setDefaultHealth(short pDefaultHealth) {
        this.defaultHealth = pDefaultHealth;
    }

    public void setDrop(Items pDrop) {
        this.drop = pDrop;
    }

    public void setDropTime(short pDropTime) {
        this.dropTime = pDropTime;
    }

    public void setXp(short pXp) {
        this.xp = pXp;
    }

    // METHODS
    public void woodCuttingMessage(Entities pTree, Inventory pInventory, SkillTable pSKillTable) {
        byte number = (byte) (Math.random() * (4 - 1 + 1) + 1);
        pInventory.addItem(pTree.drop);
        pSKillTable.addWoodCuttingXp(pTree.xp);
        pSKillTable.updateLevel();
        switch (number) {
            case 1 -> audio.playSFX("sfx/woodCutting/woodToInventory_sfx.wav", 1.0);
            case 2 -> audio.playSFX("sfx/woodCutting/woodToInventory2_sfx.wav", 1.0);
            case 3 -> audio.playSFX("sfx/woodCutting/woodToInventory3_sfx.wav", 1.0);
            case 4 -> audio.playSFX("sfx/woodCutting/woodToInventory4_sfx.wav", 1.0);
        }
        System.out.println("You received " + pTree.getDrop() + " and " + pTree.getXp() + " xp.");
    }

    public void cutTree(Map pMap, Inventory pInventory, SkillTable pSkillTable) throws InterruptedException {
        Entities pTree = pMap.getPlace();
        Items pItem = pInventory.findAxe();

        if (pTree.getName() == pMap.getTree().getName() || pTree.getName() == pMap.getOakTree().getName() || pTree.getName() == pMap.getHackberryTree().getName()) {
            if (pSkillTable.getWoodCuttingLevel() >= pTree.levelNeeded) {
                if (pTree.health == pTree.defaultHealth) {
                    if (pItem == pInventory.getWoodenAxe() || pItem == pInventory.getStoneAxe()) {
                        while (pTree.getHealth() > 0) {
                            pTree.health = (short) (pTree.health - pItem.getDamage());
                            TimeUnit.MILLISECONDS.sleep(600);
                            audio.playSFX("sfx/woodCutting/woodCutting_sfx.wav", 0.45);
                            System.out.println("The tree has now : " + pTree.health + " hp.");
                            if (pTree.dropTime == 3) {
                                number1 = (short) (Math.random() * (50) + 1);
                                number2 = (short) (Math.random() * (50) + 1);
                                if (pTree.health == number1 || pTree.health == number2) {
                                    pTree.woodCuttingMessage(pTree, pInventory, pSkillTable);
                                }
                            }
                        }
                        if (pTree.health == 0) {
                            pTree.woodCuttingMessage(pTree, pInventory, pSkillTable);
                            audio.playSFX("sfx/woodCutting/deadTree_sfx.wav", 1.0);
                        }
                        Thread t1 = new Thread(createRunnable(pMap));
                        t1.start();
                    } else {
                        System.out.println("You don't have an axe.");
                    }
                } else {
                    System.out.println("You can't cut this tree.");
                }
            } else {
                System.out.println("Your wood cutting level is too low to cut this tree.");
            }
        } else {
            System.out.println("You are not on a tree.");
        }
    }

    // RUN
    private Runnable createRunnable(final Map pMap) {
        return () -> {
            Entities pTree = pMap.getPlace();
            try {
                System.out.println("The " + pTree.name + " will respawn " + (5000 / 1000) + " s\n> ");
                Thread.sleep(5000);
                pTree.health = pTree.defaultHealth;
                System.out.println(pTree.name + " is back.\n> ");
            } catch (Exception ignored) {
            }
        };
    }

    // TO STRING
    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public void run() {
    }
}