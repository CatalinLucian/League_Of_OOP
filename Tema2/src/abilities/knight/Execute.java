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
        if(this.baseDamage >= calculateHPLimit(knight)) {
            knight.setIsDead();
            return 0;
        }
        return Math.round(this.baseDamage);
    }
    public int applyRaceModifier(Pyromancer pyromancer) {
        if(this.baseDamage >= calculateHPLimit(knight)) {
            pyromancer.setIsDead();
            return 0;
        }
        return Math.round(this.baseDamage * 1.1f);
    }
    public int applyRaceModifier(Rogue rogue) {
        if(this.baseDamage >= calculateHPLimit(knight)) {
            knight.setIsDead();
        }
        return Math.round(this.baseDamage * 1.15f);
    }

    public int applyRaceModifier(Wizard wizard) {
        if(this.baseDamage >= calculateHPLimit(knight)) {
            wizard.setIsDead();
            return 0;
        }
        return Math.round(this.baseDamage * 0.8f);
    }

    public void modifyBaseDamage() {
        this.baseDamage = KnightConstants.BASE_DAMAGE_EXECUTE +
                knight.getLevel() * KnightConstants.ADD_TO_EXECUTE_PER_LEVEL;
    }

    public static void main(String[] args) {
        Hero k = new Knight(900);
        Hero r  = new Wizard(500);
        System.out.println(k.acceptRaceModifier(r.getFirstSkill()));
    }

    public String toString() {
        return "muie";
    }
}
