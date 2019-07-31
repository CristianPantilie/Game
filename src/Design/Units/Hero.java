package Design.Units;

import Design.Abilities.Ability;

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

    Hero(int level){
        this.level = level;
        hitPoints = BASE_HP * level;
    }

    Hero cloneHero(){
        //TODO: get all the attributes of this hero and clone them into the new one
        if(this instanceof Fighter){
            return new Fighter(this.level);
        }
        else if(this instanceof Mage){
            return new Mage(this.level);
        }
        else{
            return new Ranger(this.level);
        }
    }

    int getHP(){ return hitPoints;}

    void setHP(int amount) { hitPoints = amount; }


    public void enableAbility(Ability a){
        //TODO: verifica in Player
        activeAbilities.add(a);
    }

    public void disableAbility(Ability a){
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

}
