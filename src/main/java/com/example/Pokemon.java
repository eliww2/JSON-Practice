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
    /** @return the id for this Pokemon. */
    public int getId() { return id; }

    /** @return the pokemonNumber for this Pokemon. */
    public String getPokemonNumber() { return pokemonNumber; }

    /** @return the name for this Pokemon. */
    public String getName() { return name; }

    /** @return the types for this Pokemon. */
    public String[] getType() { return type; }

    /** @return the height for this Pokemon. */
    public String getHeight() { return height; }

    /** @return the weight for this Pokemon. */
    public String getWeight() { return weight; }

    /** @return the candyName for this Pokemon. */
    public String getCandyName() { return candyName; }

    /** @return the candyToEvolve for this Pokemon. */
    public int getCandyToEvolve() { return candyToEvolve; }

    /** @return the weaknesses for this Pokemon. */
    public String[] getWeaknesses() { return weaknesses; }


}
