package characters;

import abilities.Skill;
import abilities.pyromancer.Fireblast;
import abilities.pyromancer.Ignite;

public class Pyromancer extends Hero {

    private float hp = 500;
    private final Skill firstSkill = new Fireblast(this);
    private final Skill secondSkill = new Ignite(this);
    private boolean isDead = false;

    Pyromancer(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP);
    }

    Pyromancer(final int initialHP) {
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
        return "Pyromancer{" +
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

