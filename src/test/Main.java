package test;

import test.Skills.Damage;
import test.Skills.Skill;
import test.Units.Mob;
import test.Units.Player;
import test.Units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Main
{





    public static void main(String[] args)
    {
        List<Unit> players = new ArrayList<>();
        List<Unit> mobs = new ArrayList<>();

        Player p = new Player("p1", "fighter");
        players.add(p);

        Mob m = new Mob("ranger", 2);
        mobs.add(m);

        p.enterDungeon();
        m.enterDungeon();

        System.out.println(p.printHPAndMana());
        System.out.println(m.printHPAndMana());

        Skill attack = new Damage(5);

        p.interactWith(m, attack);

        System.out.println(p.printHPAndMana());
        System.out.println(m.printHPAndMana());

        p.interactWith(m, attack);

        System.out.println(p.printHPAndMana());
        System.out.println(m.printHPAndMana());


        p.interactWith(m, attack);

        System.out.println(p.printHPAndMana());
        System.out.println(m.printHPAndMana());

        p.interactWith(m, attack);

        System.out.println(p.printHPAndMana());
        System.out.println(m.printHPAndMana());


    }
}
