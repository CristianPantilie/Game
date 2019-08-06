package RNG;
import Design.AbilitiesAndItems.Ability;
import Design.AbilitiesAndItems.AbilityType;
import Design.Gameplay.Group;
import Design.Manager.GameManager;
import Design.Units.*;
import UI.FightPlane;
import UI.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RNG
{
//TODO: fa-l si pe asta singleton
    public int generateMobNumber(int probability){

        int generatedNumber;

        int randomInt = new java.util.Random().nextInt(100);
        if(randomInt < 100 - probability){
            generatedNumber = randomInt % 3 + 1;
        }
        else{
            generatedNumber = randomInt % 2 + 4;
        }

        return generatedNumber;
    }

    public Unit generateMob(int targetLevel){

        Unit mob;
        GameManager gm = GameManager.getInstance();

        int mobLevel = new Random().nextInt(4) + targetLevel;
        int mobType = new Random().nextInt(3);
        String name = "Mob" + (new Random().nextInt(100));
        Ability a;
        switch(mobType + 1){
            case 1:
                mob = new Mob(name, "fighter", mobLevel);
                a = gm.getAbility("Hit");
                break;
            case 2:
                mob = new Mob(name,"ranger", mobLevel);
                a = gm.getAbility("Stab");
                break;
            default:
                mob = new Mob(name, "mage", mobLevel);
                a = gm.getAbility("Shoot");
                break;
        }

        mob.addAbility(a);
        mob.enableAbility(a);

        return mob;
    }

    public void generateMonsterFormation(FightPlane plane, List<Unit> monsters){
        int currentMonsterIndex = monsters.size();
        List<Integer> chosenPositions = new ArrayList<>();

        while(currentMonsterIndex != 0){
            Random rand = new Random();
            int r = rand.nextInt(9) + 1;

            while(chosenPositions.contains(r)){
                r = rand.nextInt(9) + 1;
            }
            chosenPositions.add(r);
            currentMonsterIndex--;

            plane.addToPosition((r - 1) / 3, (r - 1) % 3, (Mob) monsters.get(currentMonsterIndex));
        }
    }

    public void generateMobAction(Group mobGroup, Group enemyGroup, Mob mob){

        if(mob.isHealer()){
            for(Unit m : mobGroup.groupMembers())
                if(m.closeToDying()){
                    //heal him immediately with the best fitting healing ability
                }
        }

        for(Unit enemy : enemyGroup.groupMembers()){
            if(enemy.closeToDying()){
                //damage him with the ability that costs least and has a high chance of finishing him
            }
        }

        if(mob.isHealer()){
            //if there is a mob that needs healing and this mob has a heal with a small chance of overhealing, use it
        }

        Unit attackTarget = enemyGroup.weakestUnit();
        Ability abilityUsed = mob.firstAbility();
        mob.interactWith(attackTarget, abilityUsed);

        System.out.println(attackTarget.printHPAndMana());

    }


    public int generateAbilityDamage(Ability ability, Unit attacker, Unit target, FightPlane plane)
    {
        int hitChance = 100;
        Position attackerPosition = plane.getPosition(attacker);
        Position targetPosition = plane.getPosition(target);
        int distanceBetween = attackerPosition.distanceFrom(targetPosition);

        if(ability.getType().equals(AbilityType.MELEE)){
            if(!attackerPosition.isInMelee() ||
               !targetPosition.isInMelee()   || distanceBetween > 2)
                hitChance = 0;
        }
        else if(ability.getType().equals(AbilityType.RANGED)){
            if(distanceBetween > 2){
                hitChance = hitChance / distanceBetween;
            }
        }

        //TODO: improve formula based on dexterity and dodge chance

        return 0;
    }

    public void generateMobName(){

    }
}
