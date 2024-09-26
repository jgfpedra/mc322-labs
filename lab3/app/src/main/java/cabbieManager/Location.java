package cabbieManager;

/**
 * Enum representing various locations within the taxi system.
 * <p>
 * Each location has a unique set of coordinates (x, y) and a name that represents the location.
 * </p>
 */
public enum Location {
    AEROPORTO(5, 18, "Aeroporto"),
    ESTACAO_DE_TREM(12, 8, "Estacao de Trem"),
    SHOPPING(20, 7, "Shopping"),
    ESCOLA(6, 23, "Escola"),
    PARQUE(0, 4, "Parque"),
    HOSPITAL(15, 11, "Hospital"),
    BIBLIOTECA(3, 19, "Biblioteca"),
    ESTADIO(22, 25, "Estadio");

    private int x;
    private int y;
    private String name;

    /**
     * Constructs a Location with the specified coordinates and name.
     *
     * @param x The x-coordinate of the location.
     * @param y The y-coordinate of the location.
     * @param name The name of the location.
     */
    Location(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * Returns the x-coordinate of the location.
     *
     * @return The x-coordinate.
     */
    public int getX(){
        return this.x;
    }

    /**
     * Returns the y-coordinate of the location.
     *
     * @return The y-coordinate.
     */
    public float getY(){
        return this.y;
    }
    /**
     * Returns the name of the location.
     *
     * @return The name of the location.
     */
    public String getName(){
        return this.name;
    }
}
