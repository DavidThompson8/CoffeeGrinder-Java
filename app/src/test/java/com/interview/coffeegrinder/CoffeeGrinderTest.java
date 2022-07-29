package com.interview.coffeegrinder;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonSyntaxException;
import com.interview.coffeegrinder.model.Coffee;

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
}