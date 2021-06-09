package by.comparators.flower_comparators;

import by.flowers.Flower;

import java.util.Comparator;

public class FlowerNameCompare implements Comparator<Flower> {

    public int compare(Flower flower1, Flower flower2) {
        return flower1.getName().compareTo(flower2.getName());
    }
}
