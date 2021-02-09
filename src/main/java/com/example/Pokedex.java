package com.example;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Pokedex {
    private Pokemon[] pokemon;

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public Pokedex() { }

    // Filter methods

    public List<Pokemon> searchForName(String searchQuery) {
        List<Pokemon> pokemonWithName = new ArrayList<>();

        if (searchQuery == null) {
            throw new NullPointerException();
        }

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            if (pokemon[pokemonIndex].getName().toLowerCase().startsWith(searchQuery.toLowerCase())) {
                pokemonWithName.add(pokemon[pokemonIndex]);
            }
        }

        return pokemonWithName;
    }

    public List<Pokemon> searchForType(String searchQuery) {
        List<Pokemon> pokemonWithType = new ArrayList<>();

        if (searchQuery == null) {
            throw new NullPointerException();
        }

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            for (int typeIndex = 0; typeIndex < pokemon[pokemonIndex].getType().length; typeIndex++) {
               if (pokemon[pokemonIndex].getType()[typeIndex].equalsIgnoreCase(searchQuery)) {
                   pokemonWithType.add(pokemon[pokemonIndex]);
               }
            }
        }

        return pokemonWithType;
    }

    public List<Pokemon> searchForWeakness(String searchQuery) {
        List<Pokemon> pokemonWithWeakness = new ArrayList<>();

        if (searchQuery == null) {
            throw new NullPointerException();
        }

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            for (int weaknessIndex = 0; weaknessIndex < pokemon[pokemonIndex].getWeaknesses().length; weaknessIndex++) {
                if (pokemon[pokemonIndex].getWeaknesses()[weaknessIndex].equalsIgnoreCase(searchQuery)) {
                    pokemonWithWeakness.add(pokemon[pokemonIndex]);
                }
            }
        }

        return pokemonWithWeakness;
    }

    public List<Pokemon> searchHeightRange(double minHeight, double maxHeight) {
        List<Pokemon> pokemonWithHeight = new ArrayList<>();

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            int endOfWeight = 3;
            String weightString = pokemon[pokemonIndex].getWeight();
            double weightDouble = Double.parseDouble(weightString.substring(0, weightString.length() - 3));
            if (weightDouble >= minHeight && weightDouble <= maxHeight) {
                pokemonWithHeight.add(pokemon[pokemonIndex]);
            }
        }

        return pokemonWithHeight;
    }
}
