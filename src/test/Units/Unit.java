package test.Units;

import test.Skills.Skill;

abstract public class Unit {

    private String name;
    private int xp;

    private Hero hero;

    private Hero baseHero;
    private Hero fightHero;

    private Skill skill;


    Unit(String name, String heroType, int level){
        this.name = name;
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

    public void giveSkill(Skill s){
        skill = s;
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

    public void interactWith(Unit target, Skill s){
        System.out.print(this.name);
        s.activate(target);

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
