package Main;

import battleground.Battleground;
import characters.Hero;
import characters.HeroFactory;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game instance = null;
    private static GameInput input;
    private static List<Hero> heroes;
    private static Battleground battleground;

    private Game() {
        initBattleground();
        initHeroes();
        initInitialPositions();
    }

    private void initBattleground() {
        battleground = Battleground.getInstance();
    }

    private void initInitialPositions() {
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).setCoords(input.getInitialPositions().get(i));
        }
    }

    private void initHeroes() {
        this.heroes = new ArrayList<>();
        for (Character hero : input.getHeroList()) {
            heroes.add(HeroFactory.getInstance().createHero(hero));
        }
    }

    public static Game getInstance() {
        if(instance == null) {
            return new Game();
        }
        return instance;
    }


    public GameInput getInput() {
        return input;
    }


    public List<Hero> getHeroes() {
        return heroes;
    }

    public Battleground getBattleground() {
        return battleground;
    }

}
