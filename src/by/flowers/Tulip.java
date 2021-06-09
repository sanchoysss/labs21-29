package by.flowers;

import java.io.Serializable;

public class Tulip implements Flower, Serializable {

    private String name;
    private String color;
    private int weight;
    private int cost;

    public Tulip () {
        name = "Tulip";
        color = "Red";
        weight = 15;
        cost = 25;
    }

    public Tulip (String color, int weight, int cost) {
        this.name = "Tulip";
        this.color = color;
        this.weight = weight;
        this.cost = cost;
    }

    public Tulip (final Tulip tulip) {
        this.name = tulip.name;
        this.color = tulip.color;
        this.weight = tulip.weight;
        this.cost = tulip.cost;
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
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Tulip tulip = (Tulip) object;
        return this.name.equals(tulip.name)
                && this.color.equals(tulip.color)
                && this.cost == tulip.cost
                && this.weight == tulip.weight;
    }
}
