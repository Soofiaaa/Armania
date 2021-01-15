package gameObjectEnum;

/**
 * Version 1.2
 * Author : Sofia
 **/

public enum ItemDamage {
    // TYPES

    // SWORDS
    WOODEN_SWORD(3),
    STONE_SWORD(4),

    // AXES
    WOODEN_AXE(1),
    STONE_AXE(2);

    // FINAL
    private final int damage;

    ItemDamage(int value) {
        this.damage = value;
    }

    public String toString() {
        return String.valueOf(damage);
    }
}