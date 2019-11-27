package abilities.wizard;

import Constants.KnightConstants;
import Constants.WizardConstants;
import abilities.Skill;
import battleground.Location;
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
        float desertAmplification = this.acceptCellModifier(this.wizard.getCoords().getLoc());
        return Math.round(Math.min(0.3f * knight.getInitialHP(), knight.getHp()) * this.baseDamage * 1.2f * desertAmplification);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        float desertAmplification = this.acceptCellModifier(this.wizard.getCoords().getLoc());
        return Math.round(Math.min(0.3f * rogue.getInitialHP(), rogue.getHp()) * this.baseDamage * 0.8f * desertAmplification);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        float desertAmplification = this.acceptCellModifier(this.wizard.getCoords().getLoc());
        return Math.round(Math.min(0.3f * pyromancer.getInitialHP(), pyromancer.getHp()) * this.baseDamage * 0.9f * desertAmplification);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        float desertAmplification = this.acceptCellModifier(this.wizard.getCoords().getLoc());
        return Math.round(Math.min(0.3f * wizard.getInitialHP(), wizard.getHp()) * this.baseDamage * 1.05f * desertAmplification);
    }

    public void modifyBaseDamage() {
        this.baseDamage = WizardConstants.DRAIN_PERCENT +
                wizard.getLevel() * WizardConstants.ADD_TO_DRAIN_PER_LEVEL;
    }

    public float acceptCellModifier(Location location) {
        return location.cellModifier(this);
    }

    public float getBaseDamage() {
        return baseDamage;
    }
}
