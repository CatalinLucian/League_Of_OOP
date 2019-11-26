package characters;

import Constants.KnightConstants;
import abilities.Skill;
import abilities.knight.Execute;
import abilities.knight.Slam;
import battleground.Land;
import battleground.Location;

public class Knight extends Hero {

    private float hp = KnightConstants.INITIAL_HP;
    private Skill firstSkill = new Execute(this);
    private Skill secondSkill = new Slam(this);
    private boolean isDead = false;

    Knight(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP);
    }

    public Knight(final int initialHP) {
        super(initialHP);
        hp = initialHP;
    }



    @Override
    public int acceptRaceModifier(Skill skill) {
        return skill.applyRaceModifier(this);
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

    @Override
    public Skill getFirstSkill() {
        return  firstSkill;
    }

    public void setIsDead() {
        isDead = true;
    }

    @Override
    public Skill getSecondSkill() {
        return secondSkill;
    }
}
