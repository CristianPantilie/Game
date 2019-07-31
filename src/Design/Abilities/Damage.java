package Design.Abilities;

import Design.Units.Mob;
import Design.Units.Unit;

public class Damage extends Ability {

    private int damageDone;

    public Damage(String name, int damageDone)
    {
        super(name);
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
