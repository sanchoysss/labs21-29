package by.testing;

import by.exceptions.FlowerNotCreated;
import by.exceptions.IdNotFoundException;
import by.flowers.Flower;
import by.flowers.Pion;
import by.flowers.Rose;
import by.flowers.Tulip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import by.flowershop.FlowerShop;

import java.util.ArrayList;
import java.util.Arrays;

public class FlowerShopTest {

    private Pion pion1, pion2, pion3;
    private Rose rose1, rose2, rose3;
    private Tulip tulip1, tulip2, tulip3;
    private int bouquet;

    @Before
    public void setUp() throws Exception{
        pion1 = new Pion();
        pion2 = new Pion("Pink", 15, 5);
        pion3 = new Pion(pion1);

        rose1 = new Rose();
        rose2 = new Rose("Red", 10, 30);
        rose3 = new Rose(rose1);

        tulip1 = new Tulip();
        tulip2 = new Tulip("Red", 16, 25);
        tulip3 = new Tulip(tulip1);

        try {
            bouquet = FlowerShop.createBouquet(rose1, rose2, rose3, tulip1, tulip2, tulip3, pion1, pion2, pion3);
        } catch(FlowerNotCreated exception) {
            System.out.println(exception);
        }
    }

    @Test
    public void createBouquet() {
        Assert.assertEquals(bouquet, 0);
        int bouquet1 = FlowerShop.createBouquet(10);
        Assert.assertEquals(bouquet1, 1);
        try {
            Rose rose = new Rose(rose1);
            rose.setColor("Yellow");
            FlowerShop.createBouquet(rose);
        } catch (FlowerNotCreated exception) {
            System.out.println(exception);
        }
    }

    @Test
    public void getTheMostExpensiveFlower() throws IdNotFoundException{
        ArrayList<Flower> expected = FlowerShop.getTheMostExpensiveFlowerById(0);
        ArrayList<Flower> actual = new ArrayList<>();
        actual.add(rose2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createBouquetWithWrongFlowers() {
        try {
            tulip2.setColor("Green");
            FlowerShop.createBouquet(tulip2);
        } catch(FlowerNotCreated exception) {
            System.out.println(exception);
        }

        try {
            pion2.setColor("Green");
            FlowerShop.createBouquet(pion2);
        } catch(FlowerNotCreated exception) {
            System.out.println(exception);
        }

        try {
            rose1.setName("Car");
            FlowerShop.createBouquet(rose1);
        } catch(FlowerNotCreated exception) {
            System.out.println(exception);
        }
    }

    @Test
    public void getTheCheapestFlower() {
        try {
            ArrayList<Flower> expected = FlowerShop.getCheapestFlowerById(0);
            ArrayList<Flower> actual = new ArrayList<>(1);
            actual.add(pion2);
            Assert.assertEquals(expected, actual);
            FlowerShop.getCheapestFlowerById(15);
        } catch(IdNotFoundException exception) {
            System.out.println(exception);
        }
    }

    @Test
    public void getCostOfABouquet() {
        try {
            int expected = FlowerShop.getCostOfTheBouquetById(0);
            Assert.assertEquals(expected, 210);
            FlowerShop.getCostOfTheBouquetById(15);
        } catch(IdNotFoundException exception) {
            System.out.println(exception);
        }
    }

    @Test
    public void getWeightOfABouquet() throws IdNotFoundException{
        int expected = FlowerShop.getWeightOfTheBouquetById(0);
        Assert.assertEquals(expected, 131);
    }

    @Test
    public void administratorMenu() {
        FlowerShop.administratorMenu(0);
        FlowerShop.administratorMenu(1111);
    }

    @Test
    public void sortByPrice() {
        ArrayList<Flower> expected = FlowerShop.sortByPrice(0);
        ArrayList<Flower> actual = new ArrayList<>(Arrays.asList(rose2, rose1, rose3, tulip1, tulip2, tulip3, pion1, pion3, pion2));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortByWeight() {
        ArrayList<Flower> expected = FlowerShop.sortByWeight(0);
        ArrayList<Flower> actual = new ArrayList<>(Arrays.asList(tulip2, rose3, tulip1, rose1, tulip3, pion1, pion3, pion2, rose2));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPion() {
        pion1.setName("PION");
        pion1.setWeight(35);
        pion1.setColor("Green");
        pion1.setCost(55);

        System.out.println(pion1);
        Pion pion = pion1;
        System.out.println(pion == pion1);

        pion = null;
        System.out.println(pion == pion1);
    }

    @Test
    public void testRose() {
        rose1.setName("ROSE");
        rose1.setColor("RED");
        rose1.setCost(100);
        rose1.setWeight(20);
        System.out.println(rose1);

        Rose rose = rose1;
        System.out.println(rose == rose1);

        rose = null;
        System.out.println(rose == rose1);
    }

    @Test
    public void testTulip() {
        tulip1.setName("TULIP");
        tulip1.setColor("RED");
        tulip1.setCost(40);
        tulip1.setWeight(36);
        System.out.println(tulip1);

        Tulip tulip = tulip1;
        System.out.println(tulip == tulip1);

        tulip = null;
        System.out.println(tulip == tulip1);
    }

    @Test (expected = IdNotFoundException.class)
    public void getExceptionFromGetWeightOfABouquetById() throws IdNotFoundException{
        FlowerShop.getWeightOfTheBouquetById(15);
    }

    @Test (expected = IdNotFoundException.class)
    public void testGetTheMostExpensiveBouquetById() throws IdNotFoundException{
        FlowerShop.getTheMostExpensiveFlowerById(15);
    }

    @Test
    public void dateTest() {
        FlowerShop.printInfoAboutDay();
    }

    @Test (timeout = 10)
    public void runtime() {
        FlowerShop.createBouquet(5);
    }
}