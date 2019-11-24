package abilities;

import characters.*;

public interface Skill {
    public void computeDamage();
    public int applyRaceModifier(Knight knight);
    public int applyRaceModifier(Rogue rogue);
    public int applyRaceModifier(Pyromancer pyromancer);
    public int applyRaceModifier(Wizard wizard);

}
