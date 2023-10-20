package ManueleSeretti.pubblicazioni;

import java.util.Random;

public enum Periodic {
    SETTIMANALE,
    MENSILE,
    SEMESTRALE;
    private static final Random rndm = new Random();

    public static Periodic randomPeriodic() {

        Periodic[] periodicita = values();
        return periodicita[rndm.nextInt(periodicita.length)];

    }
}
