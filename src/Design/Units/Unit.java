package Design.Units;

import Design.AbilitiesAndItems.Ability;

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

    private List<Ability> abilities = new ArrayList<>();


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

    public void addAbility(Ability a){
        if(this.baseHero.compatibleAbilities().contains(a.getType())) {
            abilities.add(a);
            baseHero.enableAbility(a);
            //TODO: meniu pentru a ii permite utilizatorului sa isi aleaga abilitatile active (skillswap comentat in gamemanager)
        }
        else
            System.out.println("Incompatible ability");
    }

    public void enableAbility(Ability ability){
        if(abilities.contains(ability))
            baseHero.enableAbility(ability);
    }

    void getXP(int amount){
        this.xp += amount;
        //TODO: check for next level threshold
    }

    int getDexterity(){ return fightHero.getDexterity();}

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

    public boolean isDead(){
        return fightHero.getHP() <= 0;
    }

    public String printHeroTypeAndLevel(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(": level ").append(baseHero.getLevel()).append(" ").append(baseHero.toString()).append(". ");
        return sb.toString();
    }

    public String printHPAndMana(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(": ").append(fightHero.getHP()).append(" hp.");
        return sb.toString();
    }

    public Ability firstAbility(){
        if(fightHero.getActiveAbility(0) != null){
            return fightHero.getActiveAbility(0);
        }
        return null;
    }

    public boolean closeToDying(){
        //a unit is close to dying if it has 15% hp left
        return (fightHero.getHP() > 0 && fightHero.getHP() <= baseHero.getHP() * 0.15);
    }

    public boolean isHealer(){
        return fightHero.isHealer();
    }

    public String getName() {
        return name;
    }

    public List<Ability> getAbilities(){
        return abilities;
    }

    public int getLevel(){
        return level;
    }

    public int getFightHP(){ return fightHero.getHP(); }

}
