package UI;

import Design.GameManager;
import Design.Player;
import Design.PlayerGroup;

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

    void assembleGroup(){
        System.out.println("");
    }

    void choosePosition(FightPlane plane, Player player){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);

        List<Integer> inputs = new ArrayList<>();
        plane.printInitial(inputs);
        System.out.println("Enter your option");

        try {
            Integer selection = Integer.parseInt(bf.readLine());
            if (inputs.contains(selection)) {
                System.out.println("Invalid selection");
                choosePosition(plane, player);
            }
            else {
                inputs.add(selection);
                plane.addToPosition(selection / 3, (selection - 1) % 3, player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
