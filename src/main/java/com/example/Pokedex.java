package com.example;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
    private Pokemon[] pokemon;

    /** @return Pokemon for this Pokedex. */
    public Pokemon[] getPokemon() { return pokemon; }

    /** Empty Constructor. */
    public Pokedex() { }

    // Filter methods

    /**
     * Ignores case and does not have to be full name
     *
     * @param searchQuery The name to be searched for.
     * @return List<Pokemon> that contains pokemon whose name starts with searchQuery.
     */
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

    /**
     * Ignores case but must give a complete type.
     *
     * @param searchQuery The type to be searched for.
     * @return List<Pokemon> that contains pokemon whose have type of searchQuery.
     */
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

    /**
     * Ignores case but must give a complete weakness.
     *
     * @param searchQuery The weakness to be searched for.
     * @return List<Pokemon> that contains pokemon whose have a weakness of searchQuery.
     */
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

    /**
     * (Inclusive) Includes pokemon with minWeight and maxWeight.
     *
     * @param minWeight The minimum weight for a pokemon.
     * @param maxWeight The maximum weight for a pokemon.
     * @return List<Pokemon> that contains pokemon whose weight is with [minWeight, maxWeight].
     */
    public List<Pokemon> searchHeightRange(double minWeight, double maxWeight) {
        List<Pokemon> pokemonWithHeight = new ArrayList<>();

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            int endOfWeight = 3;
            String weightString = pokemon[pokemonIndex].getWeight();
            double weightDouble = Double.parseDouble(weightString.substring(0, weightString.length() - 3));
            if (weightDouble >= minWeight && weightDouble <= maxWeight) {
                pokemonWithHeight.add(pokemon[pokemonIndex]);
            }
        }

        return pokemonWithHeight;
    }

}
