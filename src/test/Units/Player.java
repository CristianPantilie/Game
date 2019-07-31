package test.Units;

public class Player extends Unit {

    public Player(String name, String heroType){
        super(name, heroType, 1);   //players are always created at level 1
    }

    int giveXP(){
        return 0;   //players don't give XP on dying
    }
}
