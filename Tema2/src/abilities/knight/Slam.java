package abilities.knight;

import Constants.KnightConstants;
import abilities.Skill;
import characters.*;

public class Slam implements Skill {

    private final Knight knight;
    private float baseDamage = KnightConstants.BASE_DAMAGE_SLAM;

    public Slam(Knight knight) {
        this.knight = knight;
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
        return Math.round(this.baseDamage * 0.95f);
    }

}
