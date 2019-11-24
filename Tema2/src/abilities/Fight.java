package abilities;

import battleground.Location;
import characters.Hero;

public class Fight {
    private Hero o1;
    private Hero o2;
    private Location location;

    public Fight(Hero o1, Hero o2, Location location) {
        this.o1 = o1;
        this.o2 = o2;
        this.location = location;
    }

    public void acceptLandModifier() {

    }
}
