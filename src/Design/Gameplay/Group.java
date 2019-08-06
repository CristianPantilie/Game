package Design.Gameplay;

import Design.AbilitiesAndItems.Ability;
import Design.Units.Mob;
import Design.Units.Player;
import Design.Units.Unit;
import RNG.RNG;
import UI.Menu;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Group
{
    final int MAXSIZE = 5;

//    private List<AbstractHero> heroes = new ArrayList<>();
    private List<Unit> members;

    public Group(List<Unit> members){
       this.members = members;
    }


    public void fight(Group enemyGroup, RNG rng) throws IOException {
        Menu m = new Menu();
        //TODO: rng pentru a stabili cine incepe
        int smallerGroupSize = this.members.size();
        if(enemyGroup.members.size() < smallerGroupSize)
            smallerGroupSize = enemyGroup.members.size();
        //TODO: o modalitate sa se poata bate chiar daca sunt in grupuri de marime diferita

        for(int i = 0; i < smallerGroupSize; i++){
            Player player = (Player) members.get(i);
            Unit target = m.chooseTarget(player, enemyGroup);
            Ability a = m.chooseAbility(player);

            player.interactWith(target, a);

            System.out.println(target.printHPAndMana());

            rng.generateMobAction(enemyGroup, this, (Mob) enemyGroup.groupMembers().get(i));

        }

        checkForDeaths(this);
        checkForDeaths(enemyGroup);
    }



    public List<Unit> groupMembers(){
        return members;
    }

    int averageLevel(){
        int sum = 0;
        for(Unit member : members){
            sum += member.getLevel();
        }
        return sum / members.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Unit member : members)
            sb.append(member.printHPAndMana()).append("\n");
        return sb.toString();
    }

    public Unit weakestUnit(){
        int lowestHP = 100000;
        Unit weakestUnit = null;
        for(Unit u : members){
            if(u.getFightHP() < lowestHP){
                weakestUnit = u;
                lowestHP = u.getFightHP();
            }
        }
        return weakestUnit;
    }

    private void checkForDeaths(Group group){
        ListIterator it = group.groupMembers().listIterator();
        while(it.hasNext()){
            Unit u = (Unit) it.next();
            if(u.isDead()){
                it.remove();
            }
        }
    }

}
