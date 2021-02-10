package com.example;


import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;


/* What needs to be checked?

(Json)
1. Is Json deserialized properly in both main and test?

(Filters methods)
1. Search for Pokemon, this should only be the start of the name
  a. Check that if a pokemon starts with a certain string the correct number is returned.
  b. Check that if no pokemon starts with a certain string the array is empty.
2. Returns just Pokemon the with the type of request
3. Returns just Pokemon the with the weakness of request
4. Returns Pokemon within height Range (inclusive)

(Analysis methods)
1. Test that the average weight of an array of pokemon is right.
2. Test that the number of times a candyToEvolve is the mode.
3. Test the range of height in an array of pokemon.
4. Test the longest name in an array of pokemon.
  a. What if more than one have the same length?

 */

@RunWith(Enclosed.class)
public final class PokemonTest {
    private static Gson gson;
    private static Reader jsonReader;

    @Before
    public static void setUp() {
        try {
          gson = new Gson();
          jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/example.json"));
        } catch (Exception e) {
            assert false;
        }
    }

    public static class JsonTest {
        @Before public void setUp() {
            PokemonTest.setUp();
        }

        // Check Json is deserializing properly
        @Test
        public void DeserializeTest() {
          Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
          assertEquals(1, generationOne.getPokemon()[0].getId());
        }
    }

    public static class FilterTest {
        @Before public void setUp() {
            PokemonTest.setUp();
        }

        // PokemonSearch method tests
        @Test
        public void nameReturnedTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(6, generationOne.searchForName("nido").size());
        }

        @Test
        public void nameFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(0, generationOne.searchForName("q").size());
        }

        // TypeSearch method tests
        @Test
        public void typeFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(12, generationOne.searchForType("fire").size());
        }

        @Test
        public void typeNotFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(0, generationOne.searchForType("fi").size());
        }

        // WeaknessSearch method tests
        @Test
        public void weaknessFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(11, generationOne.searchForWeakness("fairy").size());
        }

        @Test
        public void weaknessNotFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(0, generationOne.searchForWeakness("fair").size());
        }

        // HeightSearch method test
        @Test
        public void heightInclusiveTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            String snorlax = generationOne.searchWeightRange(450, 460).get(0).getName();
            assertEquals("Snorlax", snorlax);
        }

        @Test
        public void heightSearchTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(150, generationOne.searchWeightRange(0, 459.9).size());
        }

    }

    public static class AnalysisTest {
        @Before public void setUp() {
            PokemonTest.setUp();
        }

        // AverageWeight tests
        @Test
        public void averageWeightTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(46, Pokedex.averageWeight(generationOne.getPokemon()));
        }

        // ModeCandyToEvolve tests
        @Test
        public void ModeCandyTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(50, Pokedex.modeCandyToEvolve(generationOne.getPokemon()));
        }

        // maxHeight tests
        @Test
        public void maxHeightTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(0, Pokedex.maxHeight(generationOne.getPokemon()));
        }

        // LongestName test
        @Test
        public void LongestNameTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(4, Pokedex.longestNameId(generationOne.getPokemon()));
        }
    }

}