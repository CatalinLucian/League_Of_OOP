package characters;

import Constants.WizardConstants;
import abilities.Skill;
import abilities.wizard.Deflect;
import abilities.wizard.Drain;

public class Wizard extends Hero {

    private int hp = WizardConstants.INITIAL_HP;
    private final Skill firstSkill = new Drain(this);
    private final Skill secondSkill = new Deflect(this);

    Wizard(PositionOnBattleground coords, int initialHP) {
        super(coords, initialHP, 'W');
    }

    public Wizard(final int initialHP) {
        super(initialHP, 'W');
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
