import Design.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        GameManager gameManager = GameManager.getInstance();
        List<Item> itemsList = new ArrayList<>();
        List<Skill> skillsList= new ArrayList<>();


        try {
            File playersFile = new File("D:\\internship\\work2\\Collections\\Collections\\Workshop\\Game\\src\\players");
            BufferedReader br = new BufferedReader(new FileReader(playersFile));
            String playersStr;

            while ((playersStr = br.readLine()) != null){
                String[] player = playersStr.split(",");
                //System.out.println(player[0]);
                //System.out.println(player[1]);
                gameManager.createPlayer(player[0], player[1]);

            }

            File itemsFile = new File("D:\\internship\\work2\\Collections\\Collections\\Workshop\\Game\\src\\items");
            br = new BufferedReader(new FileReader(itemsFile));
            String itemsStr;

            while ((itemsStr = br.readLine()) != null){
                String[] item = itemsStr.split(",");
                //System.out.println(player[0]);
                //System.out.println(player[1]);
                itemsList.add(new Item((itemSlot.valueOf(item[0])), item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3]),  Integer.parseInt(item[4]),  Integer.parseInt(item[5]),
                        Integer.parseInt(item[6]), Integer.parseInt(item[7]), Integer.parseInt(item[8])));


            }

            File skillsFile = new File("D:\\internship\\work2\\Collections\\Collections\\Workshop\\Game\\src\\skills");
            br = new BufferedReader(new FileReader(skillsFile));
            String skilsStr;

            while ((skilsStr= br.readLine()) != null){
                String[] skill= skilsStr.split(",");
                skillsList.add(new Skill(skill[0], Integer.parseInt(skill[1]), Integer.parseInt(skill[2]), skill[3], Integer.parseInt(skill[4]), Integer.parseInt(skill[5]),
                        Integer.parseInt(skill[6]), Integer.parseInt(skill[7])));

            }

        } catch (IOException e){
            e.printStackTrace();
        }



        gameManager.play();


    }
}
