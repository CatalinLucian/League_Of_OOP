package abilities.rogue;

import Constants.RogueConstants;
import abilities.Skill;
import characters.*;

public class Backstab implements Skill {

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
        return Math.round(this.baseDamage * 0.9f);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        return Math.round(this.baseDamage * 1.2f);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        return Math.round(this.baseDamage * 1.25f);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        return Math.round(this.baseDamage * 1.25f);
    }

    @Override
    public void modifyBaseDamage() {
        this.baseDamage = RogueConstants.BASE_DAMAGE_BACKSTAB +
                rogue.getLevel() * RogueConstants.ADD_TO_BACKSTAB_PER_LEVEL;
    }
}
