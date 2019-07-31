package test.Skills;

import test.Units.Player;
import test.Units.Unit;

public class Heal extends Skill {

    private int healDone;
    @Override
    public void activate(Unit target) {
        if(target instanceof Player){
            target.increaseHP(this.healDone);
        }
    }

}
