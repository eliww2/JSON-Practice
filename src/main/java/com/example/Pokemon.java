package com.example;

public class Pokemon {

    private int id;
    private String num; //change name
    private String name;
    private String[] type;
    private String height;
    private String weight;
    private String candy; //candy name instead
    private int candy_count;     // I want to change this name to candyToEvolve
    private String[] weaknesses;

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
    public final String getNum() { return num; }



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
    public final String getCandy() { return candy; }



    /**
     * Get the candy_count for this Pokemon.
     *
     * @return the candy_count for this Pokemon.
     */
    public final int getCandy_count() { return candy_count; }

    /**
     * Get the weaknesses for this Pokemon.
     *
     * @return the weaknesses for this Pokemon.
     */
    public final String[] getWeaknesses() { return weaknesses; }


}
