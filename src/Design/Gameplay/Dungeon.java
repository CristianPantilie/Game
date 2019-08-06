package Design.Gameplay;

import Design.Units.Mob;
import Design.Units.Player;
import Design.Units.Unit;
import RNG.RNG;
import UI.FightPlane;
import UI.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dungeon
{
    private int numberOfWaves = 5; //TODO: random
    private String name;
    private String description;

    private Group playerGroup;

    private RNG rng = new RNG();

    public Dungeon(Group playerGroup)
    {
        this.playerGroup = playerGroup;
        for(Unit player : playerGroup.groupMembers()){
            getPlayerInDungeon((Player) player);
        }

        int groupAvg = playerGroup.averageLevel();
    }



    private void getPlayerInDungeon(Player p)
    {
        p.enterDungeon();
    }

    private void getPlayerOutOfDungeon(Player p){
        p.exitDungeon();
    }

    private Group generateWave(){
        int mobNumber = rng.generateMobNumber(75);
        List<Unit> mobs = new ArrayList<>();
        for(int i = 0; i < mobNumber; i++){
            Unit mob = rng.generateMob(playerGroup.averageLevel());
            mob.enterDungeon();
            mobs.add(mob);

        }
        Mob test = new Mob("test", "fighter", 1);
        test.enterDungeon();
        mobs.add(test);
        return new Group(mobs);
    }

    public void fight() throws IOException {
        Menu m = new Menu();
        FightPlane plane = new FightPlane();
        Group mobs = generateWave();

        m.choosePosition(plane, playerGroup.groupMembers());
        rng.generateMonsterFormation(plane, mobs.groupMembers());

        plane.printCurrent();
        while(true) {
            playerGroup.fight(mobs, rng);
            plane.printCurrent();

        }
    }

    public void end(){
        for(Unit player : playerGroup.groupMembers()){
            getPlayerInDungeon((Player) player);
        }
    }
}
