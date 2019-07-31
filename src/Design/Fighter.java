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
        super(30,10,15,10,5);
        this.setLevel(1);

    }

    public Fighter(int level){
        //TODO: generate stats for each level of the fighter
        super(30+level*3,10,15+level,10,5);
    }

    @Override
    public String toString() {
        return "Fighter";
    }
}
