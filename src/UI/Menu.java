package UI;

import Design.GameManager;
import Design.Player;
import Design.PlayerGroup;
import Design.Skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private GameManager gameManager;

    public Menu(){
        gameManager = gameManager.getInstance();
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

    public List<Player> assembleGroup(List<Player> availablePlayers){

        for(Player p : availablePlayers){
            System.out.println(p);
        }
        List<Player> participants = new ArrayList<>();
        System.out.println("Type the name of the players who want to participate or type 'end' if you're done");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        try{
            String input;
            do{
                input = bf.readLine();

                for(Player p : availablePlayers){
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

    public void choosePosition(FightPlane plane, List<Player> players){

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        List<Integer> inputs = new ArrayList<>();
        for(Player player : players){
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
                    plane.addToPosition((selection - 1) / 3, (selection - 1) % 3, player);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void chooseActionInFight(Player player){

    }


    public void changeAvailableSkills(Player player){
        System.out.println("Choose a skill from:");
        List<Skill> availableSkills = player.getHero().getActiveSkills();
        for(Skill skill : availableSkills){
            System.out.println(skill);
        }
        boolean repeat = true;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        while(repeat) {
            try {
                String selection = bf.readLine();
                for (Skill skill : availableSkills) {
                    if (skill.getName().equals(selection)) {
//                        activeSkills.add(skill);
//                        skills.remove(skill);
                        System.out.println("Do you need another skill?");
                        String choise = bf.readLine();
                        if (choise.equals("yes")) {
                            repeat = true;
                        } else  repeat = false;

                    } else {
                        System.out.println("Invalid skill!");
                        repeat = true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
