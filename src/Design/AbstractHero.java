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
    private List<Skill> activeSkills = new ArrayList<>();

    protected EnumMap<itemSlot,Item> equipment = new EnumMap<itemSlot,Item>(itemSlot.class);

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

    void addSkill(Skill s){
        this.skills.add(s);
    }
    public Skill getActiveSkill(int i) {
        return this.activeSkills.get(i);
    }

    public void setActiveSkill(int i,Skill s) {
        this.activeSkills.set(i,s);
    }
    public int numberofActiveSkills(){
        return this.activeSkills.size();
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
