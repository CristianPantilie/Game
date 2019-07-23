package RNG;
import AbstractHero;

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

    public AbstractHero generateMob(){

    }
}
