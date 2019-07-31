package Design;

import RNG.RNG;
import UI.FightPlane;
import UI.Menu;

import java.util.ArrayList;
import java.util.List;

public class Dungeon
{
    private int numberOfWaves = 5; //TODO: random
    private String name;
    private String description;

    private PlayerGroup targetGroup;

    private RNG rng = new RNG();

    public Dungeon(PlayerGroup targetGroup)
    {
        this.targetGroup = targetGroup;

        int groupAvg = targetGroup.averageLevel();
    }

    private Group generateWave(){
        int mobNumber = rng.generateMobNumber(75);
        List<AbstractHero> mobs = new ArrayList<>();
        for(int i = 0; i < mobNumber; i++){
            mobs.add(rng.generateMob(targetGroup.averageLevel()));
        }
        return new Group(mobs.toArray(new AbstractHero[mobs.size()]));
    }

    public void fight(){
        Menu m = new Menu();
        FightPlane plane = new FightPlane();
        m.choosePosition(plane, targetGroup.getPlayers());
        rng.generateMonsterFormation(plane, generateWave().groupList());
        plane.printCurrent();

    }


}
