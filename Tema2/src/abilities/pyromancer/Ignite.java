package abilities.pyromancer;

import Constants.PyromancerConstants;
import abilities.Skill;
import characters.*;

public class Ignite implements Skill {

    private final Pyromancer pyromancer;
    private float baseDamage = PyromancerConstants.BASE_DAMAGE_IGNITE;

    public Ignite(Pyromancer pyromancer) {
        this.pyromancer = pyromancer;
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
