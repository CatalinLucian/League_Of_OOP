package characters;

import Constants.PyromancerConstants;
import abilities.Skill;
import abilities.pyromancer.Fireblast;
import abilities.pyromancer.Ignite;

public class Pyromancer extends Hero {

    private int hp = PyromancerConstants.INITIAL_HP;
    private final Skill firstSkill = new Fireblast(this);
    private final Skill secondSkill = new Ignite(this);

    Pyromancer(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP, 'P');
    }

    Pyromancer(final int initialHP) {
        super(initialHP, 'P');
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


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

