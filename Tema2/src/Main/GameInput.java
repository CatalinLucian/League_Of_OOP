package Main;

import battleground.Location;
import characters.PositionOnBattleground;

import java.util.Arrays;
import java.util.List;

public final class GameInput {


    private final int noOfRows;
    private final int noOfColumns;

    private static Location[][] battleArea;


    private final int noOfHeroes;
    private final List<Character> heroList;
    private final List<PositionOnBattleground> initialPositions;
    private final int noOfRounds;
    private final List<String> heroesMoves;

    public GameInput(final int noOfRows, final int noOfColumns, final Location[][] battleArea,
                     final int noOfHeroes, final List<Character> heroList,
                     final List<PositionOnBattleground> initialPositions, final int noOfRounds,
                     final List<String> heroesMoves) {
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        this.battleArea = battleArea;
        this.noOfHeroes = noOfHeroes;
        this.heroList = heroList;
        this.initialPositions = initialPositions;
        this.noOfRounds = noOfRounds;
        this.heroesMoves = heroesMoves;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }


    public static Location[][] getBattleArea() {
        return battleArea;
    }

    public int getNoOfHeroes() {
        return noOfHeroes;
    }

    public List<Character> getHeroList() {
        return heroList;
    }

    public List<PositionOnBattleground> getInitialPositions() {
        return initialPositions;
    }

    public int getNoOfRounds() {
        return noOfRounds;
    }

    public List<String> getHeroesMoves() {
        return heroesMoves;
    }

    public final boolean isValidInput(GameInput input) {
        return true;
    }

    @Override
    public String toString() {
        return "GameInput{" +
                "noOfRows=" + noOfRows +
                ", noOfColumns=" + noOfColumns +
                ", battleArea=" + Arrays.toString(battleArea) +
                ", noOfHeroes=" + noOfHeroes +
                ", heroList=" + heroList +
                ", initialPositions=" + initialPositions +
                ", noOfRounds=" + noOfRounds +
                ", heroesMoves=" + heroesMoves +
                '}';
    }
}
