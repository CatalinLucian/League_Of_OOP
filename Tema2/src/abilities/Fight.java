package abilities;

import battleground.Location;
import calculators.XPCalculator;
import characters.Hero;

public class Fight {
    private Hero first;
    private Hero second;

    public Fight(Hero first, Hero second) {
        this.first = first;
        this.second = second;
    }

    public void fight() {
        int damageToFirstFrom1Skill = first.acceptRaceModifier(second.getFirstSkill());
        int damageToFirstFrom2Skill = first.acceptRaceModifier(second.getSecondSkill());
        int damageToSecondFrom1Skill = second.acceptRaceModifier(first.getFirstSkill());
        int damageToSecondFrom2Skill = second.acceptRaceModifier(first.getSecondSkill());
        int TotalDamageTo1 = damageToFirstFrom1Skill + damageToFirstFrom2Skill;
        int TotalDamageTo2 = damageToSecondFrom1Skill + damageToSecondFrom2Skill;
        updateHp(TotalDamageTo1, TotalDamageTo2);
        fightAfterMath();
    }

    public void updateHp(int damageTo1, int damageTo2) {
        first.setHp(first.getHp() - damageTo1);
        second.setHp(second.getHp() - damageTo2);
        if(first.getHp() <= 0) {
            first.setIsDead(true);
        }
        if(second.getHp() <= 0) {
            second.setIsDead(true);
        }
    }

    public void fightAfterMath() {
        XPCalculator xpCalculator = XPCalculator.getInstance();
        if(first.isDead()) {
            xpCalculator.calculateXPWinner(second, first);
        }
        if(second.isDead()) {
            xpCalculator.calculateXPWinner(first, second);
        }
    }
}
