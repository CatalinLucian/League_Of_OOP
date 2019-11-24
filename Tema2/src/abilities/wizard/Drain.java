package abilities.wizard;

import Constants.WizardConstants;
import abilities.Skill;
import characters.*;

public class Drain implements Skill {

    private final Wizard wizard;
    private float baseDamage = WizardConstants.DRAIN_PERCENT;

    public Drain(Wizard wizard) {
        this.wizard = wizard;
    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        return Math.round(this.baseDamage * 1.2f);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        return Math.round(this.baseDamage * 0.8f);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        return Math.round(this.baseDamage * 0.9f);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        return Math.round(this.baseDamage * 1.05f);
    }
    
}
