package abilities.rogue;

import Constants.PyromancerConstants;
import Constants.RogueConstants;
import abilities.Effect;
import abilities.Skill;
import abilities.damage.DamagePerTurn;
import battleground.Location;
import characters.*;

public class Paralysis extends Effect implements Skill {

    private final Rogue rogue;
    private int noOfRounds = 3;
    private float baseDamage = RogueConstants.BASE_DAMAGE_PARALYSIS_PER_ROUND;
    private Effect effect;



    public Paralysis(Rogue rogue) {
        super(3);
        this.rogue = rogue;
    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        float woodsAmplification = this.acceptCellModifier(this.rogue.getCoords().getLoc());
        knight.setEffectSuffered(this);
        return Math.round(this.baseDamage * 0.8f * woodsAmplification);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        float woodsAmplification = this.acceptCellModifier(this.rogue.getCoords().getLoc());
        rogue.setEffectSuffered(this);
        return Math.round(this.baseDamage * 0.9f * woodsAmplification);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        float woodsAmplification = this.acceptCellModifier(this.rogue.getCoords().getLoc());
        pyromancer.setEffectSuffered(this);
        return Math.round(this.baseDamage * 1.2f * woodsAmplification);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        float woodsAmplification = this.acceptCellModifier(this.rogue.getCoords().getLoc());
        wizard.setEffectSuffered(this);
        return Math.round(this.baseDamage * 1.25f * woodsAmplification);
    }

    @Override
    public void modifyBaseDamage() {
        this.baseDamage = RogueConstants.BASE_DAMAGE_PARALYSIS_PER_ROUND +
                rogue.getLevel() * RogueConstants.ADD_TO_BASE_DAMAGE_PARALYSIS_PER_LEVEL;
    }

    public float acceptCellModifier(Location location) {
        return location.cellModifier(this);
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect() {
        this.effect = new DamagePerTurn(2, RogueConstants.BASE_DAMAGE_PARALYSIS_PER_ROUND + rogue.getLevel() * RogueConstants.ADD_TO_BASE_DAMAGE_PARALYSIS_PER_LEVEL);
    }

    public Rogue getRogue() {
        return rogue;
    }

    public int getNoOfRounds() {
        return noOfRounds;
    }

    public float getBaseDamage() {
        return baseDamage;
    }
}
