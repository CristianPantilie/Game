package Design;

import java.util.ArrayList;
import java.util.List;

public class PlayerGroup extends Group
{
    List<Player> playerList = new ArrayList<>();
    PlayerGroup(List<Player> players){
        super(players);

        int i = 0;
        while(i < MAXSIZE && i < players.size()){
            this.playerList.add(players.get(i));
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

    public List<Player> getPlayers(){
        return playerList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Player p : playerList)
            sb.append(p.toString()).append("\n");
        return sb.toString();
    }
}
