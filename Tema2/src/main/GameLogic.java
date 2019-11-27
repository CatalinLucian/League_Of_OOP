package main;

import abilities.Fight;
import characters.Hero;
import characters.HeroManager;

import java.io.FileNotFoundException;

public class GameLogic {

    private Game game;

    public GameLogic(Game game) {
        this.game = game;
    }

    public void startGame() {
        for (int i = 0; i < game.getInput().getNoOfRounds(); i++) {
            playRound();
        }
        for (Hero hero : game.getHeroes()) {
            System.out.println(hero);
        }
    }

    public void playRound() {
        for (Hero hero : game.getHeroes()) {
            if(!hero.isDead()) {
                hero.sufferEffect();
                if(hero.getHp() <= 0) {
                    hero.setIsDead(true);
                }
                hero.move();
            }
        }
        for (int i = 0; i < game.getHeroes().size(); i++) {
            if(!game.getHeroes().get(i).isDead()) {
                for (int j = i + 1; j < game.getHeroes().size(); j++) {
                    if(!game.getHeroes().get(j).isDead()) {
                        if (game.getHeroes().get(i).getCoords().equals(game.getHeroes().get(j).getCoords())) {
                            Fight fight = new Fight(game.getHeroes().get(i), game.getHeroes().get(j));
                            fight.fight();
                        }
                    }
                }
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        String in = "/home/ctl/Desktop/fightKKD.in";
        //String out = "/home/ctl/Desktop/POO/GtRepo/Tema2/src/checker/resources/out/fightKKD.out";
        GameInputLoader loader = new GameInputLoader(in);
        GameInput input = loader.load();
        GameLogic logic = new GameLogic(new Game(input));
        logic.startGame();
    }
}
