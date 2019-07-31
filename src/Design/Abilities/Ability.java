package Design.Abilities;

import Design.Units.Unit;

public abstract class Ability {

    private final String name;

    Ability(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void activate(Unit target);
}
