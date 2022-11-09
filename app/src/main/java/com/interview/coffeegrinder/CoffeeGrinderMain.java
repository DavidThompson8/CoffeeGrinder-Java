package com.interview.coffeegrinder;

import com.interview.coffeegrinder.api.Grinder;
import com.interview.coffeegrinder.view.TextDisplay;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class CoffeeGrinderMain {

  //Main servers as the controller, taking user input and acting accordingly
  public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

    //set up view and grinder
    TextDisplay view  = new TextDisplay();
    Grinder grind = new Grinder();

    //Scanner to read user inputs and string to hold them
    Scanner input = new Scanner(System.in);
    String inputValue = "";

    //Display the menu, then begin getting input
    view.printWelcome();
    while(true){//program runs until the exit option is chosen
      inputValue = input.next(); //get user choice
      input.nextLine(); //flush anything extra
      switch(inputValue){
        case "1": //get the list of coffees
          view.printList(grind.getCoffees());
          break;
        case "2": //get details for a specific coffee
          view.printIdRequest();
          inputValue = input.next(); //get desired id from user
          input.nextLine(); //flush anything extra
          view.printCoffee(grind.getCoffee(inputValue));
          break;
        case "3": //exit the program
          view.printExit();
          System.exit(0);
          break;
        default: //ask for valid input
          view.printInvalid();
      }

    }
  }
}