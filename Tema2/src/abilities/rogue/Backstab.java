package abilities.rogue;

import Constants.RogueConstants;
import abilities.Skill;
import battleground.Location;
import battleground.Woods;
import characters.*;

public class Backstab implements Skill {

    private static int k = 0;
    private final Rogue rogue;
    private float baseDamage = RogueConstants.BASE_DAMAGE_BACKSTAB;

    public Backstab(Rogue rogue) {
        this.rogue = rogue;
    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        float woodsAmplification = this.acceptCellModifier(this.rogue.getCoords().getLoc());
        if(rogue.getCoords().getLoc() instanceof Woods && checkForCritical() == 1) {
            Backstab.k++;
            return Math.round(this.baseDamage * 0.9f * woodsAmplification * 1.5f);
        }
        Backstab.k++;
        return Math.round(this.baseDamage * 0.9f * woodsAmplification);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        float woodsAmplification = this.acceptCellModifier(this.rogue.getCoords().getLoc());
        if(rogue.getCoords().getLoc() instanceof Woods && checkForCritical() == 1) {
            Backstab.k++;
            return Math.round(this.baseDamage * 1.2f * woodsAmplification * 1.5f);
        }
        return Math.round(this.baseDamage * 1.2f * woodsAmplification);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        float woodsAmplification = this.acceptCellModifier(this.rogue.getCoords().getLoc());
        if(rogue.getCoords().getLoc() instanceof Woods && checkForCritical() == 1) {
            Backstab.k++;
            return Math.round(this.baseDamage * 1.25f * woodsAmplification * 1.5f);
        }
        return Math.round(this.baseDamage * 1.25f * woodsAmplification);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        float woodsAmplification = this.acceptCellModifier(this.rogue.getCoords().getLoc());
        if(rogue.getCoords().getLoc() instanceof Woods && checkForCritical() == 1) {
            Backstab.k++;
            return Math.round(this.baseDamage * 1.25f * woodsAmplification * 1.5f);
        }
        return Math.round(this.baseDamage * 1.25f * woodsAmplification );
    }

    @Override
    public void modifyBaseDamage() {
        this.baseDamage = RogueConstants.BASE_DAMAGE_BACKSTAB +
                rogue.getLevel() * RogueConstants.ADD_TO_BACKSTAB_PER_LEVEL;
    }

    @Override
    public float acceptCellModifier(Location location) {
        return location.cellModifier(this);
    }

    private int checkForCritical() {
        if(k % 3 == 0) return 1;
            return 1;
    }

    public Rogue getRogue() {
        return rogue;
    }

    public float getBaseDamage() {
        return baseDamage;
    }
}
