package org.example;

import java.util.Random;

public class PancakeShop {
    private int pancakesMade = 0;
    private int pancakesEaten = 0;
    private final int maxPancakes = 12;

    public void makePancakes() {
        if (pancakesMade < maxPancakes) {
            Random rand = new Random();
            int pancakesToMake = rand.nextInt(maxPancakes - pancakesMade) + 1;
            pancakesMade += pancakesToMake;
        }
    }

    public int servePancakes(int maxEaten) {
        if (pancakesMade > 0) {
            int pancakesToServe = Math.min(maxEaten, pancakesMade);
            pancakesMade -= pancakesToServe;
            pancakesEaten += pancakesToServe;
            return pancakesToServe;
        }
        return 0;
    }

    public int getPancakesEaten() {
        return pancakesEaten;
    }

    public int getPancakesMade() {
        return pancakesMade;
    }
}