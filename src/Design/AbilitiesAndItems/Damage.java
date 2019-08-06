package Design.AbilitiesAndItems;

import Design.Units.Mob;
import Design.Units.Unit;

public class Damage extends Ability {

    private int damageAmount;

    public Damage(String name, String type, int levelRequirement, int manaCost, int numberOfTargets, int damageAmount)
    {
        super(name, type, levelRequirement, manaCost, numberOfTargets);
        this.damageAmount = damageAmount;
    }

    @Override
    public void activate(Unit target) {
        System.out.print(" damages " + target.getName() + " for " + damageAmount + ". ");
        if(target.decreaseHP(this.damageAmount)){
            //TODO: eliminate them from the game.
            System.out.println(target.getName() + " has died. ");
        }
    }
}
