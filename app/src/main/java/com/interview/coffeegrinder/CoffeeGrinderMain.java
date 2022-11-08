package com.interview.coffeegrinder;

import com.interview.coffeegrinder.api.Grinder;

import java.io.IOException;
import java.net.URISyntaxException;

public class CoffeeGrinderMain {

  public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

    System.out.println("CoffeeGrinder!");
    Grinder grind = new Grinder();
    grind.getCoffees();
    grind.getCoffee("2");
    System.out.println(grind.getCoffee("2"));
  }
}