import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private final Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        int randId = random.nextInt(PLANET_CLASSES.length);

        return PLANET_CLASSES[randId];
    }

    String randomShipRegistryNumber() {
        int randReg = random.nextInt(9000);

        return "NCC-" + (1000 + randReg);
    }

    double randomStardate() {
        double randStardate = random.nextDouble(1000);
    
        return 41000.0 + randStardate;
    }
}
