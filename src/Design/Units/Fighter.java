package Design.Units;

import Design.AbilitiesAndItems.AbilityType;

import java.util.ArrayList;
import java.util.List;

public class Fighter extends Hero {

    public static final int FIGHTER_BASE_HP = 20;
    public static final int FIGHTER_BASE_MANA = 10;
    public static final int FIGHTER_BASE_STRENGTH = 15;
    public static final int FIGHTER_BASE_DEXTERITY = 10;
    public static final int FIGHTER_BASE_INTELLIGENCE = 5;


    public Fighter(){
        this(1);
    }

    Fighter(int level) {
        super(level, FIGHTER_BASE_HP + level * 3, FIGHTER_BASE_MANA, FIGHTER_BASE_STRENGTH + level, FIGHTER_BASE_DEXTERITY + level, FIGHTER_BASE_INTELLIGENCE);
    }

    Fighter(int level, int hitPoints, int mana, int strength, int dexterity, int intelligence){
        super(level, hitPoints, mana, strength, dexterity, intelligence);
    }



    public List<AbilityType> compatibleAbilities(){
        List<AbilityType> abilities = new ArrayList<>();
        abilities.add(AbilityType.MELEE);
        return abilities;
    }

    @Override
    public String toString() {
        return "Fighter";
    }
}
