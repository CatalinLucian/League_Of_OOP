package abilities.knight;

import Constants.KnightConstants;
import Constants.PyromancerConstants;
import Constants.RogueConstants;
import Constants.WizardConstants;
import abilities.Skill;
import battleground.Land;
import battleground.Location;
import characters.*;

import javax.print.DocFlavor;

public class Execute implements Skill {

    private final Knight knight;
    private float baseDamage = KnightConstants.BASE_DAMAGE_EXECUTE;

    public Execute(Knight knight) {
        this.knight = knight;
    }

    public float calculateHPLimit(Hero hero) {
        if(knight.getLevel() >= 20) {
            return 0.4f * teoreticMaxHp(hero);
        }
        float dmg = 0.2f * teoreticMaxHp(hero) + 0.01f * knight.getLevel();
        return dmg;
    }

    public int teoreticMaxHp(Hero hero) {
        if(hero instanceof Knight) {
            return hero.getInitialHP() + hero.getLevel() * KnightConstants.ADD_HP_PER_LEVEL;
        } else if(hero instanceof Rogue) {
            return hero.getInitialHP() + hero.getLevel() * RogueConstants.ADD_HP_PER_LEVEL;
        } else if(hero instanceof Wizard) {
            return hero.getInitialHP() + hero.getLevel() * WizardConstants.ADD_HP_PER_LEVEL;
        } else if(hero instanceof Pyromancer) {
            return hero.getInitialHP() + hero.getLevel() * PyromancerConstants.ADD_HP_PER_LEVEL;
        }
        return 0;
    }

    @Override
    public void computeDamage() {

    }

    public int applyRaceModifier(Knight knight) {
        if(knight.getHp() <= calculateHPLimit(knight)) {
            knight.setIsDead();
            return 0;
        }
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * landAmplification);
    }
    public int applyRaceModifier(Pyromancer pyromancer) {
        if(pyromancer.getHp() <= calculateHPLimit(pyromancer)) {
            pyromancer.setIsDead();
            return 0;
        }
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.1f * landAmplification);
    }
    public int applyRaceModifier(Rogue rogue) {
        if(rogue.getHp() <= calculateHPLimit(rogue)) {
            rogue.setIsDead();
        }
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.15f * landAmplification);
    }

    public int applyRaceModifier(Wizard wizard) {
        if(wizard.getHp() <= calculateHPLimit(wizard)) {
            wizard.setIsDead();
            return 0;
        }
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 0.8f * landAmplification);
    }

    public void modifyBaseDamage() {
        this.baseDamage = KnightConstants.BASE_DAMAGE_EXECUTE +
                knight.getLevel() * KnightConstants.ADD_TO_EXECUTE_PER_LEVEL;
    }

    @Override
    public float acceptCellModifier(Location location) {
        return location.cellModifier(this);
    }

    public static void main(String[] args) {
        Hero k = new Knight(900);
        Hero r  = new Wizard(400);
        k.setCoords(new PositionOnBattleground(0,0, new Land()));
        r.setCoords(new PositionOnBattleground(0,0, new Land()));
        System.out.println(r.acceptRaceModifier(k.getFirstSkill()));
    }

    public String toString() {
        return "muie";
    }
}
