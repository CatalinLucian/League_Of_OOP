package calculators;

import characters.Hero;

public class LevelCalculator {

    private static LevelCalculator instance = null;
    private LevelCalculator() {

    }

    public static LevelCalculator getInstance() {
        if(instance == null) {
            return new LevelCalculator();
        }
        return instance;
    }
    public void LevelUp(Hero hero) {
        int xpLevelUp = 250 + hero.getLevel() * 50;
        if(hero.getXp() > xpLevelUp) {
            hero.setLevel(hero.getLevel() + 1);
        }
    }
}
