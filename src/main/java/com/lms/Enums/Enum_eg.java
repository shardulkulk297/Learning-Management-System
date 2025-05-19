package com.lms.Enums;

import java.util.ArrayList;
import java.util.List;

public class Enum_eg {

    public static void main(String[] args) {
        //Printing Enum vales
        System.out.println("Enum Values");
        for(City c: City.values()){
            System.out.println(c);
        }

        //Converting values to String and storing them in a list
        List<String> listOfCities = new ArrayList<>();

        for(City c: City.values()){
            listOfCities.add(c.toString());
        }
        System.out.println(listOfCities);

        //IDENTIFYING ALLOWED VALUE AS A STRING
        String value = "Delhi";

        if(listOfCities.contains(value)){
            System.out.println("Allowed Value");
        }
        else{
            System.out.println("Not Allowed Value");
        }

        //IDENTIFYING VALUE BY ANOTHER WAY
        String c = "mumbai";

        try{
            City city = City.valueOf(c.toUpperCase());
            System.out.println("Allowed value");
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid Value: " + c);
        }
        catch(NullPointerException e){
            System.out.println("Value not provided");
        }
    }

}
