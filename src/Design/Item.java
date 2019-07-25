package Design;

public class Item {

    private final itemSlot slot;
    private final String name;
    private final int hitPoints;
    private final int mana;
    private final int strength;
    private final int dexterity;
    private final int intelligence;

    private final int dropChance;

    public Item(itemSlot slot, String name, int dropChance, int hitPoints, int mana, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.slot = slot;
        this.dropChance = dropChance;
        this.hitPoints = hitPoints;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;

        //TODO:skill bonus
    }

    public itemSlot getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }
}