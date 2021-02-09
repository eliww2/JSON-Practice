package com.example;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

    private int id;
    @SerializedName("num")
    private String pokemonNumber;
    private String name;
    private String[] type;
    private String height;
    private String weight;
    @SerializedName("candy")
    private String candyName;
    @SerializedName("candy_count")
    private int candyToEvolve;
    private String[] weaknesses;

    /** Empty Constructor. */
    public Pokemon() {}

    // All of the get methods.
    /**
     * Get the id for this Pokemon.
     *
     * @return the id for this Pokemon.
     */
    public final int getId() { return id; }

    /**
     * Get the num for this Pokemon.
     *
     * @return the num for this Pokemon.
     */
    public final String getPokemonNumber() { return pokemonNumber; }

    /**
     * Get the name for this Pokemon.
     *
     * @return the name for this Pokemon.
     */
    public final String getName() { return name; }

    /**
     * Get the type for this Pokemon.
     *
     * @return the type for this Pokemon.
     */
    public final String[] getType() { return type; }

    /**
     * Get the height for this Pokemon.
     *
     * @return the height for this Pokemon.
     */
    public final String getHeight() { return height; }

    /**
     * Get the weight for this Pokemon.
     *
     * @return the weight for this Pokemon.
     */
    public final String getWeight() { return weight; }

    /**
     * Get the candy for this Pokemon.
     *
     * @return the candy for this Pokemon.
     */
    public final String getCandyName() { return candyName; }

    /**
     * Get the candy_count for this Pokemon.
     *
     * @return the candy_count for this Pokemon.
     */
    public final int getCandyToEvolve() { return candyToEvolve; }

    /**
     * Get the weaknesses for this Pokemon.
     *
     * @return the weaknesses for this Pokemon.
     */
    public final String[] getWeaknesses() { return weaknesses; }


}
