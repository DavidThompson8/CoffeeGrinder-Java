package com.interview.coffeegrinder.api;

import com.interview.coffeegrinder.model.Coffee;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Grinder implements CoffeeGrinder{

    /*
        Makes a request to the endpoint and returns a list of all coffees found
     */
    public List<Coffee> getCoffees() throws IOException {
        //list of coffees to be returned
        ArrayList<Coffee> returnList = new ArrayList<Coffee>();

        //set the url to the specified endpoint
        URL url = new URL("https://videotutoriale.com/coffee/coffee.php");

        //send a get request to the url
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //make sure a valid connection was established
        int responsecode = conn.getResponseCode();
        //System.out.println(responsecode);
        //only build list if response code is successful
        //otherwise, the returned list will be empty to indicate nothing was found
        if (responsecode == 200) {

            //there is a case where there is a positive code but opening the stream fails
            //in this case, the try/catch results in an empty list as if the connection failed
            try {
                //read the coffee json data into a string
                String responsetext = "";
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    responsetext += scanner.nextLine();
                }
                scanner.close();
                //System.out.println(responsetext);

                //trim the brackets from the front and end
                responsetext = responsetext.replace("[", "");
                responsetext = responsetext.replace("]", "");
                //split the string into the json for individual coffees
                String[] coffees = responsetext.split("},");
                //System.out.println(Arrays.toString(coffees));

                for (int i = 0; i < coffees.length; i++) {
                    //closing brackets on all but the last iem were lost in splitting and must be re-added
                    if (i != coffees.length - 1) {
                        coffees[i] += "}";
                    }
                    //build a coffee from the json string
                    Coffee.CoffeeBuilder builder = new Coffee.CoffeeBuilder().setJson(coffees[i]);
                    Coffee nextCoffee = builder.build();
                    returnList.add(nextCoffee);
                }
                //System.out.println(Arrays.toString(coffees));
            }
            catch(IOException e){}//catch block is empty and just serves as a way to get to the return

        }
        //System.out.println(returnList.size());
        //System.out.println(returnList);
        return returnList;
    }

    /*
        Takes the id of the desired coffee and makes a request to the endpoint
        Returns the requested coffee if it exists, returns null otherwise
    */
    public Coffee getCoffee(String id) throws IOException {
        Coffee requestedCoffee = null;

        //set the url to the specified endpoint, with a query for the given id
        URL url = new URL("https://videotutoriale.com/coffee/coffee.php?id=" + id);

        //send a get request to the url
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //make sure a valid connection was established
        int responsecode = conn.getResponseCode();
        //System.out.println(responsecode);
        //only build coffee if response code is successful
        //otherwise, the returned list will be empty to indicate nothing was found
        if (responsecode == 200) {

            //there is a case where there is a positive code but opening the stream fails
            //in this case, the try/catch results in a null coffee as if the connection failed
            try {
                //read the coffee json data into a string
                String responsetext = "";
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    responsetext += scanner.nextLine();
                }
                scanner.close();


                //build a coffee from the json string
                Coffee.CoffeeBuilder builder = new Coffee.CoffeeBuilder().setJson(responsetext);
                requestedCoffee = builder.build();
            } catch (IOException e) {} //catch block is empty and just serves as a way to get to the return

        }

        return requestedCoffee;
    }
}
