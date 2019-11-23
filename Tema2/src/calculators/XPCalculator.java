package calculators;

import characters.Hero;

public class XPCalculator {
    private static XPCalculator instance = null;

    private XPCalculator() {

    }

    public void calculateXPWinner(Hero winner, Hero loser) {
        int formula = 200 - (winner.getLevel() - loser.getLevel()) * 40;
        int max;
        if(0 > formula) {
             max = 0;
        } else {
             max = formula;
        }
        winner.setXp(winner.getXp() + max);
    }

    public static XPCalculator getInstance() {
        if(instance == null) {
            return new XPCalculator();
        }
        return instance;
    }

}
