package main;

import battleground.Battleground;
import characters.Directions;
import characters.Hero;
import characters.HeroFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private GameInput input;
    private List<Hero> heroes;
    private Battleground battleground;

    Game(GameInput input) {
        this.input = input;
        initBattleground();
        initHeroes();
        initHeroesAndMoves();
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
        heroes = new ArrayList<>();
        for (Character hero : input.getHeroList()) {
            heroes.add(HeroFactory.getInstance().createHero(hero));
        }
    }

    private void initHeroesAndMoves() {

        int i = 0;
        for (Hero hero : this.getHeroes()){
            List<Directions> directions = new ArrayList<>();
            for (String str : input.getHeroesMoves()) {
                if (str.charAt(i) == 'R') {
                    directions.add(Directions.R);
                }
                if (str.charAt(i) == 'L') {
                    directions.add(Directions.L);
                }
                if (str.charAt(i) == 'U') {
                    directions.add(Directions.U);
                }
                if (str.charAt(i) == 'D') {
                    directions.add(Directions.R);
                }
                if (str.charAt(i) == '_') {
                    directions.add(Directions.STAY);
                }
            }
            i++;
            hero.setMoves(directions);
        }
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
