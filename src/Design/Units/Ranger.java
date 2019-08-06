package Design.Units;

import Design.AbilitiesAndItems.AbilityType;

import java.util.ArrayList;
import java.util.List;

public class Ranger extends Hero {

    public static final int RANGER_BASE_HP = 25;
    public static final int RANGER_BASE_MANA = 20;
    public static final int RANGER_BASE_STRENGTH = 10;
    public static final int RANGER_BASE_DEXTERITY = 15;
    public static final int RANGER_BASE_INTELLIGENCE = 5;

    public Ranger(){
        this(1);
    }

    Ranger(int level) {
        super(level, RANGER_BASE_HP + level * 2, RANGER_BASE_MANA, RANGER_BASE_STRENGTH, RANGER_BASE_DEXTERITY + level * 2, RANGER_BASE_INTELLIGENCE);
    }

    Ranger(int level, int hitPoints, int mana, int strength, int dexterity, int intelligence){
        super(level, hitPoints, mana, strength, dexterity, intelligence);
    }


    public List<AbilityType> compatibleAbilities(){
        List<AbilityType> abilities = new ArrayList<>();
        abilities.add(AbilityType.MELEE);
        abilities.add(AbilityType.RANGED);
        return abilities;
    }

    @Override
    public String toString() {
        return "Ranger";
    }
}
