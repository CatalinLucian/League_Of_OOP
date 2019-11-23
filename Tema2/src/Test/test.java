package Test;

import Main.GameInput;
import Main.GameInputLoader;
import Main.Writer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        String in = "/home/ctl/Desktop/a3x3.in";
        String out = "/home/ctl/Desktop/output";
        GameInputLoader loader = new GameInputLoader(in);
        GameInput input = loader.load();

        System.out.println("Nr de linii: " + input.getNoOfRows());
        System.out.println("Nr de coloane: " + input.getNoOfColumns());
        for (int i = 0; i < input.getNoOfRows(); i++) {
            for (int j = 0; j < input.getNoOfColumns(); j++) {
                System.out.print(input.getBattleArea()[i][j]);
            }
            System.out.println();
        }

        System.out.println("Nr de eroi: " + input.getNoOfHeroes());
        System.out.println("Eroi si pozitiile initiale: ");
        for (int i = 0; i < input.getNoOfHeroes(); i++) {
            System.out.println(input.getHeroList().get(i) + "" + input.getInitialPositions().get(i));
        }
        System.out.println("Nr de runde: " + input.getNoOfRounds());
        for (int i = 0; i < input.getNoOfRounds(); i++) {
            System.out.println(input.getHeroesMoves().get(i));
        }
        Writer writer = new Writer(out);
        writer.writeToFile();
    }


}
