package characters;

import abilities.Skill;
import abilities.wizard.Deflect;
import abilities.wizard.Drain;

public class Wizard extends Hero {

    private float hp;
    private final Skill deflect = new Deflect(this);
    private final Skill drain = new Drain(this);

    Wizard(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP);
    }

    Wizard(final int initialHP) {
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
