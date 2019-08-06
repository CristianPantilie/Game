package Design.Manager;

import Design.AbilitiesAndItems.Ability;
import Design.AbilitiesAndItems.Damage;
import Design.Gameplay.Dungeon;
import Design.Gameplay.Group;
import Design.Units.Player;
import Design.Units.Unit;
import UI.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GameManager {
    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
        Ability hit = new Damage("Hit", "MELEE", 1, 0, 1, 4);
        availableAbilities.add(hit);
        Ability shoot = new Damage("Shoot", "RANGED", 1, 0, 1, 2);
        availableAbilities.add(shoot);
        Ability stab = new Damage("Stab", "MELEE", 1, 0, 1, 3);
        availableAbilities.add(stab);
    }


    private List<Ability> availableAbilities = new ArrayList<>();
    private List<Unit> players = new ArrayList<>();
    private List<Unit> zones = new ArrayList<>();

    public void play() throws IOException {
        Menu m = new Menu();
        Group group = assembleGroup(m);
        Dungeon d = selectDungeon(group);
        System.out.println(group);

        d.fight();
    }


    public Group assembleGroup(Menu m) {
        List<Unit> participants = m.assembleGroup(players);

        return new Group(participants);
    }

    private Dungeon selectDungeon(Group targetGroup) {
        //TODO: meniu pentru selectarea zonei dintr-o lista de zone generate
        return new Dungeon(targetGroup);

    }

    public void createPlayer(String playerClass, String name) {
        players.add(new Player(name, playerClass));
        if (playerClass.equals("FIGHTER")) {
            giveAbility(name, availableAbilities.get(0));
        } //adds Hit to Fighter class
        else giveAbility(name, availableAbilities.get(1)); //adds Shoot to Mage/Ranger class
        if (playerClass.equals("RANGER")) {
            giveAbility(name, availableAbilities.get(2));
        } //adds Stab to Ranger class
    }

    public Unit getPlayer(String name) {
        for (Unit p : players) {
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }


    public void giveAbility(String playerName, Ability s) {
        for (Unit p : players) {
            if (p.getName().equals(playerName)) {
                p.addAbility(s); //skill is added in selectable skills for the hero
            }
        }
    }

    public Ability getAbility(String abilityName){
        for(Ability a : availableAbilities){
            if(a.getName().equals(abilityName))
                return a;
        }

        return null;
    }


//    public void skillSwap(Player p, Skill s) {
//        System.out.println("Would you like to swap a skill for " + s.getName() + "?");
//        System.out.println("1/2/3/4/no");
//        Scanner scan = new Scanner(System.in);
//        String input = scan.nextLine();
//        switch (input) {
//            case "1": {
//                p.getHero().setActiveSkill(1, s);
//                return;
//            }
//            case "2": {
//                p.getHero().setActiveSkill(2, s);
//                return;
//            }
//            case "3": {
//                p.getHero().setActiveSkill(3, s);
//                return;
//            }
//            case "4": {
//                p.getHero().setActiveSkill(4, s);
//                return;
//            }
//            case "no":
//                return; //skill is still added in selectable skills
//            default:
//                return;
//        }
//    }
}