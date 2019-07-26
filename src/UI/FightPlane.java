package UI;

import Design.Player;
import sun.plugin.javascript.navig.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FightPlane {

//    FightPlane(){
//        this.makePlayerFormation(n);
//    }

    @Override
    public String toString() {

        return "";
    }

    private String[][] makePlayerFormation(int n){
//        int n = 5;
        String[][] remainingMatrix={};
        //String[][] finalLook={};
        String[][] matrix = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        displayOptions(matrix);
        List<String> inputs = new ArrayList<>();
        while (n != 0) {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr);
            System.out.println("Enter your option");

            try {
                String selection = bf.readLine();
                if (inputs.contains(selection) || !numbers.contains(selection)) {
                    System.out.println("Invalid selection");
                    displayOptions(matrix);
                    inputs.add(selection);
                } else {
                    inputs.add(selection);
                     remainingMatrix = remainingOptions(matrix, selection);
                    displayOptions(remainingMatrix);
                    //finalLook = remainingMatrix;
                    n--;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return remainingMatrix;
    }

    private String[][] makeMonstersFormation(){
        int monsters = 5;
        String[][] monstersMatrix = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        List<String> monstersPositions = new ArrayList<>();
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
                remainingMatrix2 =remainingOptions(monstersMatrix, x);
                monsters--;
            }
        }
        //displayOptions(remainingMatrix2);

    return remainingMatrix2;
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
        String[][] result = new String[matrix1.length][matrix1.length+matrix2.length];
        for (int i =0; i<matrix1.length; i++){
            for (int j =0; j<matrix1.length; j++){
                result[i][j] = matrix1[i][j];
            }}

        for (int i =0; i<matrix2.length; i++){
            for (int j =0; j<matrix2.length; j++){
                result[i][j+3] = matrix2[i][j];
            }}
        return result;
    }











    public void getPlayerDecision(Player player, String[][] gameFormation) {
        boolean bool = false;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);

        List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

        while(bool ==  false) {
            System.out.println("Enter the position you want to attack");

                try {
                String selection = bf.readLine();
                if (!numbers.contains(selection) || !checkIfMonsterExist(selection, gameFormation)) {
                    System.out.println("Invalid selection");
                    displayGameFormations(gameFormation);
                    bool = false;
                }else  bool=true;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    public boolean checkIfMonsterExist(String selected,String[][] gameFormation){
        int c =0;
        for (int i =0; i<gameFormation.length; i++){
            for (int j =3; j<gameFormation[i].length; j++){
              c = c+1;
              if(c == Integer.parseInt(selected) && gameFormation[i][j].equals("*")) return true;
            }}

        return false;
    }


    public void displayGameFormations(String[][] result){
        System.out.println("Formations:");
        for (int i =0; i<result.length; i++){
            for (int j =0; j<result[i].length; j++){
                System.out.print(result[i][j]+"   ");
            }
            System.out.println();
        }
    }







    public static void main(String[] args){
        int n = 5;
        FightPlane fightPlane = new FightPlane();
       String[][] playersFormation =  fightPlane.makePlayerFormation(5);
       String[][] monstersFormation= fightPlane.makeMonstersFormation();
       String[][] result = fightPlane.concatenateMatrices(playersFormation, monstersFormation);

       fightPlane.displayGameFormations(result);

        Player p = new Player("FIGHTER", "PLAYER");

            fightPlane.getPlayerDecision( p, result);
        }

    }








