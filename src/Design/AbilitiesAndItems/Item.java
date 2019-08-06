package Design.AbilitiesAndItems;

import java.util.List;

public class Item {

    private final itemSlot slot;
    private final String name;
    private final int levelRequirement;
    private final int hitPoints;
    private final int mana;
    private final int strength;
    private final int dexterity;
    private final int intelligence;

    private final int dropChance;

    public Item(itemSlot slot, String name,int levelRequirement, int dropChance, int hitPoints, int mana, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.slot = slot;
        this.levelRequirement = levelRequirement;
        this.dropChance = dropChance;
        this.hitPoints = hitPoints;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
//item declaration example
        //Item BattleAxe (HANDS,"Battle Axe",0,0,5,0,0)
        //Item ScalpelDagger (HANDS,"Scalpel",0,0,0,5,0)
        //Item TomeOfWisdom (HANDS,"Tome of Wisdom",0,10,0,0,5)
        //Item PeasantCap (HEAD,"Peasant Hat",2,0,1,0,-1)
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

    public static List<Item> availableItems () {
        Item BattleAxe = new Item(itemSlot.HANDS,"Battle Axe",1,0,0,0,5,0,0);
        availableItems().add(BattleAxe);
        Item Scalpel = new Item(itemSlot.HANDS,"Scalpel",1,0,0,0,0,5,0);
        availableItems().add(Scalpel);
        Item TomeOfWisdom = new Item(itemSlot.HANDS,"Tome of Wisdom",1,0,0,3,0,0,5);
        availableItems().add(TomeOfWisdom);
        Item PeasantCap = new Item(itemSlot.HEAD,"Peasant Cap",1,0,5,0,0,0,-1);
        availableItems().add(PeasantCap);
        Item ChainMail = new Item(itemSlot.CHEST,"Chain Mail",1,0,10,0,0,-2,0);
        availableItems().add(ChainMail);
        Item AgileShoes = new Item(itemSlot.FEET,"Agile Shoes",1,0,3,0,0,2,0);
        availableItems().add(AgileShoes);
        Item ShoulderGenie = new Item(itemSlot.SHOULDERS,"Shoulder Genie",5,0,10,15,0,0,10);
        availableItems().add(ShoulderGenie);
        Item LeatherPants = new Item(itemSlot.LEGS,"Leather Pants",1,0,5,0,0,10,0);
        availableItems().add(LeatherPants);
        return availableItems();
    }
}
