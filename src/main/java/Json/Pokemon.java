package Json;

public class Pokemon {

    private int id;

    /**
     * Get the id for this Pokemon.
     *
     * @return the id for this Pokemon.
     */
    public final int getId() { return id; }

    private String num; //change name

    /**
     * Get the num for this Pokemon.
     *
     * @return the num for this Pokemon.
     */
    public final String getNum() { return num; }

    private String name;

    /**
     * Get the name for this Pokemon.
     *
     * @return the name for this Pokemon.
     */
    public final String getName() { return name; }

    private String[] type;

    /**
     * Get the type for this Pokemon.
     *
     * @return the type for this Pokemon.
     */
    public final String[] getType() { return type; }

    private String height;

    /**
     * Get the height for this Pokemon.
     *
     * @return the height for this Pokemon.
     */
    public final String getHeight() { return height; }

    private String weight;

    /**
     * Get the weight for this Pokemon.
     *
     * @return the weight for this Pokemon.
     */
    public final String getWeight() { return weight; }

    private String candy; //candy name instead

    /**
     * Get the candy for this Pokemon.
     *
     * @return the candy for this Pokemon.
     */
    public final String getCandy() { return candy; }

    private int candy_count;     // I want to change this name to candyToEvolve

    /**
     * Get the candy_count for this Pokemon.
     *
     * @return the candy_count for this Pokemon.
     */
    public final int getCandy_count() { return candy_count; }

    private String[] weaknesses;

    /**
     * Get the weaknesses for this Pokemon.
     *
     * @return the weaknesses for this Pokemon.
     */
    public final String[] getWeaknesses() { return weaknesses; }

    public Pokemon(
        final int setId,
        final String setNum,
        final String setName,
        final String[] setType,
        final String setHeight,
        final String setWeight,
        final String setCandy,
        final int setCandy_count,
        final String[] setWeaknesses) {
      id = setId;
      num = setNum;
      name = setName;
      type = setType;
      height = setHeight;
      weight = setWeight;
      candy = setCandy;
      candy_count = setCandy_count;
      weaknesses = setWeaknesses;

    }

}
