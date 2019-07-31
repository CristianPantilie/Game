package Design.Abilities;

import Design.Units.Player;
import Design.Units.Unit;

public class Heal extends Ability {

    private int healDone;
    @Override
    public void activate(Unit target) {
        if(target instanceof Player){
            target.increaseHP(this.healDone);
        }
    }

    public Heal(String name) {
        super(name);
    }
}
