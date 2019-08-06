package Design.AbilitiesAndItems;

import Design.Units.Unit;

public abstract class Ability {



    private final String name;
    private final AbilityType type;
    private final int levelRequirement;

    private int manaCost;
    private int numberOfTargets;
    private int damageAmount;
    private int healAmount;
    private int shieldAmount;


    public Ability(String name, String type, int levelRequirement, int manaCost, int numberOfTargets){
        this.name = name;
        this.levelRequirement = levelRequirement;
        this.manaCost = manaCost;
        this.numberOfTargets = numberOfTargets;
        if(type.toUpperCase().equals("RANGED"))
            this.type = AbilityType.RANGED;
        else
            this.type = AbilityType.MELEE;
    }

    public Ability(Unit unit, Ability ability){  //used to copy a standard ability to and have it mold to the player's stats
        this.name = ability.name;
        this.manaCost = ability.manaCost;
        this.levelRequirement = ability.levelRequirement;
        this.type = ability.type;
        //TODO: copiaza chestiile de baza din s si le modifica pentru eroul p pe baza statsurilor
    }

    public String getName(){
        return name;
    }

    public AbilityType getType() { return type; }

    public abstract void activate(Unit target);



}
