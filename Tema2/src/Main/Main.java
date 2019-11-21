package Main;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String in = "/home/ctl/Desktop/a3x3.in";
        GameInputLoader loader = new GameInputLoader(in);
        GameInput input = loader.load();
    }
}
