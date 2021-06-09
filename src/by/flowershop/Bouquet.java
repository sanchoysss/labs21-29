package by.flowershop;

import by.flowers.Flower;
import java.util.ArrayList;

public class Bouquet {
    private ArrayList<Flower> flowers;
    private static int id;
    private int bouquetId;

    static {
        id = -1;
    }

    {
        id++;
    }

    Bouquet(ArrayList<Flower> flowers) {
        this.flowers = new ArrayList<>(flowers);
        this.bouquetId = id;
    }

    public Bouquet(final Bouquet bouquet) {
        this.flowers = bouquet.flowers;
        bouquetId = id;
    }

    public ArrayList<Flower> getTheMostExpensiveFlower() {
        int maxCost = this.flowers.get(0).getCost();
        for (int i = 1; i < this.flowers.size(); i++) {
            maxCost = this.flowers.get(i).getCost() > maxCost ? this.flowers.get(i).getCost() : maxCost;
        }
        ArrayList<Flower> flowers = new ArrayList<>();
        for (Flower flower: this.flowers) {
            if (flower.getCost() == maxCost) {
                flowers.add(flower);
            }
        }
        return flowers;
    }

    public ArrayList<Flower> getCheapestFlower() {
        int minCost = this.flowers.get(0).getCost();
        for (int i = 1; i < this.flowers.size(); i++) {
            minCost = this.flowers.get(i).getCost() < minCost ? this.flowers.get(i).getCost() : minCost;
        }
        ArrayList<Flower> flowers = new ArrayList<>();
        for (Flower flower: this.flowers) {
            if (flower.getCost() == minCost) {
                flowers.add(flower);
            }
        }
        return flowers;
    }

    public int getCostOfTheBouquet() {
        int cost = 0;
        for (Flower flower: flowers) {
            cost += flower.getCost();
        }
        return cost;
    }

    public int getWeightOfTheBouquet() {
        int weight = 0;
        for (Flower flower: flowers) {
            weight += flower.getWeight();
        }
        return weight;
    }

    public String toString() {
        String bouquetString = "Bouquet ID: " + String.valueOf(bouquetId) + "\n\n";
        for (Flower flower : this.flowers) {
            bouquetString += flower.toString() + "\n";
        }
        return bouquetString;
    }

    Bouquet() {
        this.flowers = new ArrayList<>();
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(ArrayList<Flower> flowers) {
        this.flowers.clear();
        this.flowers.addAll(flowers);
    }

    public int getBouquetId() {
        return bouquetId;
    }
}
