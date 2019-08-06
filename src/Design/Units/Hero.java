package Design.Units;

import Design.AbilitiesAndItems.Ability;
import Design.AbilitiesAndItems.AbilityType;
import Design.AbilitiesAndItems.Heal;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero
{
    private final int BASE_HP = 10;



    //stats
    private int hitPoints;
    private int mana;
    private int strength;   //melee damage
    private int dexterity;  //ranged damage, dodge chance, hit chance
    private int intelligence; //spell power, initiative
    private int level;

    private List<Ability> activeAbilities = new ArrayList<>();
//    private List<Item> inventory = new ArrayList<>();
//    private EnumMap<itemSlot,Item> equipment = new EnumMap<itemSlot,Item>(itemSlot.class);


    public Hero(int level, int hitPoints, int mana, int strength, int dexterity, int intelligence){
        this.level = level;
        this.hitPoints = hitPoints;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    Hero cloneHero(){
        //TODO: get all the attributes of this hero and clone them into the new one
        Hero copy;
        if(this instanceof Fighter){
            copy = new Fighter(this.level, this.hitPoints, this.mana, this.strength, this.dexterity, this.intelligence);
            copy.activeAbilities = this.activeAbilities;
            return copy;
        }
        else if(this instanceof Mage){
            copy = new Mage(this.level, this.hitPoints, this.mana, this.strength, this.dexterity, this.intelligence);
            copy.activeAbilities = this.activeAbilities;
            return copy;
        }
        else{
            copy = new Ranger(this.level, this.hitPoints, this.mana, this.strength, this.dexterity, this.intelligence);
            copy.activeAbilities = this.activeAbilities;
            return copy;
        }
    }

    int getHP(){ return hitPoints;}

    void setHP(int amount) { hitPoints = amount; }

    int getDexterity(){ return dexterity;}


    public void enableAbility(Ability a){
        //TODO: verifica in Player
        activeAbilities.add(a);
    }

    public void disableAbility(Ability a){
    }

    public Ability getActiveAbility(int index){
        return activeAbilities.get(index);
    }

    public void setActiveAbility(int index, Ability a){
        activeAbilities.set(index, a);
    }

    public List<AbilityType> compatibleAbilities(){
        return null;
    }

    int getLevel(){
        return level;
    }

    boolean isHealer(){
        for(Ability a : activeAbilities){
            if(a instanceof Heal)
                return true;
        }
        return false;
    }



//    void equipItem(Item item){
//        if(equipment.get(item.getSlot())!=null){
//            this.unequipItem(equipment.get(item.getSlot()));
//        }
//
//        equipment.put(item.getSlot(),item);
//        hitPoints += item.getHitPoints();
//        mana += item.getMana();
//        strength += item.getStrength();
//        dexterity += item.getDexterity();
//        intelligence += item.getIntelligence();
//    }
//
//    void unequipItem(Item item){
//        if(this.checkHasItem(item)) {
//            equipment.remove(item.getSlot());
//            hitPoints -= item.getHitPoints();
//            mana -= item.getMana();
//            strength -= item.getStrength();
//            dexterity -= item.getDexterity();
//            intelligence -= item.getIntelligence();
//        }
//        else System.out.println(item.getName() +"is not equipped!");
//    }

//    boolean checkHasItem(Item item){
//        if(equipment.get(item.getSlot()).equals(item)) return true;
//        return false;
//    }

}
