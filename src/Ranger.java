public class Ranger extends AbstractHero
{
    void addSkill(Skill s){
        if(!s.getType().equals("FIGHTER") || !s.getType().equals("RANGED")){
            System.out.println("Incompatible skill");
            return;
        }
        super.addSkill(s);
    }
}
