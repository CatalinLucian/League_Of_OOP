package abilities.knight;

import Constants.KnightConstants;
import abilities.Effect;
import abilities.Skill;
import abilities.damage.Incapacity;
import battleground.Location;
import characters.*;

public class Slam implements Skill {

    private final Knight knight;
    private float baseDamage = KnightConstants.BASE_DAMAGE_SLAM;
    private final Effect incapacity = new Incapacity(1);

    public Slam(Knight knight) {
        this.knight = knight;
    }

    @Override
    public void computeDamage() {

    }

    @Override
    public int applyRaceModifier(Knight knight) {
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.2f * landAmplification);
    }

    @Override
    public int applyRaceModifier(Rogue rogue) {
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 0.8f * landAmplification);
    }

    @Override
    public int applyRaceModifier(Pyromancer pyromancer) {
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 0.9f * landAmplification);
    }

    @Override
    public int applyRaceModifier(Wizard wizard) {
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.05f * landAmplification);
    }

    public void modifyBaseDamage() {
        this.baseDamage = KnightConstants.BASE_DAMAGE_SLAM +
                knight.getLevel() * KnightConstants.ADD_TO_SLAM_PER_LEVEL;
    }

    @Override
    public float acceptCellModifier(Location location) {
        return location.cellModifier(this);
    }

    public Knight getKnight() {
        return knight;
    }

    public float getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(float baseDamage) {
        this.baseDamage = baseDamage;
    }

    public Effect getIncapacity() {
        return incapacity;
    }
}
