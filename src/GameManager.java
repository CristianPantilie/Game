import java.util.ArrayList;
import java.util.List;

enum ItemType{HEAD, SHOULDERS, CHEST, HANDS, LEGS, FEET};

public class GameManager {
    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
    }


    private List<Skill> availableSkills = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    void play(){
        assembleTeam();
        selectZone();
    }


    private void assembleTeam(Player... participant){

    }

    private void  selectZone(){
        Zone z;
        //TODO:generate procedurally a list of mobs and bosses according to the difficulty of the zone
    }






}
