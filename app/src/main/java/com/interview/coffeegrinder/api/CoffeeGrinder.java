package com.interview.coffeegrinder.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.interview.coffeegrinder.model.Coffee;

public interface CoffeeGrinder {

  /**
   * https://videotutoriale.com/coffee/coffee.php
   * @return
   */
  List<Coffee> getCoffees() throws IOException;

  /**
   * https://videotutoriale.com/coffee/coffee.php?id=8
   * @param id
   * @return
   */
  Coffee getCoffee(String id) throws IOException;
}