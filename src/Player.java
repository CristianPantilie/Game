public class Player
{
    private final AbstractHero playerClass;
    private final String name;

    //attributes
    private int xp;
    private int xpToNextLevel;
    private int level;
    private int statPoints;
    private int skillPoints;
    private int statPointsPerLevel;
    private int skillPointsPerLevel;  //subunitar, sa se poata lua un skill la cateva nivele
    private int gold;

    public Player(String playerClass, String name) {

        switch (playerClass){
            case "FIGHTER":
                this.playerClass = new Fighter();
                break;
            case "RANGER":
                this.playerClass = new Ranger();
                break;
            case "MAGE":
                this.playerClass = new Mage();
                break;
            default:
                this.playerClass = new Fighter();
                break;
        }


        this.name = name;
        this.level = 1;
        this.gold = 10;
    }

    AbstractHero getHero(){
        return playerClass;
    }
}
