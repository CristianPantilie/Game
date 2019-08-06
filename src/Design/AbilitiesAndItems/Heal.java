package Design.AbilitiesAndItems;

import Design.Units.Player;
import Design.Units.Unit;

public class Heal extends Ability {

    private int healAmount;

    public Heal(String name, String type, int levelRequirement, int manaCost, int numberOfTargets, int healAmount)
    {
        super(name, type, levelRequirement, manaCost, numberOfTargets);
        this.healAmount = healAmount;
    }
    @Override
    public void activate(Unit target) {
        if(target instanceof Player){
            target.increaseHP(this.healAmount);
        }
    }

}
