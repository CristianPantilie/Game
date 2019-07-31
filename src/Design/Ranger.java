package Design;

public class Ranger extends AbstractHero
{
    void addSkill(Skill s){
        if(s.getType().equals("FIGHTER")){
            System.out.println("Incompatible skill");
            return;
        }
        super.addSkill(s);
    }

    public Ranger(){
        super(25,20,10,15,5);
        this.setLevel(1);
    }

    public Ranger(int level){
        //TODO: generate stats for each level of the ranger
        super(25+level*2,20,10,15+level*2,5);
    }

    @Override
    public String toString() {
        return "Ranger";
    }
}
