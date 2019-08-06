package Design.Units;

public class Mob extends Unit {
    int xpGiven;

    public Mob(String heroType, int level){
        //super(generateName)
        super("mob", heroType, level);
    }

    public Mob(String name, String heroType, int level){
        //super(generateName)
        super(name, heroType, level);
    }

    void getXP(int amount){
        //nothing: mobs don't level up
    }

    int giveXP(){
        return xpGiven;
    }
}
