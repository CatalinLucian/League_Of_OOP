package battleground;

import Main.GameInput;

import java.util.Vector;

public class Battleground {
    private static Battleground instance = null;

    private final Vector<Vector<Location>> battleground;

    private Battleground() {
        battleground = new Vector<Vector<Location>>();
        initMap();
    }

    private void initMap() {
        Location[][] battleground = GameInput.getBattleArea();
        for (int i = 0; i < battleground.length; i++) {
            Vector<Location> LineByLine = new Vector<>();
            for (int j = 0; j < battleground[0].length; j++) {
                LineByLine.add(battleground[i][j]);
            }
            this.battleground.add(LineByLine);
        }
    }

    public static Battleground getInstance() {
        if(instance == null) {
            return new Battleground();
        }
        return instance;
    }

    public Vector<Vector<Location>> getBattleground() {
        return battleground;
    }

}
