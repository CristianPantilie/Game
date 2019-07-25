package Design;

import java.util.ArrayList;
import java.util.List;

public class Group
{
    final int MAXSIZE = 5;

    private List<AbstractHero> heroes = new ArrayList<>();

    Group(AbstractHero... heroes) {
        int i = 0;
        while(i < MAXSIZE && i < heroes.length){
            this.heroes.add(heroes[i]);
            i++;
        }
    }

    Group(List<Player> players){
        AbstractHero[] heroes = new AbstractHero[players.size()];
        for(int  i = 0; i < players.size(); i++){
            heroes[i] = players.get(i).getHero();
        }
        int i = 0;
        while(i < MAXSIZE && i < heroes.length){
            this.heroes.add(heroes[i]);
            i++;
        }
    }


    public void fight(Group enemyGroup){
        //TODO: rng pentru a stabili cine incepe
        int smallerGroupSize = this.heroes.size();
        if(enemyGroup.heroes.size() < smallerGroupSize)
            smallerGroupSize = enemyGroup.heroes.size();
        //TODO: o modalitate sa se poata bate chiar daca sunt in grupuri de marime diferita

        for(int i = 0; i < smallerGroupSize; i++){
            this.heroes.get(i).action();
            enemyGroup.heroes.get(i).action();
        }
    }



}
