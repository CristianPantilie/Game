package Design;

import java.util.List;

public class Fight
{
    PlayerGroup playerGroup;
    Group mobGroup;

    //TODO:
    int awardedXP;
    List<Item> awardedItems;

    Fight(PlayerGroup playerGroup, Group mobGroup){
        this.playerGroup = playerGroup;
        this.mobGroup = mobGroup;
    }

    private void oneOnOne(Player player, AbstractHero mob){

    }


}
