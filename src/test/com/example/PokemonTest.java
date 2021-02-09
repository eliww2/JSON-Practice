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

        @Test
        public void pokemonSearchTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assert false;
        }

        @Test
        public void typeSearchTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assert false;
        }

        @Test
        public void weaknessSearchTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assert false;
        }

        @Test
        public void heightSearchTest() {
            Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
            assert false;
        }

    }


}