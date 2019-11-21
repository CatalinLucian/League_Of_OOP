package Main;

import characters.PositionOnBattleground;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInputLoader {
    private String inputPath;

    public GameInputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    public GameInput load() throws FileNotFoundException{
        int noOfRows = 0;
        int noOfColumns = 0;
        char[][] battleArea;
        int noOfHeroes = 0;
        List<Character> heroList = new ArrayList<>();
        List<PositionOnBattleground> initialPositions = new ArrayList<>();
        int noOfRounds = 0;
        List<String> heroesMoves = new ArrayList<>();

        File fr = new File(inputPath);
        Scanner sc;
        sc = new Scanner(fr);

        noOfRows = sc.nextInt();
        noOfColumns = sc.nextInt();

        battleArea = new char[noOfRows][noOfColumns];

        for (int i = 0; i < noOfRows; i++) {
            battleArea[i] = sc.next().toCharArray();
        }

        noOfHeroes = sc.nextInt();

        for (int i = 0; i < noOfHeroes; i++) {
            heroList.add(sc.next().charAt(0));
            int xCoord = sc.nextInt();
            int yCoord = sc.nextInt();
            initialPositions.add(new PositionOnBattleground(xCoord, yCoord));
        }

        noOfRounds = sc.nextInt();

        for(int i = 0; i < noOfRounds; i++) {
            String toAdd = sc.next();
            heroesMoves.add(toAdd);
        }

        return new GameInput(noOfRows, noOfColumns, battleArea, noOfHeroes, heroList,
                                initialPositions, noOfRounds, heroesMoves);
    }
}
