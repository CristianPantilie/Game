package Design.AbilitiesAndItems;

import Design.Units.Unit;

public class Shield extends Ability {

    private int shieldAmount;

    public Shield(String name, String type, int levelRequirement, int manaCost, int numberOfTargets, int shieldAmount)
    {
        super(name, type, levelRequirement, manaCost, numberOfTargets);
        this.shieldAmount = shieldAmount;
    }

    @Override
    public void activate(Unit target) {
        System.out.println("This doesn't ddo anything yet");
    }
}
