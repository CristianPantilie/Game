package test.Skills;

import test.Units.Mob;
import test.Units.Unit;

public class Damage extends Skill {

    private int damageDone;

    public Damage(int damageDone){
        this.damageDone = damageDone;
    }
    @Override
    public void activate(Unit target) {
        if(target instanceof Mob){
            System.out.print(" damages " + target.getName() + " for " + damageDone + ". ");
            if(target.decreaseHP(this.damageDone)){
                //TODO: eliminate them from the game.
                System.out.println(target.getName() + " has died. ");
            }
        }
    }
}
