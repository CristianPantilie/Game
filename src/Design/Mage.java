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
        super(20,30,5,10,15);
        this.setLevel(1);
    }

    public Mage(int level){
        //TODO: generate stats for each level of the mage
        super(20+level*2,30+level*3,5,10,15+level*2);
    }

    @Override
    public String toString() {
        return "Mage";
    }
}
