package Design;

public class Fighter extends AbstractHero
{

    void addSkill(Skill s){
        if(!s.getType().equals("MELEE")){
            System.out.println("Incompatible skill");
            return;
        }
        super.addSkill(s);
    }

    public Fighter(){
        this(1);
    }

    public Fighter(int level){
        //TODO: generate stats for each level of the fighter
    }

    @Override
    public String toString() {
        return "Fighter";
    }
}
