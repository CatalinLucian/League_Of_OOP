package Main;

import characters.Hero;

import java.util.List;

public class GameLogic {

    public void startGame() {
        Game game = Game.getInstance();
        for (int i = 0; i < Game.getInstance().getInput().getNoOfRounds(); i++) {
            this.playRound();
        }

    }

    private void playRound() {
        for (Hero hero : Game.getInstance().getHeroes()) {
            hero.fight();
        }
    }
}
