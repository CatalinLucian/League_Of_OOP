package abilities.pyromancer;

import Constants.PyromancerConstants;
import abilities.Effect;
import abilities.Skill;
import abilities.damage.DamagePerTurn;
import battleground.Location;
import characters.*;

public class Ignite implements Skill {

    private final Pyromancer pyromancer;
    private float baseDamage = PyromancerConstants.BASE_DAMAGE_IGNITE;
    private Effect effect;

    public Ignite(Pyromancer pyromancer) {
        this.pyromancer = pyromancer;
    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        float volcanicAmplification = this.acceptCellModifier(this.pyromancer.getCoords().getLoc());
        this.setEffect();
        knight.setEffectSuffered(effect);
        return Math.round(this.baseDamage * 1.2f * volcanicAmplification);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        float volcanicAmplification = this.acceptCellModifier(this.pyromancer.getCoords().getLoc());
        this.setEffect();
        rogue.setEffectSuffered(effect);
        return Math.round(this.baseDamage * 0.8f * volcanicAmplification);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        float volcanicAmplification = this.acceptCellModifier(this.pyromancer.getCoords().getLoc());
        this.setEffect();
        pyromancer.setEffectSuffered(effect);
        return Math.round(this.baseDamage * 0.9f * volcanicAmplification);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        float volcanicAmplification = this.acceptCellModifier(this.pyromancer.getCoords().getLoc());
        this.setEffect();
        wizard.setEffectSuffered(effect);
        return Math.round(this.baseDamage * 1.05f * volcanicAmplification);
    }

    @Override
    public void modifyBaseDamage() {
        this.baseDamage = PyromancerConstants.BASE_DAMAGE_IGNITE +
                pyromancer.getLevel() * PyromancerConstants.ADD_TO_IGNITE_PER_LEVEL;
    }

    @Override
    public float acceptCellModifier(Location location) {
        return location.cellModifier(this);
    }

    public float getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(float baseDamage) {
        this.baseDamage = baseDamage;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect() {
        this.effect = new DamagePerTurn(2,PyromancerConstants.IGNITE_EFFECT_PER_ROUND + pyromancer.getLevel() * PyromancerConstants.ADD_TO_IGNITE_EFFECT_PER_LEVEL);
    }

    public Pyromancer getPyromancer() {
        return pyromancer;
    }
}
