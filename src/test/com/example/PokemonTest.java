package com.example;


import com.google.gson.Gson;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


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
1.
2.
3.
4.

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
            assertEquals(4, generationOne.searchForName("nido").length);
        }

        @Test
        public void nameFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(0, generationOne.searchForName("q").length);
        }

        // TypeSearch method tests
        @Test
        public void typeFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(12, generationOne.searchForType("fire").length);
        }

        @Test
        public void typeNotFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(0, generationOne.searchForType("fi").length);
        }

        // WeaknessSearch method tests
        @Test
        public void weaknessFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(11, generationOne.searchForWeakness("fairy").length);
        }

        @Test
        public void weaknessNotFoundTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assertEquals(0, generationOne.searchForWeakness("fair").length);
        }

        // HeightSearch method tests
        @Test
        public void heightSearchTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            String snorlax = generationOne.searchHeightRange(450, 460)[0].getName();
            assertEquals("Snorlax", snorlax);
        }
    }


}