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
        hp = initialHP;
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
