package battleground;

import Main.GameInput;

import java.util.Vector;

public class Battleground {
    private static Battleground instance = null;

    private Location[][] battleground;

    private Battleground() {
        initMap();
    }

    private void initMap() {
        Location[][] battleground = GameInput.getBattleArea();
    }

    public static Battleground getInstance() {
        if(instance == null) {
            return new Battleground();
        }
        return instance;
    }

    public Location[][] getBattleground() {
        return battleground;
    }

}
