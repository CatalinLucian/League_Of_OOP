package characters;

import abilities.Skill;
import abilities.wizard.Deflect;
import abilities.wizard.Drain;

public class Wizard extends Hero {

    private float hp;
    private final Skill firstSkill = new Drain(this);
    private final Skill secondSkill = new Deflect(this);
    private boolean isDead = false;

    Wizard(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP);
    }

    public Wizard(final int initialHP) {
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
    public int acceptRaceModifier(Skill skill) {
        return skill.applyRaceModifier(this);
    }

    @Override
    public Skill getFirstSkill() {
        return firstSkill;
    }

    @Override
    public Skill getSecondSkill() {
        return secondSkill;
    }

    public void setIsDead() {
        isDead = true;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "hp=" + hp +
                '}';
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }
}
