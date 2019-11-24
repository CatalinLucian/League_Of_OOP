package characters;

import abilities.Skill;
import abilities.knight.Execute;
import abilities.knight.Slam;

public class Knight extends Hero {

    private float hp;
    private final Skill execute = new Execute(this);
    private final Skill slam = new Slam(this);

    Knight(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP);
    }

    public Knight(final int initialHP) {
        super(initialHP);
    }

    @Override
    public void acceptFight(Hero hero) {
        hero.fight(this);
    }

    @Override
    public void fight(Knight knight) {

    }
    @Override
    public void fight(Pyromancer pyromancer) {

    }
    @Override
    public void fight(Wizard wizard) {

    }
    @Override
    public void fight(Rogue rogue) {

    }

    @Override
    public void acceptRaceModifier(Skill skill) {
        skill.applyRaceModifier(this);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "hp=" + hp +
                '}';
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

//    public void initSkillsForHero() {
//        this.execute.
//    }
}
