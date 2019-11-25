package main;

import java.io.FileNotFoundException;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        String in = "/home/ctl/Desktop/a3x3.in";
        String out = "/home/ctl/Desktop/POO/GtRepo/Tema2/src/checker/resources/out/fightKKD.out";
        GameInputLoader loader = new GameInputLoader(in);
        GameInput input = loader.load();

    }
}
