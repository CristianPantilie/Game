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
        this(1);
    }

    public Ranger(int level){
        //TODO: generate stats for each level of the ranger
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
