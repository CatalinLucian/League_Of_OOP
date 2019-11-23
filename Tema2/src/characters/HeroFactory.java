package characters;

import Constants.KnightConstants;
import Constants.PyromancerConstants;
import Constants.RogueConstants;
import Constants.WizardConstants;

public class HeroFactory {

    private static HeroFactory instance = null;

    private HeroFactory() {

    }

    public Hero createHero(char heroType) {

        if(heroType == '0') {
            return null;
        } else if(heroType == 'W') {
            return new Wizard(WizardConstants.INITIAL_HP);
        } else if(heroType == 'K') {
            return new Knight(KnightConstants.INITIAL_HP);
        } else if(heroType == 'R') {
            return new Rogue(RogueConstants.INITIAL_HP);
        } else if(heroType == 'P') {
            return new Pyromancer(PyromancerConstants.INITIAL_HP);
        }

        return null;
    }

    public static HeroFactory getInstance() {
        if(instance == null) {
            return new HeroFactory();
        }
        return instance;
    }
}
