public class Fighter extends AbstractHero
{

    void addSkill(Skill s){
        if(!s.getType().equals("MELEE")){
            System.out.println("Incompatible skill");
            return;
        }
        super.addSkill(s);
    }

}
