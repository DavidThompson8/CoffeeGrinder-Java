package com.interview.coffeegrinder;

import com.interview.coffeegrinder.api.Grinder;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonSyntaxException;
import com.interview.coffeegrinder.model.Coffee;

import java.io.IOException;
import java.util.List;

public class CoffeeGrinderTest {

  @Test()
  public static void testClient() {

    Assert.assertTrue(true);
  }

  @Test()
  public static void testValidModel() {

    String id = "10";
    String name = "Flat White";
    String price = "2.49";
    String description = "A shot of espresso and steamed milk.";
    Coffee coffee = new Coffee.CoffeeBuilder()
        .setJson(
          "{" +
             "\"id\":" + id + ", " +
             "\"name\":" + "\"" + name +  "\", " +
             "\"price\":"  +  price + ", " +
             "\"description\":" + "\"" + description +  "\"" +
           "}")
        .build();

    Assert.assertTrue( coffee.getId() == Integer.valueOf(id).intValue());
    Assert.assertTrue( coffee.getName().equals(name));
    Assert.assertTrue( coffee.getPrice() == Double.valueOf(price).doubleValue());
    Assert.assertTrue( coffee.getDescription().equals(description));
  }

  @Test(expectedExceptions = { JsonSyntaxException.class })
  public static void testInvalidModel() {

    String id = "10";
    String name = "Flat White";
    String price = "2.49";
    String description = "A shot of espresso and steamed milk.";
    new Coffee.CoffeeBuilder()
        .setJson(
          "{" +
             "\"id\":" + id + ", " +
             "\"name\":" +  name +  ", " +
             "\"price\":"  +  price + ", " +
             "\"description\":" + description +
           "}")
        .build();
  }

  @Test() //test getCoffee using the same coffee used in previous tests
  public static void testGetCoffee() throws IOException {

    String id = "10";
    String name = "Flat White";
    String price = "2.49";
    String description = "A shot of espresso and steamed milk.";
    Grinder grinder = new Grinder();
    Coffee coffee = grinder.getCoffee("10");


    Assert.assertTrue( coffee.getId() == Integer.valueOf(id).intValue());
    Assert.assertTrue( coffee.getName().equals(name));
    Assert.assertTrue( coffee.getPrice() == Double.valueOf(price).doubleValue());
    Assert.assertTrue( coffee.getDescription().equals(description));
  }

  @Test //test that getCoffees is returning a valid list; lists should be size 0, 1, or 11 based on repeated checks of the endpoint
  public static void testGetCoffees() throws IOException {
    Grinder grinder = new Grinder();
    List<Coffee> coffee = grinder.getCoffees();
    Assert.assertTrue(coffee.size() == 0 || coffee.size() == 1 || coffee.size() == 11);
  }
}