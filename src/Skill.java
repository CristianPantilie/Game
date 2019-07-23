public class Skill {


    private final int  manaCost;
    private final int levelRequirement;
    private final String type;

    private int numberOfTargets;
    private int damageAmount;
    private int healAmount;
    private int shieldAmount;


    public Skill(int manaCost, int levelRequirement, String type, int numberOfTargets, int damageAmount, int healAmount, int shieldAmount) {
        this.manaCost = manaCost;
        this.levelRequirement = levelRequirement;
        this.type = type;
        this.numberOfTargets = numberOfTargets;
        this.damageAmount = damageAmount;
        this.healAmount = healAmount;
        this.shieldAmount = shieldAmount;
    }

    public Skill(AbstractHero p, Skill s){
        this.manaCost = s.manaCost;
        this.levelRequirement = s.levelRequirement;
        this.type = s.type;
        //TODO: copiaza chestiile de baza din s si le modifica pentru eroul p pe baza statsurilor
    }

    void activate(AbstractHero target){
        target.decreaseHitPoints(damageAmount);
        target.increaseHitPoints(healAmount);
        //TODO: shield (trebuie cu timp sau ceva)
    }

    String getType(){
        return type;
    }








}
