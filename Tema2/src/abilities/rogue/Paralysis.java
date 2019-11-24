package abilities.rogue;

import Constants.RogueConstants;
import abilities.Skill;
import characters.*;

public class Paralysis implements Skill {

    private final Rogue rogue;
    private float baseDamage = RogueConstants.BASE_DAMAGE_PARALYSIS_PER_ROUND;

    public Paralysis(Rogue rogue) {
        this.rogue = rogue;
    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        return Math.round(this.baseDamage * 0.8f);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        return Math.round(this.baseDamage * 0.9f);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        return Math.round(this.baseDamage * 1.2f);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        return Math.round(this.baseDamage * 1.25f);
    }

}
