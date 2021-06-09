package by.flowers;

import java.io.Serializable;

public class Rose implements Flower, Serializable {

    private String name;
    private String color;
    private int weight;
    private int cost;

    public Rose () {
        name = "Rose";
        color = "Red";
        weight = 15;
        cost = 25;
    }

    public Rose (String color, int weight, int cost) {
        name = "Rose";
        this.color = color;
        this.weight = weight;
        this.cost = cost;
    }

    public Rose (final Rose rose) {
        this.name = rose.name;
        this.color = rose.color;
        this.weight = rose.weight;
        this.cost = rose.cost;
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
        Rose rose = (Rose) object;
        return this.name.equals(rose.name)
                && this.color.equals(rose.color)
                && this.weight == rose.weight
                && this.cost == rose.cost;
    }
}
