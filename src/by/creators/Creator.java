package by.creators;

import by.flowers.Flower;
import by.flowers.Pion;
import by.flowers.Rose;
import by.flowers.Tulip;

import java.util.ArrayList;
import java.util.Random;

public class Creator {

    public static ArrayList<Flower> creator(int size) {
        ArrayList<Flower> flowers = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            Random random = new Random();
            switch (random.nextInt(3)) {
                case (0) -> flowers.add(new Rose());
                case (1) -> flowers.add(new Tulip());
                default -> flowers.add(new Pion());
            }
        }
        return flowers;
    }
}
