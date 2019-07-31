package test.Units;

public class Mob extends Unit {

    int xpGiven;

    public Mob(String heroType, int level){
        //super(generateName)
        super("mob", heroType, level);
    }

    void getXP(int amount){
        //nothing: mobs don't level up
    }

    int giveXP(){
        return xpGiven;
    }
}
