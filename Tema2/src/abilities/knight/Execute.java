package abilities.knight;

import Constants.KnightConstants;
import Constants.PyromancerConstants;
import Constants.RogueConstants;
import Constants.WizardConstants;
import abilities.Fight;
import abilities.Skill;
import battleground.Desert;
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
            knight.setIsDead(true);
            return 0;
        }
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * landAmplification);
    }
    public int applyRaceModifier(Pyromancer pyromancer) {
        if(pyromancer.getHp() <= calculateHPLimit(pyromancer)) {
            pyromancer.setIsDead(true);
            return 0;
        }
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.1f * landAmplification);
    }
    public int applyRaceModifier(Rogue rogue) {
        if(rogue.getHp() <= calculateHPLimit(rogue)) {
            rogue.setIsDead(true);
        }
        float landAmplification = this.acceptCellModifier(this.knight.getCoords().getLoc());
        return Math.round(this.baseDamage * 1.15f * landAmplification);
    }

    public int applyRaceModifier(Wizard wizard) {
        if(wizard.getHp() <= calculateHPLimit(wizard)) {
            wizard.setIsDead(true);
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

    public Knight getKnight() {
        return knight;
    }

    public float getBaseDamage() {
        return baseDamage;
    }

    public static void main(String[] args) {
//        Hero k = new Knight(900);
//        Hero r  = new Knight(900);
//        k.setCoords(new PositionOnBattleground(0,0, new Desert()));
//        r.setCoords(new PositionOnBattleground(0,0, new Desert()));
//        int damageTor_1 = r.acceptRaceModifier(k.getFirstSkill());
//        int damageTor_2 = r.acceptRaceModifier(k.getSecondSkill());
//        int dmgFirstRound = damageTor_1 + damageTor_2;
//        int damageTok_1 = k.acceptRaceModifier(r.getFirstSkill());
//        int damageTok_2 = k.acceptRaceModifier(r.getSecondSkill());
//        int damageFirstRound = damageTok_1 + damageTok_2;
//        System.out.println("Damage suferit de r: " + dmgFirstRound);
//        System.out.println("Damage suferi de k: " + damageFirstRound);
//        r.setHp(r.getHp() - dmgFirstRound);
//        k.setHp(k.getHp() - damageFirstRound);
//        int dmgK_2 = k.acceptRaceModifier(r.getFirstSkill()) + k.acceptRaceModifier(r.getSecondSkill());
//        int dmgR_2 = r.acceptRaceModifier(k.getFirstSkill()) + r.acceptRaceModifier(k.getSecondSkill());
//        System.out.println(dmgK_2);
//        System.out.println(dmgR_2);
//        r.setHp(r.getHp() - dmgR_2);
//        k.setHp(k.getHp() - dmgK_2);
//        System.out.println(k);

        Hero k = new Knight(900);
        Hero r  = new Knight(900);
        k.setCoords(new PositionOnBattleground(0,0, new Desert()));
        r.setCoords(new PositionOnBattleground(0,0, new Desert()));
        int noOfRounds = 2;
        for(int i = 0; i < noOfRounds; i++) {
            Fight fight = new Fight(k, r);
            fight.fight();
        }
        System.out.println(k);
        System.out.println(r);
    }

}
