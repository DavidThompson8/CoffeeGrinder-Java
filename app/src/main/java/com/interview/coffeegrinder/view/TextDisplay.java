package com.interview.coffeegrinder.view;

import com.interview.coffeegrinder.model.Coffee;

import java.util.ArrayList;
import java.util.List;

public class TextDisplay {


    //constructor
    public TextDisplay() {
    }

    public void printWelcome(){
        System.out.println("Welcome to the Coffee Grinder!");
        this.printMenu();
    }

    public void printInvalid(){
        System.out.println("Invalid input. Please enter a menu option 1, 2, or 3.");
        this.printMenu();
    }

    //Displays user options
    public void printMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Get coffee list");
        System.out.println("2. Get individual coffee details");
        System.out.println("3. Exit");
    }

    //Displays the available coffees, or displays that there are none to be shown
    //Available coffees provided by list parameter
    public void printList(List<Coffee> coffees){
        if(coffees.size() > 0) {
            System.out.println("Available coffees:");
            for (Coffee c : coffees) {
                System.out.printf("ID %d: %s\n", c.getId(), c.getName());
            }
        }
        else{
            System.out.println("Sorry, no available coffees found");
        }
        System.out.println();
        this.printMenu();
    }

    //Asks the user which coffee they are looking for
    public void printIdRequest(){
        System.out.println("What is the ID of the coffee you would like details for?");
    }

    //Prints either the provided coffee or a message that the coffee was not found
    public void printCoffee(Coffee c){
        if(c != null){
            System.out.println("Your requested coffee:");
            System.out.println("ID: " + c.getId());
            System.out.println("Name: " + c.getName());
            System.out.println("Price: $" + String.format("%.2f", c.getPrice()));
            System.out.println("Description: " + c.getDescription());
        }
        else{
            System.out.println("Sorry, that coffee could not be found!");
        }

        System.out.println();
        this.printMenu();
    }

    public void printExit(){
        System.out.println("Coffee Grinder now closing.");
        System.out.println();
    }
}
