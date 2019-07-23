import java.util.ArrayList;
import java.util.List;

public class Group
{
    private final int maxSize = 5;

    private List<AbstractHero> heroes = new ArrayList<>();
    Group(AbstractHero... heroes) {
        int i = 0;
        while(i < maxSize && i < heroes.length){
            this.heroes.add(heroes[i]);
            i++;
        }
    }

    Group(Player... players){
        AbstractHero[] heroes = new AbstractHero[players.length];
        for(int  i = 0; i < players.length; i++){
            heroes[i] = players[i].getHero();
        }
        int i = 0;
        while(i < maxSize && i < heroes.length){
            this.heroes.add(heroes[i]);
            i++;
        }
    }



}
