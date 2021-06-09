package by.comparators;

import by.flowers.Flower;
import by.flowers.Pion;
import by.flowers.Rose;
import by.flowers.Tulip;
import by.comparators.flower_comparators.FlowerNameCompare;
import by.comparators.flower_comparators.FlowerCostCompare;

import java.util.Comparator;
import java.util.TreeSet;

public class SortTest {

    public static void main(String[] args) {
        Comparator<Flower> flowerComparator = new FlowerNameCompare().thenComparing(new FlowerCostCompare());
        TreeSet<Flower> flowers = new TreeSet<>(flowerComparator);
        flowers.add(new Rose());
        flowers.add(new Tulip());
        flowers.add(new Pion());
        flowers.add(new Pion("Purple", 50, 20));

        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }
}
