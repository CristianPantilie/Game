package UI;

import Design.AbstractHero;
import Design.Player;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FightPlane {

    private final int GRID_SIZE = 3;

    private Position[][] playerFormation = new Position[GRID_SIZE][GRID_SIZE];
    private Position[][] monsterFormation = new Position[GRID_SIZE][GRID_SIZE];

    public FightPlane(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                playerFormation[i][j]  = new Position(i, j);
                monsterFormation[i][j] = new Position(i, j);
            }
        }
    }

    public void addToPosition(int i, int j, AbstractHero mob){
        monsterFormation[i][j].add(mob);
    }

    void addToPosition(int i, int j, Player player){
        playerFormation[i][j].add(player);
    }

    public void printCurrent(){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < 2 * GRID_SIZE; j++){
                if(j < GRID_SIZE)
                    System.out.print(playerFormation[i][j] + " ");
                else
                    System.out.print(monsterFormation[i][j - GRID_SIZE] + " ");
            }
            System.out.println();
        }
    }

    void printInitial(List<Integer> chosenOnes){
        int c = 1;
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                if(playerFormation[i][j].getPlayer() != null) {
                    System.out.print("*  ");
                    c++;
                }
                else {
                    System.out.print(c + "  ");
                    c++;
                }
            }
            System.out.println();
        }

    }

}
