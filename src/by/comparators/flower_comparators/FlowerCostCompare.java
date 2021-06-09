package by.comparators.flower_comparators;

import by.flowers.Flower;

import java.util.Comparator;

public class FlowerCostCompare implements Comparator<Flower> {

    public int compare(Flower flower1, Flower fLower2) {
        if (flower1.getCost() > fLower2.getCost()) {
            return 1;
        } else if (flower1.getCost() < fLower2.getCost()) {
            return -1;
        }
        return 0;
    }
}
