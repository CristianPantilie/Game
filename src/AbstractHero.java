import java.util.ArrayList;
import java.util.List;

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

    private Item headItem;
    private Item shoulderItem;
    private Item chestItem;
    private Item handsItem;
    private Item legsItem;
    private Item feetItem;

    private Skill firstSkill;
    private Skill secondSkill;
    private Skill thirdSkill;
    private Skill fourthSkill;

    void equipItem(Item item){
        //TODO: cauta dupa ce tip are item-ul si dezechipeaza-l daca e unul in acel slot
        hitPoints += item.getHitPoints();
        mana += item.getMana();
        strength += item.getStrength();
        dexterity += item.getDexterity();
        intelligence += item.getIntelligence();
    }

    void unequipItem(Item item){
        //TODO: verifica daca item-ul respectiv e deja echipat
    }

    boolean checkItem(Item item){
        if(this.headItem.equals(item)) return true;
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

}
