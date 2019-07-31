package Design;

public class Mage extends AbstractHero
{
    void addSkill(Skill s){
        if(!s.getType().equals("RANGED")){
            System.out.println("Incompatible skill");
            return;
        }
        super.addSkill(s);
    }

    public Mage(){
        this(1);
    }

    public Mage(int level){
        //TODO: generate stats for each level of the mage
    }

    @Override
    public String toString() {
        return "Mage";
    }
}
