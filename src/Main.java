

import Design.Manager.GameManager;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GameManager gameManager = GameManager.getInstance();

        gameManager.createPlayer("FIGHTER", "unu");
        gameManager.createPlayer("FIGHTER", "doi");
        gameManager.createPlayer("RANGER", "trei");
        gameManager.createPlayer("MAGE", "patru");
        gameManager.createPlayer("MAGE", "cinci");

        gameManager.play();

    }
}
