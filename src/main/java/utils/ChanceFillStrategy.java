package utils;

import java.util.Random;

/**
 * Created by tapia on 28/08/17.
 */
public class ChanceFillStrategy implements FillStrategy {
    private float chance;
    Random rand = new Random();

    public ChanceFillStrategy(float chance) {
        this.chance = chance;
    }

    public int getRandomValue() {
        if (rand.nextFloat()<chance) return 1;
        return 0;
    }
}
