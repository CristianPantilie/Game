package UI;

import Design.AbilitiesAndItems.Ability;
import Design.Gameplay.Group;
import Design.Manager.GameManager;
import Design.Units.Mob;
import Design.Units.Player;
import Design.Units.Unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private GameManager gameManager;
    private BufferedReader bf;

    public Menu(){
        gameManager = gameManager.getInstance();
        bf = new BufferedReader(new InputStreamReader(System.in));
    }

    public void playerList(){
        //gameManager.test();
    }

//    void initializeFightPlane(PlayerGroup group){
//        FightPlane plane = new FightPlane();
//
//        for(Player p : group.getPlayers())
//            plane.fillPosition(p);
//
//    }

    public List<Unit> assembleGroup(List<Unit> availablePlayers){

        for(Unit p : availablePlayers){
            System.out.println(p);
        }
        List<Unit> participants = new ArrayList<>();
        System.out.println("Type the name of the players who want to participate or type 'end' if you're done");

        try{
            String input;
            do{
                input = bf.readLine();

                for(Unit p : availablePlayers){
                    if(p.getName().equals(input)) {
                        participants.add(p);
                        System.out.println(p.getName() + " added!");
                    }
                }

            }while(!input.equals("end"));

        } catch(IOException e){
            e.printStackTrace();
        }

        return participants;
    }

    public void choosePosition(FightPlane plane, List<Unit> players){

        List<Integer> inputs = new ArrayList<>();
        for(Unit player : players){
            System.out.println(player.getName() + " choose your position! ");
            plane.printInitial(inputs);
            try {
                Integer selection = Integer.parseInt(bf.readLine());
                if (inputs.contains(selection)) {
                    System.out.println("Invalid selection");
                    choosePosition(plane, players);
                }
                else {
                    inputs.add(selection);
                    plane.addToPosition((selection - 1) / 3, (selection - 1) % 3, (Player) player);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Unit chooseTarget(Player player, Group enemies) throws IOException{
        System.out.println(player.getName() + " type the name of your target. ");
        String chosenName = bf.readLine();

        for(Unit mob : enemies.groupMembers()){
            if(mob.getName().equals(chosenName)) {
                return mob;
            }
        }
        //recursive call in the case that the name typed wasn't found
        return chooseTarget(player, enemies);
    }


    public Ability chooseAbility(Player player) throws IOException{
        System.out.println(player.getName() + " type your ability of choice. ");
        for(Ability a : player.getAbilities()){
            System.out.println(a.getName());
        }

        String chosenName = bf.readLine();
        for(Ability a : player.getAbilities()){
            if(a.getName().equals(chosenName)) {
                return a;
            }
        }
        //recursive call in the case that the name typed wasn't found
        return chooseAbility(player);
    }

//    public void chooseActionInFight(Player player){
//
//    }


//    public void changeAvailableSkills(Player player){
//        System.out.println("Choose a skill from:");
//        List<Ability> availableSkills = player.getHero().getActiveSkills();
//        for(Ability skill : availableSkills){
//            System.out.println(skill);
//        }
//        boolean repeat = true;
//
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader bf = new BufferedReader(isr);
//        while(repeat) {
//            try {
//                String selection = bf.readLine();
//                for (Skill skill : availableSkills) {
//                    if (skill.getName().equals(selection)) {
////                        activeSkills.add(skill);
////                        skills.remove(skill);
//                        System.out.println("Do you need another skill?");
//                        String choise = bf.readLine();
//                        if (choise.equals("yes")) {
//                            repeat = true;
//                        } else  repeat = false;
//
//                    } else {
//                        System.out.println("Invalid skill!");
//                        repeat = true;
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

}
