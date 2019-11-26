package abilities;

import battleground.Location;
import characters.*;

public interface Skill {
    public void computeDamage();
    public int applyRaceModifier(Knight knight);
    public int applyRaceModifier(Rogue rogue);
    public int applyRaceModifier(Pyromancer pyromancer);
    public int applyRaceModifier(Wizard wizard);
    public void modifyBaseDamage();
    public float acceptCellModifier(Location location);
}
