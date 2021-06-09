package by.flowershop;

import by.creators.Creator;
import by.creators.Initializer;

import by.flowers.Flower;

import by.exceptions.IdNotFoundException;
import by.exceptions.FlowerNotCreated;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FlowerShop {
    private final static ArrayList<Bouquet> BOUQUETS = new ArrayList<>(0);

    public static boolean checkId(int id) {
        return id > -1 && id < BOUQUETS.size();
    }

    public static int createBouquet(Flower... flowers) throws FlowerNotCreated{
        ArrayList<Flower> flowerArrayList = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getName().equalsIgnoreCase("Rose")) {
                if (!flower.getColor().equalsIgnoreCase("white") && !flower.getColor().equalsIgnoreCase("red")) {
                    throw new FlowerNotCreated("Sorry, we don't have rose of " + flower.getColor() + " color. Only red and white!");
                }
            } else  if (flower.getName().equalsIgnoreCase("Tulip")){
                if (!flower.getColor().equalsIgnoreCase("red") && !flower.getColor().equalsIgnoreCase("yellow")) {
                    throw new FlowerNotCreated("Sorry, we don't have tulip of " + flower.getColor() + " color. Only red and yellow!");
                }
            } else if (flower.getName().equalsIgnoreCase("Pion")) {
                if (!flower.getColor().equalsIgnoreCase("pink") && !flower.getColor().equalsIgnoreCase("purple")) {
                    throw new FlowerNotCreated("Sorry, we don't have pion of " + flower.getColor() + " color. Only pink and purple!");
                }
            } else {
                throw new FlowerNotCreated("Sorry, we don't have such flower! Only rose, tulip or pion");
            }
        }
        for (Flower flower : flowers) {
            flowerArrayList.add(flower);
        }
        Bouquet bouquet = new Bouquet(flowerArrayList);
        BOUQUETS.add(bouquet);
        System.out.println(bouquet.getBouquetId());
        return BOUQUETS.get(BOUQUETS.size() - 1).getBouquetId();
    }

    public static int createBouquet(int size) {
        ArrayList<Flower> flowers = Creator.creator(size);
        Initializer.initialize(flowers);
        Bouquet bouquet = new Bouquet(flowers);
        BOUQUETS.add(bouquet);
        return bouquet.getBouquetId();
    }

    public static ArrayList<Flower> sortByPrice(int id) {
        ArrayList<Flower> flowers = BOUQUETS.get(id).getFlowers();
        for (int i = 0; i < flowers.size() - 1; i++) {
            for (int j = i + 1; j < flowers.size(); j++) {
                if (flowers.get(i).getCost() < flowers.get(j).getCost()) {
                    Flower temp = flowers.get(i);
                    flowers.set(i, flowers.get(j));
                    flowers.set(j, temp);
                }
            }
        }
        return flowers;
    }

    public static ArrayList<Flower> sortByWeight(int id) {
        ArrayList<Flower> flowers = BOUQUETS.get(id).getFlowers();
        for (int i = 0; i < flowers.size() - 1; i++) {
            for (int j = i + 1; j < flowers.size(); j++) {
                if (flowers.get(i).getWeight() < flowers.get(j).getWeight()) {
                    Flower temp = flowers.get(i);
                    flowers.set(i, flowers.get(j));
                    flowers.set(j, temp);
                }
            }
        }
        return flowers;
    }

    public static ArrayList<Flower> getTheMostExpensiveFlowerById(int id) throws IdNotFoundException{
        if (checkId(id)) {
            return BOUQUETS.get(id).getTheMostExpensiveFlower();
        } else {
            throw new IdNotFoundException("Method getTheMostExpensiveFlowerById. Id not found");
        }
    }

    public static ArrayList<Flower> getCheapestFlowerById(int id) throws IdNotFoundException{
        if (checkId(id)) {
            return BOUQUETS.get(id).getCheapestFlower();
        }
        else {
            throw new IdNotFoundException("Wrong Id in method getCheapestFlowerById");
        }
    }

    public static int getCostOfTheBouquetById(int id) throws IdNotFoundException{
        if (checkId(id)) {
            return BOUQUETS.get(id).getCostOfTheBouquet();
        }
        else {
            throw new IdNotFoundException("Method getCostOfTheBouquetById. Such id not found!");
        }
    }

    public static int getWeightOfTheBouquetById(int id) throws IdNotFoundException{
        if (checkId(id)) {
            return BOUQUETS.get(id).getWeightOfTheBouquet();
        } else {
            throw new IdNotFoundException("Id not found in method getWeightOfTheBouquetById!");
        }
    }

    public static void administratorMenu(int password) {
        if (password != 1111) {
            System.out.println("Password is not correct!");
            return;
        }
        System.out.println("List of all orders:");
        for (Bouquet bouquet: BOUQUETS) {
            System.out.println(bouquet + "\n");
        }
    }

    public static void printInfoAboutDay() {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.FULL, DateFormat.MEDIUM,
                new Locale("ru", "BY"));
        String dateStr = dateFormat.format(new Date());
        System.out.println(dateStr);
    }
}
