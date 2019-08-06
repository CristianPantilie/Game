package UI;

import Design.Units.Mob;
import Design.Units.Player;
import Design.Units.Unit;

import java.util.List;

public class FightPlane {

    public static final int GRID_SIZE = 3;

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

    public void addToPosition(int i, int j, Mob mob){
        monsterFormation[i][j].add(mob);
    }

    void addToPosition(int i, int j, Player player){
        playerFormation[i][j].add(player);
    }

    public void printCurrent(){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < 2 * GRID_SIZE; j++){
                if(j < GRID_SIZE)
                    System.out.print(playerFormation[i][j] + "                        ");
                else
                    System.out.print(monsterFormation[i][j - GRID_SIZE] + "                        ");
            }
            System.out.println("\n\n\n\n");
        }
    }

    public Position getPosition(Unit unit){
        if(unit instanceof Player) {
            for(int i = 0; i < GRID_SIZE; i++){
                for(int j = 0; j < GRID_SIZE; j++){
                    Position position = playerFormation[i][j];
                    if(position.hasPlayer() && position.getOccuppant().equals(unit))
                        return position;
                }
            }
        }
        else{
            for(int i = 0; i < GRID_SIZE; i++){
                for(int j = 0; j < GRID_SIZE; j++){
                    Position position = monsterFormation[i][j];
                    if(position.hasMob() && position.getOccuppant().equals(unit))
                        return position;
                }
            }
        }
        return null;
    }

    void printInitial(List<Integer> chosenOnes){
        int c = 1;
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                if(playerFormation[i][j].hasPlayer()) {
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
