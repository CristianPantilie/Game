import Design.Player;
import Design.PlayerGroup;
import RNG.RNG;
import UI.Menu;

public class Main {

    public static void main(String[] args) {


        Player p = new Player("RANGER", "eu");
        Player p1 = new Player("RANGER", "eue");


        Menu menu = new Menu();

        menu.playerList();


    }


}

