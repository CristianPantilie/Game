package Design.Units;

import Design.Abilities.Ability;

import java.util.ArrayList;
import java.util.List;

abstract public class Unit {

    private final String name;

    private Hero baseHero;
    private Hero fightHero;

    private int xp;
    private int xpToNextLevel;
    private int level;
    private int statPoints;
    private int skillPoints;
    private int statPointsPerLevel;
    private int skillPointsPerLevel;  //subunitar, sa se poata lua un skill la cateva nivele
    private int gold;

    List<Ability> abilities = new ArrayList<>();


    Unit(String name, String heroType, int level){
        this.name = name;
        this.level = level;
        switch(heroType.toUpperCase()){
            case "FIGHTER":
                baseHero = new Fighter(level);
                break;
            case "RANGER":
                baseHero = new Ranger(level);
                break;
            case "MAGE":
                baseHero = new Mage(level);
                break;
        }
    }

    public void enterDungeon(){
        fightHero = baseHero.cloneHero();
    }

    public void exitDungeon(){
        fightHero = null;
    }

    public void giveAbility(Ability s){
        abilities.add(s);
    }

    public void enableAbility(String abilityName){
        for(Ability a : abilities){
            if(a.getName().equals(abilityName))
                baseHero.enableAbility(a);
        }
    }

    void getXP(int amount){
        this.xp += amount;
        //TODO: check for next level threshold
    }

    public boolean decreaseHP(int amount){
        fightHero.setHP(fightHero.getHP() - amount);
        return (fightHero.getHP() <= 0);
    }

    public void increaseHP(int amount){
        if(fightHero.getHP() + amount > baseHero.getHP()){
            fightHero.setHP(baseHero.getHP());
        }
        else{
            fightHero.setHP(amount);
        }
    }

    public void interactWith(Unit target, Ability a){
        System.out.print(this.name);
        a.activate(target);

        if(target.fightHero.getHP() < 0){

        }
    }

    public String printHPAndMana(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(": ").append(fightHero.getHP()).append(" hp.");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

}
