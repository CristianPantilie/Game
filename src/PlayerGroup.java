import java.util.ArrayList;
import java.util.List;

public class PlayerGroup extends Group
{
    List<Player> playerList = new ArrayList<>();
    PlayerGroup(Player... players){
        super(players);

        int i = 0;
        while(i < MAXSIZE && i < players.length){
            this.playerList.add(players[i]);
            i++;
        }
    }

    int averageLevel(){
        int sum = 0;
        for(Player p : playerList){
            sum += p.getLevel();
        }
        return sum / playerList.size();
    }

}
