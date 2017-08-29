package utils;

import java.util.Random;

/**
 * Created by tapia on 28/08/17.
 */
public class BinaryFillStrategy implements FillStrategy {
    Random rand = new Random();
    public int getRandomValue() {
        return  rand.nextInt(2);
    }
}
