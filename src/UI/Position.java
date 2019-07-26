package UI;

import Design.AbstractHero;
import Design.Player;

public class Position {
    private final int x;
    private final int y;
    private AbstractHero mob;
    private Player player;

    Position(int x, int y){
        this.x = x;
        this.y = y;
        mob = null;
        player = null;
    }

    void add(AbstractHero mob){
        this.mob = mob;
    }

    void add(Player player){
        this.player = player;
    }

    boolean hasMob(){
        return mob != null;
    }

    boolean hasPlayer(){
        return player != null;
    }

    AbstractHero getMob(){
        return mob;
    }

    Player getPlayer(){
        return player;
    }

    void delete(){
        mob = null;
        player = null;
    }
}
