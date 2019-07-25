package RNG;
import Design.AbstractHero;
import Design.Fighter;
import Design.Mage;
import Design.Ranger;

import java.util.Random;

public class RNG
{

    public int generateMobNumber(int probability){

        int generatedNumber;

        int randomInt = new java.util.Random().nextInt(100);
        if(randomInt < 100 - probability){
            generatedNumber = randomInt % 3 + 1;
        }
        else{
            generatedNumber = randomInt % 2 + 4;
        }

        return generatedNumber;
    }

    public AbstractHero generateMob(int targetLevel){

        AbstractHero mob;

        int mobLevel = new Random().nextInt(4) + targetLevel;

        int mobType = new Random().nextInt(3);
        switch(mobType + 1){
            case 1:
                mob = new Fighter(mobLevel);
                break;
            case 2:
                mob = new Ranger(mobLevel);
                break;
            default:
                mob = new Mage(mobLevel);
                break;
        }

        return mob;
    }


}
