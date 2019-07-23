import RNG.RNG;

import java.util.ArrayList;
import java.util.List;

public class Zone
{
    private int numberOfWaves = 5; //TODO: random
    private String name;
    private String description;

    PlayerGroup targetGroup;

    RNG rng = new RNG();

    public Zone(PlayerGroup targetGroup)
    {
        this.targetGroup = targetGroup;

        int groupAvg = targetGroup.averageLevel();
    }

    private void generateWave(){
        int mobNumber = rng.generateMobNumber(75);
        List<AbstractHero> mobs = new ArrayList<>();
        for(int i = 0; i < mobNumber; i++){
            mobs.add()
        }
    }
}
