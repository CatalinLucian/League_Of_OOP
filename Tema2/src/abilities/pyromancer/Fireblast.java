package abilities.pyromancer;

import Constants.PyromancerConstants;
import abilities.Skill;
import battleground.Location;
import characters.*;

public class Fireblast implements Skill {

    private final Pyromancer pyromancer;
    private float baseDamage = PyromancerConstants.BASE_DAMAGE_FIREBLAST;

    public Fireblast(Pyromancer pyromancer) {
        this.pyromancer = pyromancer;
    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        float volcanicAmplification = this.acceptCellModifier(this.pyromancer.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.2f * volcanicAmplification);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        float volcanicAmplification = this.acceptCellModifier(this.pyromancer.getCoords().getLoc());
        return Math.round(this.baseDamage * 0.8f * volcanicAmplification);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        float volcanicAmplification = this.acceptCellModifier(this.pyromancer.getCoords().getLoc());
        return Math.round(this.baseDamage * 0.9f * volcanicAmplification);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        float volcanicAmplification = this.acceptCellModifier(this.pyromancer.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.05f * volcanicAmplification);
    }

    @Override
    public void modifyBaseDamage() {
        this.baseDamage = PyromancerConstants.BASE_DAMAGE_FIREBLAST +
                pyromancer.getLevel() * PyromancerConstants.ADD_TO_FIREBLAST_PER_LEVEL;
    }

    @Override
    public float acceptCellModifier(Location location) {
        return location.cellModifier(this);
    }

    public Pyromancer getPyromancer() {
        return pyromancer;
    }

    public float getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(float baseDamage) {
        this.baseDamage = baseDamage;
    }
}
