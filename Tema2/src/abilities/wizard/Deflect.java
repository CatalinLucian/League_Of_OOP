package abilities.wizard;

import Constants.WizardConstants;
import abilities.Skill;
import battleground.Location;
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
        float desertAmplification = this.acceptCellModifier(this.wizard.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.4f * desertAmplification);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        float desertAmplification = this.acceptCellModifier(this.wizard.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.2f * desertAmplification);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        float desertAmplification = this.acceptCellModifier(this.wizard.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.3f * desertAmplification);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        return 0;
    }

    @Override
    public void modifyBaseDamage() {
        this.baseDamage = WizardConstants.DEFLECT_PERCENT +
                wizard.getLevel() * WizardConstants.ADD_TO_DEFLECT_PER_LEVEL;
    }

    public float acceptCellModifier(Location location) {
        return location.cellModifier(this);
    }

}
