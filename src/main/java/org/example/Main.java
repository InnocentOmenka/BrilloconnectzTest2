package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PancakeShop shop = new PancakeShop();
        int startTime = 0;
        int endTime = 30;

        while (true) {
            shop.makePancakes();
            int user1Eaten = new Random().nextInt(6);  // Randomly generate pancakes eaten by user 1 (0 to 5).
            int user2Eaten = new Random().nextInt(6);  // Randomly generate pancakes eaten by user 2 (0 to 5).
            int user3Eaten = new Random().nextInt(6);  // Randomly generate pancakes eaten by user 3 (0 to 5).

            int totalPancakesEaten = user1Eaten + user2Eaten + user3Eaten;

            if (shop.getPancakesEaten() + totalPancakesEaten >= 15) {
                // Ensure that the total pancakes eaten by users don't exceed 15.
                int remainingPancakes = 15 - shop.getPancakesEaten();
                user1Eaten = Math.min(user1Eaten, remainingPancakes);
                user2Eaten = Math.min(user2Eaten, remainingPancakes - user1Eaten);
                user3Eaten = Math.min(user3Eaten, remainingPancakes - user1Eaten - user2Eaten);
            }

            shop.servePancakes(user1Eaten);
            shop.servePancakes(user2Eaten);
            shop.servePancakes(user3Eaten);

            System.out.println("Starting time: " + startTime + " seconds");
            System.out.println("Ending time: " + endTime + " seconds");
            System.out.println("Pancakes made by the shopkeeper: " + shop.getPancakesMade());
            System.out.println("Pancakes eaten by the users: " + shop.getPancakesEaten());
            System.out.println("Shopkeeper met the needs of the users: " + (shop.getPancakesEaten() >= 15));
            System.out.println("Pancakes wasted: " + (shop.getPancakesMade() - shop.getPancakesEaten()));
            System.out.println("------------------------------------");
            startTime += 30;
            endTime += 30;

            if (shop.getPancakesEaten() >= 15) {
                break;
            }
        }
    }
}