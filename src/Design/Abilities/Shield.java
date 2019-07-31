package Design.Abilities;

import Design.Units.Player;
import Design.Units.Unit;

public class Shield extends Ability {

    public Shield(String name) {
        super(name);
    }

    @Override
    public void activate(Unit target) {
        System.out.println("This doesn't ddo anything yet");
    }
}
