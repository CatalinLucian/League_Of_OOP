package abilities.wizard;

import Constants.KnightConstants;
import Constants.WizardConstants;
import abilities.Skill;
import characters.*;

public class Drain implements Skill {

    private final Wizard wizard;
    private float baseDamage = WizardConstants.DRAIN_PERCENT;

    public Drain(Wizard wizard) {
        this.wizard = wizard;
    }

//    public float minDrain(Hero hero) {
//        if(0.3f * hero.getInitialHP() > hero.getHp()) {
//            return hero.getHp();
//        }
//        else return 0.3f * hero.getInitialHP();
//    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        return Math.round(Math.min(0.3f * knight.getInitialHP(), knight.getHp()) * this.baseDamage * 1.2f);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        return Math.round(Math.min(0.3f * rogue.getInitialHP(), rogue.getHp()) * this.baseDamage * 0.8f);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        return Math.round(Math.min(0.3f * pyromancer.getInitialHP(), pyromancer.getHp()) * this.baseDamage * 0.9f);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        return Math.round(Math.min(0.3f * wizard.getInitialHP(), wizard.getHp()) * this.baseDamage * 1.05f);
    }

    public void modifyBaseDamage() {
        this.baseDamage = WizardConstants.DRAIN_PERCENT +
                wizard.getLevel() * WizardConstants.ADD_TO_DRAIN_PER_LEVEL;
    }
}
