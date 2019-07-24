import Design.Player;
import Design.PlayerGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String[][] finalLook={};
        Player p = new Player("RANGER", "eu");
       Player p1 = new Player("RANGER", "eue");
        int n = 5;
        int monsters = 5;

       //PlayerGroup g = new PlayerGroup(p, p1);
        //g.test();


        String[][] matrix = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        String[][] monstersMatrix = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        main.displayOptions(matrix);
        List<String> inputs = new ArrayList<>();
        List<String> monstersPositions = new ArrayList<>();

        while (n != 0) {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr);
            System.out.println("Enter your option");

            try {
                String selection = bf.readLine();
                if (inputs.contains(selection)) {
                    System.out.println("Invalid selection");
                    main.displayOptions(matrix);
                    inputs.add(selection);
                } else {
                    inputs.add(selection);
                    String[][] remainingMatrix = main.remainingOptions(matrix, selection);
                    main.displayOptions(remainingMatrix);
                    finalLook = remainingMatrix;
                    n--;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        String[][] remainingMatrix2={};
        while (monsters != 0) {
            Random rand = new Random();
            int r = rand.nextInt(9)+1;
            String x = Integer.toString(r);
            if (monstersPositions.contains(x)) {
                monstersPositions.add(x);
                while(monstersPositions.contains(x)){
                    r = rand.nextInt(9)+1;
                    x = Integer.toString(r);

                }

            } else {
                monstersPositions.add(x);
                remainingMatrix2 = main.remainingOptions(monstersMatrix, x);
                monsters--;
            }
        }
        main.displayOptions(remainingMatrix2);



    }


    public void displayOptions(String[][] matrix){
        for (int i =0; i<3; i++){
            for (int j =0; j<3; j++){
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public String[][] remainingOptions(String[][] matrix, String x){
        for (int i =0; i<3; i++){
            for (int j =0; j<3; j++){
                if(matrix[i][j].equals(x))
                    matrix[i][j ]= "*";
            }
        }

        return matrix;
    }

    public String[][] concatenateMatrices(String[][] matrix1, String[][] matrix2){
        String[][] result = {};
        for (int i =0; i<matrix1.length; i++){
            for (int j =0; j<matrix1.length; j++){
                result[i][j] = matrix1[i][j];
            }}
        for (int i =matrix1.length; i<matrix2.length; i++){
            for (int j =matrix1.length; j<matrix2.length; j++){
                result[i][j] = matrix2[i][j];
            }}
        return result;
    }


}
