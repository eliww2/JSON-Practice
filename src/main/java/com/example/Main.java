package com.example;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    //Prints implemented Pokedex function results.
    public static void main(String[] args) throws IOException {
        //Initialization
        Gson gson = new Gson();
        Reader jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/example.json"));
        Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);

        //SearchRequests
        String nameRequest = "bulb";
        String typeRequest = "Water";
        String weaknessRequest = "Fire";
        double weightRangeBottom = 4.5;
        double weightRangeTop = 100;

        //Print starters
        String searchForName = "Here's the Pokemon you are looking for: "
                + generationOne.searchForName(nameRequest).get(0).getName();
        String searchForType = "\n" + "These Pokemon have the Type you are looking for: ";
        String searchForWeakness = "\n" + "\n" + "These Pokemon have that Weakness: ";
        String searchForWeightRange =  "\n" + "\n" + "These Pokemon are in that weight range: ";

        // Filter Functions
        System.out.println(searchForName);

        System.out.println(searchForType);
        for (int index = 0; index < generationOne.searchForType(typeRequest).size(); index++) {
            if (index == 0) {
                System.out.print(generationOne.searchForType(typeRequest).get(index).getName());
            } else {
                System.out.print(", " + generationOne.searchForType(typeRequest).get(index).getName());
            }
        }

        System.out.println(searchForWeakness);
        for (int index = 0; index < generationOne.searchForWeakness(weaknessRequest).size(); index++) {
            if (index == 0) {
                System.out.print(generationOne.searchForWeakness(weaknessRequest).get(index).getName());
            } else {
                System.out.print(", " + generationOne.searchForWeakness(weaknessRequest).get(index).getName());
            }

        }

        System.out.println(searchForWeightRange);
        for (int index = 0; index < generationOne.searchWeightRange(weightRangeBottom, weightRangeTop).size(); index++) {
            if (index == 0) {
                System.out.print(
                        generationOne.searchWeightRange(weightRangeBottom, weightRangeTop).get(index).getName());
            } else {
                System.out.print(", " +
                        generationOne.searchWeightRange(weightRangeBottom, weightRangeTop).get(index).getName());
            }
        }



        // Analysis Functions
        System.out.println("\n" + "Here's the average weight of your pokemon: "
                + Pokedex.averageWeight(generationOne.getPokemon()));

        System.out.println("\n" + "Here's the weight to height ratio of your pokemon: "
                + Pokedex.weightHeightRatio(generationOne.getPokemon()[0]));

        System.out.println("\n" + "Here's your tallest pokemon: " + Pokedex.maxHeight(generationOne.getPokemon()));

        System.out.println("\n" + "This is the index of the pokemon with the longest name: "
                + Pokedex.longestNameId(generationOne.getPokemon()));

    }
}