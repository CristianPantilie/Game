import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Player p = new Player("RANGER", "eu");
        Player p1 = new Player("RANGER", "eue");

        PlayerGroup g = new PlayerGroup(p, p1);
        g.test();
    }


}

