package by.flowers;

import java.io.Serializable;

public class Pion implements Flower, Serializable {

    private String name;
    private String color;
    private int weight;
    private int cost;

    public Pion () {
        name = "Pion";
        color = "Purple";
        weight = 15;
        cost = 25;
    }

    public Pion (String color, int weight, int cost) {
        name = "Pion";
        this.color = color;
        this.weight = weight;
        this.cost = cost;
    }

    public Pion (final Pion pion) {
        this.name = pion.name;
        this.color = pion.color;
        this.weight = pion.weight;
        this.cost = pion.cost;
    }

    public String getName () { return name; }

    public String getColor () { return color; }

    public int getWeight () { return weight; }

    public int getCost () { return cost; }

    public void setName (String name) { this.name = name; }

    public void setColor (String color) { this.color = color; }

    public void setWeight (int weight) { this.weight = weight; }

    public void setCost (int cost) { this.cost = cost; }

    public String toString() {
        return "Name: " + name + "\nColor: " + color + "\nCost: " + cost + "\nWeight: " + weight + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Pion pion = (Pion) object;
        return this.name.equals(pion.name)
                && this.color.equals(pion.color)
                && this.cost == pion.cost
                && this.weight == pion.weight;
    }
}
