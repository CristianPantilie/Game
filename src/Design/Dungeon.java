package Design;

import RNG.RNG;

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

    private void generateWave(){
        int mobNumber = rng.generateMobNumber(75);
        List<AbstractHero> mobs = new ArrayList<>();
        for(int i = 0; i < mobNumber; i++){
//            mobs.add()
        }
        Group mobGroup = new Group(mobs.toArray(new AbstractHero[mobs.size()]));

    }
}