

import Design.Units.Mob;
import Design.Units.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        GameManager gameManager = GameManager.getInstance();
//
//        gameManager.createPlayer("FIGHTER", "unu");
//        gameManager.createPlayer("FIGHTER", "doi");
//        gameManager.createPlayer("RANGER", "trei");
//        gameManager.createPlayer("MAGE", "patru");
//        gameManager.createPlayer("MAGE", "cinci");
//
//        gameManager.play();


        Player p = new Player("p", "Fighter");
        Mob m = new Mob("Fighter", 2);

        System.out.println(p.printHPAndMana());
        System.out.println(m.printHPAndMana());


    }
}
