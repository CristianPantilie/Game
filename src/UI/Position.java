package UI;

import Design.Units.Mob;
import Design.Units.Player;
import Design.Units.Unit;

public class Position {
    private final int row;
    private final int column;
//    private Unit mob;
//    private Unit player;
    private Unit occuppant;

    Position(int row, int column){
        this.row = row;
        this.column = column;
//        mob = null;
//        player = null;
        occuppant = null;
    }

    @Override
    public String toString() {
//        if(this.player != null)
//            return player.getName();
//        else if(this.mob != null)
//            return mob.toString();
        if((occuppant != null) && !occuppant.isDead())
            return occuppant.printHPAndMana();
        else
            return "***";
    }

    public boolean isInMelee(){
        if(occuppant instanceof Player)
            return this.column == FightPlane.GRID_SIZE - 1;
        else
            return this.column == 0;
    }

    public int distanceFrom(Position position){
        int rightColumn = position.column + FightPlane.GRID_SIZE;

        return Math.abs(position.row - this.row) + Math.abs(rightColumn - this.column);
    }

    void add(Unit unit){
        this.occuppant = unit;
    }

    boolean hasMob(){
        return (occuppant != null && occuppant instanceof Mob);
    }

    boolean hasPlayer(){
        return (occuppant != null && occuppant instanceof Player);
    }

    Unit getOccuppant(){ return occuppant;}

}
