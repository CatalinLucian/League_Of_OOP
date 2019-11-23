package battleground;

public class LocationFactory {

    private static LocationFactory instance = null;
    private LocationFactory() {

    }

    public static LocationFactory getInstance() {
        if(instance == null) {
            return new LocationFactory();
        }
        return instance;
    }

    public Location createLocation(char locationType) {
        if(locationType == 'L') {
            return new Land();
        }
        if(locationType == 'W') {
            return new Woods();
        }
        if(locationType == 'V') {
            return new Volcanic();
        }
        if(locationType == 'D') {
            return new Desert();
        }
        return null;
    }
}

