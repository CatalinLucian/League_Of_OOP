package abilities.wizard;

import Constants.WizardConstants;
import abilities.Skill;
import characters.*;

public class Deflect implements Skill {

    private final Wizard wizard;
    private float baseDamage = WizardConstants.DEFLECT_PERCENT;

    public Deflect(Wizard wizard) {
        this.wizard = wizard;
    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        return Math.round(this.baseDamage * 1.4f);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        return Math.round(this.baseDamage * 1.2f);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        return Math.round(this.baseDamage * 1.3f);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        return 0;
    }

}
