package by.creators;

import java.util.ArrayList;
import java.util.Random;

import by.flowers.Flower;

public class Initializer {

    public static final String[] COLORS_FOR_ROSES = {"Red", "White"};
    public static final String[] COLORS_FOR_PIONS = {"Pink", "White", "Purple"};
    public static final String[] COLORS_FOR_TULIPS = {"Red", "Yellow"};

    public static final int[] COSTS = {10, 15, 20, 25, 30, 35, 40, 45, 50};

    public static final int[] WEIGHTS = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    public static void initialize(ArrayList<Flower> flowers) {
        Random random = new Random();
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getClass().getSimpleName().equals("Rose")) {
                flowers.get(i).setColor(COLORS_FOR_ROSES[random.nextInt(COLORS_FOR_ROSES.length)]);
            } else if (flowers.get(i).getClass().getSimpleName().equals("Tulip")) {
                flowers.get(i).setColor(COLORS_FOR_TULIPS[random.nextInt(COLORS_FOR_TULIPS.length)]);
            } else {
                flowers.get(i).setColor(COLORS_FOR_PIONS[random.nextInt(COLORS_FOR_PIONS.length)]);
            }
            flowers.get(i).setWeight(WEIGHTS[random.nextInt(WEIGHTS.length)]);
            flowers.get(i).setCost(COSTS[random.nextInt(COSTS.length)]);
        }
    }
}
