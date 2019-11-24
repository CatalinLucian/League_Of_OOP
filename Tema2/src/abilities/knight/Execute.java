package abilities.knight;

import Constants.KnightConstants;
import abilities.Skill;
import characters.*;

public class Execute implements Skill {

    private final Knight knight;
    private float baseDamage = KnightConstants.BASE_DAMAGE_EXECUTE;

    public Execute(Knight knight) {
        this.knight = knight;
    }

    public float calculateHPLimit(Hero hero) {
        return 0.2f * hero.getInitialHP() + 0.01f * hero.getLevel();
    }

    @Override
    public void computeDamage() {

    }

    public int applyRaceModifier(Knight knight) {
        return Math.round(this.baseDamage);
    }
    public int applyRaceModifier(Pyromancer pyromancer) {
        return Math.round(this.baseDamage * 1.1f);
    }
    public int applyRaceModifier(Rogue rogue) {
        return Math.round(this.baseDamage * 1.15f);
    }

    public int applyRaceModifier(Wizard wizard) {
        return Math.round(this.baseDamage * 0.8f);
    }

    public void modifyBaseDamage(Knight knight) {
        this.baseDamage = KnightConstants.BASE_DAMAGE_EXECUTE +
                knight.getLevel() * KnightConstants.ADD_TO_EXECUTE_PER_LEVEL;
    }
}
