package Design;

import java.util.ArrayList;
import java.util.List;

enum itemSlot {HEAD, SHOULDERS, CHEST, HANDS, LEGS, FEET};

public class GameManager {
    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
    }


    private List<Skill> availableSkills = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Player> zones = new ArrayList<>();

    void play(){
        PlayerGroup group = assembleGroup();
        selectDungeon(group);
    }


    public PlayerGroup assembleGroup(){
        //TODO: meniu pentru alegerea jucatorilor existenti pentru grup

        return new PlayerGroup(players.get(0), players.get(1), players.get(2), players.get(3), players.get(4));
    }

    private void selectDungeon(PlayerGroup targetGroup){
        //TODO: meniu pentru selectarea zonei dintr-o lista de zone generate
        Dungeon d = new Dungeon(targetGroup);

    }


    private void fight(){

    }

    public void createPlayer(String playerClass,  String name){
        players.add(new Player(playerClass, name));
    }

    public Player getPlayer(String name){
        for(Player p : players){
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    public void makeZone(){

    }



}
