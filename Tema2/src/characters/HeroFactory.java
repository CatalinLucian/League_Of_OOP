package characters;

public class HeroFactory {

    private static HeroFactory instance = null;

    private HeroFactory() {

    }

    public Hero createHero(char heroType) {

        if(heroType == '0') {
            return null;
        } else if(heroType == 'W') {
            return new Wizard();
        } else if(heroType == 'K') {
            return new Knight();
        } else if(heroType == 'R') {
            return new Rogue();
        } else if(heroType == 'P') {
            return new Pyromancer();
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
