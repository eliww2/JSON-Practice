package com.example;


import com.google.gson.Gson;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

//It may be a good idea to rename/refactor depending on the focus of your assignment.
public class PokemonTest {
    @Before
    public void setUp() {
        try {
          Gson gson = new Gson();
          Reader jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/example.json"));
          Pokedex gen1 = gson.fromJson(jsonReader, Pokedex.class);
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void sanityCheck() {
    }
}