package main;

import abilities.Fight;
import characters.Hero;
import characters.HeroManager;

public class GameLogic {

    private HeroManager heroes;
    private GameInput input;

    public GameLogic(GameInput input, HeroManager heroes) {
        this.input = input;
        this.heroes = heroes;
    }

    public void startGame() {
        Game game = Game.getInstance(input);
        for (int i = 0; i < Game.getInstance(input).getInput().getNoOfRounds(); i++) {

        }

    }


}
