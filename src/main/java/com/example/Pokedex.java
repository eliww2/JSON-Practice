package com.example;

import com.sun.istack.internal.NotNull;

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
    public List<Pokemon> searchForName(@NotNull String searchQuery) {
        List<Pokemon> pokemonWithName = new ArrayList<>();

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
    public List<Pokemon> searchForType(@NotNull String searchQuery) {
        List<Pokemon> pokemonWithType = new ArrayList<>();

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
    public List<Pokemon> searchForWeakness(@NotNull String searchQuery) {
        List<Pokemon> pokemonWithWeakness = new ArrayList<>();

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
    public List<Pokemon> searchWeightRange(double minWeight, double maxWeight) {
        List<Pokemon> pokemonWithWeight = new ArrayList<>();

        if (minWeight >= maxWeight) {
            throw new IllegalArgumentException();
        }

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            String weightString = pokemon[pokemonIndex].getWeight();
            double weightDouble =
                    Double.parseDouble(weightString.substring(0, weightString.length() - Pokemon.WEIGHT_OFFSET));

            if (weightDouble >= minWeight && weightDouble <= maxWeight) {
                pokemonWithWeight.add(pokemon[pokemonIndex]);
            }
        }

        return pokemonWithWeight;
    }

    // Analysis methods

    /**
     *
     * @param pokemon Takes array of Pokemon and calculates the average weight.
     * @return average weight as double in Kg.
     */
    public static double averageWeight(@NotNull Pokemon[] pokemon) {
        double totalWeight = 0;
        int pokemonCount = 0;

        if (pokemon.length < 1) {
            throw new IllegalArgumentException();
        }

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            if (pokemon[pokemonIndex] != null) {
                String weightString = pokemon[pokemonIndex].getWeight();
                double weightDouble =
                        Double.parseDouble(weightString.substring(0, weightString.length() - Pokemon.WEIGHT_OFFSET));
                totalWeight += weightDouble;
                pokemonCount++;
            }
        }

        return totalWeight / pokemonCount;
    }

    /**
     *
     * @param pokemon Takes a single Pokemon.
     * @return The ratio the weight divided by its height.
     */
    public static double weightHeightRatio(@NotNull Pokemon pokemon) {
        String weightString = pokemon.getWeight();
        double weightDouble =
                Double.parseDouble(weightString.substring(0, weightString.length() - Pokemon.WEIGHT_OFFSET));

        String heightString = pokemon.getHeight();
        double heightDouble =
                Double.parseDouble(heightString.substring(0, weightString.length() - Pokemon.HEIGHT_OFFSET));

        return weightDouble / heightDouble;
    }

    /**
     *
     * @param pokemon Takes an array of Pokemon.
     * @return a String representation of the tallest Pokemon's height.
     */
    public static String maxHeight(@NotNull Pokemon[] pokemon) {
        Pokemon tallestPokemon = pokemon[0];
        double maxHeight = 0;

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            String heightString = pokemon[pokemonIndex].getHeight();
            double heightDouble =
                    Double.parseDouble(heightString.substring(0, heightString.length() - Pokemon.HEIGHT_OFFSET));
            if (heightDouble > maxHeight) {
                tallestPokemon = pokemon[pokemonIndex];
                maxHeight = heightDouble;
            }
        }

        return tallestPokemon.getHeight();
    }

    /**
     * If more than one Pokemon has the same length name, the first to appear will return.
     *
     * @param pokemon Takes an array of Pokemon.
     * @return The Id of the Pokemon with the longest name.
     */
    public static int longestNameId(@NotNull Pokemon[] pokemon) {
        Pokemon longestName = pokemon[0];

        for (int pokemonIndex = 0; pokemonIndex < pokemon.length; pokemonIndex++) {
            if (pokemon[pokemonIndex].getName().split(" ")[0].length() > longestName.getName().length()) {
                longestName = pokemon[pokemonIndex];
            }
        }

        return longestName.getId();
    }

}
