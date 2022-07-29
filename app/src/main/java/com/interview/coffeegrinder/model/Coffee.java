package com.interview.coffeegrinder.model;

import com.google.gson.Gson;

public class Coffee {

  private int id;
  private String name;
  private double price;
  private String description;

  /** 
   * @return
   */
  public int getId() {
    return id;
  }

  /** 
   * @return
   */
  public String getName() {
    return name;
  }

  /** 
   * @return
   */
  public double getPrice() {
    return price;
  }

  /** 
   * @return
   */
  public String getDescription() {
    return description;
  }

  /**
   * CoffeeBuilder 
   * Builder pattern to create {@link Coffee} instances
   */
  public static class CoffeeBuilder {

    private String json;
    /** 
     * @param json
     */
    public CoffeeBuilder setJson( String json ) {
      this.json = json;
      return this;
    }
    /** 
     * @param jsonString
     * @return
     */
    protected static Coffee fromJson(String jsonString) {
      return fromJson( new Gson(), jsonString );
    }
    /** 
     * @param gson
     * @param jsonString
     * @return
     */
    protected static Coffee fromJson(Gson gson, String jsonString) {
      return gson.fromJson(jsonString, Coffee.class);
    }
    /** 
     * @return
     */
    public Coffee build() {
      return fromJson( json );
    }
  }
}