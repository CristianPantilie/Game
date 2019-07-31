package Design;

public class Player
{
    private AbstractHero playerClass;
    private AbstractHero dungeonCopy;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", level: ").append(level).append(", gold: ").append(gold).append( ". ");
        sb.append( playerClass.toString());
        return sb.toString();
    }

    public AbstractHero getHero(){
        return playerClass;
    }



    int getLevel(){ return level; }
    public String getName(){ return name; }
}
