package Design;

import java.util.*;

public abstract class AbstractHero
{

    //stats
    private int hitPoints;
    private int mana;
    private int strength;   //melee damage
    private int dexterity;  //ranged damage, dodge chance, hit chance
    private int intelligence; //spell power, initiative

    private List<Item> inventory = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();

    protected EnumMap<itemSlot,Item> equipment = new EnumMap<itemSlot,Item>(itemSlot.class);
    /*   private Design.Item headItem;
    private Design.Item shoulderItem;
    private Design.Item chestItem;
    private Design.Item handsItem;
    private Design.Item legsItem;
    private Design.Item feetItem;
    */
    private Skill firstSkill;
    private Skill secondSkill;
    private Skill thirdSkill;
    private Skill fourthSkill;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass()).append(", hp: ");
        return sb.toString();
    }

    void equipItem(Item item){
        if(equipment.get(item.getSlot())!=null){
            this.unequipItem(equipment.get(item.getSlot()));
        }

        equipment.put(item.getSlot(),item);
        hitPoints += item.getHitPoints();
        mana += item.getMana();
        strength += item.getStrength();
        dexterity += item.getDexterity();
        intelligence += item.getIntelligence();
    }

    void unequipItem(Item item){
        if(this.checkHasItem(item)) {
            equipment.remove(item.getSlot());
            hitPoints -= item.getHitPoints();
            mana -= item.getMana();
            strength -= item.getStrength();
            dexterity -= item.getDexterity();
            intelligence -= item.getIntelligence();
        }
        else System.out.println(item.getName() +"is not equipped!");
    }

    boolean checkHasItem(Item item){
        if(equipment.get(item.getSlot()).equals(item)) return true;
        return false;
    }


    void setSkill(int number, Skill s){
        if(!skills.contains(s))
            return;

        switch (number){
            case 1:
                firstSkill = new Skill(this, s);
                break;
            case 2:
                secondSkill = new Skill(this, s);
                break;
            case 3:
                thirdSkill = new Skill(this, s);
                break;
            case 4:
                fourthSkill = new Skill(this, s);
                break;
        }
    }

    void addSkill(Skill s){
        this.skills.add(s);
    }

    void decreaseHitPoints(int amount){
        hitPoints -= amount;
    }

    void increaseHitPoints(int amount){
        hitPoints += amount;
    }


    void action(){
        //TODO:  meniu pentru alegerea uneia dintre actiuni
        //TODO: meniu pentru alegerea unui target

    }

}
