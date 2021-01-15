package gameObject;

import gameObjectEnum.ItemDescription;
import gameObjectEnum.ItemName;

/**
 * Version 1.2
 * Author : Sofia
 **/

public class Items implements java.io.Serializable {
    // VARIABLES
    private ItemName name;
    private ItemDescription description;
    private int damage;

    // CONSTRUCTOR

    // ITEM
    public Items(ItemName pName, ItemDescription pDescription) {
        this.name = pName;
        this.description = pDescription;
    }

    // WEAPON
    public Items(ItemName pName, ItemDescription pDescription, int pDamage) {
        this.name = pName;
        this.description = pDescription;
        this.damage = pDamage;
    }

    // GETS
    public ItemName getName() {
        return this.name;
    }

    public ItemDescription getDescription() {
        return this.description;
    }

    public int getDamage() {
        return damage;
    }

    // SETS
    public void setName(ItemName pName) {
        this.name = pName;
    }

    public void setDescription(ItemDescription pDescription) {
        this.description = pDescription;
    }

    public void setDamage(int pDamage) {
        this.damage = pDamage;
    }

    // To String
    @Override
    public String toString() {
        return String.valueOf(name);
    }
}