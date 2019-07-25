package Design;

public class Player
{
    private final AbstractHero playerClass;
    private final String name;

    //attributes
    private int xp;
    private int xpToNextLevel;
    private int statPoints;
    private int skillPoints;
    private int statPointsPerLevel;
    private int skillPointsPerLevel;  //subunitar, sa se poata lua un skill la cateva nivele
    private int gold;
    private int level;

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
        this.gold = 10;
        this.level = 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", level: ").append(level).append(", gold: ").append(gold).append( ". ");
        sb.append( playerClass.toString());
        return sb.toString();
    }

    AbstractHero getHero(){
        return playerClass;
    }



    int getLevel(){ return level; }
    String getName(){ return name; }

    public void levelUp(){
        this.level++;
        if (this.playerClass.equals("FIGHTER")){
            this.playerClass.setHitPoints(this.playerClass.getHitPoints()+3);
            this.playerClass.setMana(this.playerClass.getMana()+1);
            this.playerClass.setStrength(this.playerClass.getStrength()+2);
            this.playerClass.setDexterity(this.playerClass.getDexterity()+1);
            this.playerClass.setIntelligence(this.playerClass.getIntelligence()+1); }
        if (this.playerClass.equals("RANGER")){
            this.playerClass.setHitPoints(this.playerClass.getHitPoints()+2);
            this.playerClass.setMana(this.playerClass.getMana()+1);
            this.playerClass.setStrength(this.playerClass.getStrength()+1);
            this.playerClass.setDexterity(this.playerClass.getDexterity()+2);
            this.playerClass.setIntelligence(this.playerClass.getIntelligence()+1); }
        if (this.playerClass.equals("MAGE")){
            this.playerClass.setHitPoints(this.playerClass.getHitPoints()+1);
            this.playerClass.setMana(this.playerClass.getMana()+3);
            this.playerClass.setStrength(this.playerClass.getStrength()+1);
            this.playerClass.setDexterity(this.playerClass.getDexterity()+1);
            this.playerClass.setIntelligence(this.playerClass.getIntelligence()+2); }
}
