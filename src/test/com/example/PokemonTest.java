package com.example;


import com.google.gson.Gson;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/* What needs to be checked?

(Json)
1. Is Json deserialized properly in both main and test?

 */
public class PokemonTest {
    private Gson gson;
    private Reader jsonReader;

    @Before
    public void setUp() {
        try {
          gson = new Gson();
          jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/example.json"));
        } catch (Exception e) {
            assert false;
        }
    }

    //Check Json is deserializing properly
    @Test
    public void JsonTest() {
        Pokedex generationOne = gson.fromJson(jsonReader, Pokedex.class);
        assertEquals(1, generationOne.getPokemon()[0].getId());
    }


}