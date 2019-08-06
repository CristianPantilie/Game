package Design.Units;

import Design.AbilitiesAndItems.AbilityType;

import java.util.ArrayList;
import java.util.List;

public class Mage extends Hero {

    public static final int MAGE_BASE_HP = 20;
    public static final int MAGE_BASE_MANA = 30;
    public static final int MAGE_BASE_STRENGTH = 5;
    public static final int MAGE_BASE_DEXTERITY = 10;
    public static final int MAGE_BASE_INTELLIGENCE = 15;

    public Mage(){
        this(1);
    }

    Mage(int level) {
        super(level, MAGE_BASE_HP + level * 2, MAGE_BASE_MANA + level * 3, MAGE_BASE_STRENGTH, MAGE_BASE_DEXTERITY , MAGE_BASE_INTELLIGENCE + level * 2);
    }

    Mage(int level, int hitPoints, int mana, int strength, int dexterity, int intelligence){
        super(level, hitPoints, mana, strength, dexterity, intelligence);
    }

    public List<AbilityType> compatibleAbilities(){
        List<AbilityType> abilities = new ArrayList<>();
        abilities.add(AbilityType.RANGED);
        return abilities;
    }

    @Override
    public String toString() {
        return "Mage";
    }
}
