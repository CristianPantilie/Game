package Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum itemSlot {HEAD, SHOULDERS, CHEST, HANDS, LEGS, FEET};

public class GameManager {
    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
        Skill Hit = new Skill("Hit", 0, 1, "MELEE", 1, 4, 0, 0);
        availableSkills.add(Hit);
        Skill Shoot = new Skill("Shoot", 0, 1, "RANGED", 1, 2, 0, 0);
        availableSkills.add(Shoot);
        Skill Stab = new Skill("Stab", 0, 1, "MELEE", 1, 3, 0, 0);
        availableSkills.add(Stab);

    }


    private List<Skill> availableSkills = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Player> zones = new ArrayList<>();

    void play() {
        PlayerGroup group = assembleGroup();
        selectDungeon(group);
    }


    public PlayerGroup assembleGroup() {
        //TODO: meniu pentru alegerea jucatorilor existenti pentru grup


        return new PlayerGroup(players.get(0), players.get(1), players.get(2), players.get(3), players.get(4));
    }

    private void selectDungeon(PlayerGroup targetGroup) {
        //TODO: meniu pentru selectarea zonei dintr-o lista de zone generate
        Dungeon d = new Dungeon(targetGroup);

    }


    private void fight() {

    }

    public void createPlayer(String playerClass, String name) {
        players.add(new Player(playerClass, name));
        if (playerClass.equals("FIGHTER")) {
            giveSkill(name, availableSkills.get(0));
        } //adds Hit to Fighter class
        else giveSkill(name, availableSkills.get(1)); //adds Shoot to Mage/Ranger class
        if (playerClass.equals("RANGER")) {
            giveSkill(name, availableSkills.get(2));
        } //adds Stab to Ranger class
    }

    public Player getPlayer(String name) {
        for (Player p : players) {
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }

    public void makeZone() {

    }

    public void giveSkill(String playerName, Skill s) {
        for (Player p : players) {
            if (p.getName().equals(playerName)) {
                p.getHero().addSkill(s); //skill is added in selectable skills for the hero
                for (int i = 0; i < 3; i++) {
                    if (p.getHero().getActiveSkill(i) != null) {
                        p.getHero().setActiveSkill(i, s); //skill is added to empty slot in active skills
                    }
                    if (p.getHero().numberofActiveSkills() == 4) {
                        skillSwap(p, s);
                    }
                }
            }
        }

    }


    public void skillSwap(Player p, Skill s) {
        System.out.println("Would you like to swap a skill for " + s.getName() + "?");
        System.out.println("1/2/3/4/no");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        switch (input) {
            case "1": {
                p.getHero().setActiveSkill(1, s);
                return;
            }
            case "2": {
                p.getHero().setActiveSkill(2, s);
                return;
            }
            case "3": {
                p.getHero().setActiveSkill(3, s);
                return;
            }
            case "4": {
                p.getHero().setActiveSkill(4, s);
                return;
            }
            case "no":
                return; //skill is still added in selectable skills
            default:
                return;
        }


    }
}