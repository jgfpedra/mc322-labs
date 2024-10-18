package cabbieManager;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="location")
@XmlEnum
public enum Location {
    AEROPORTO(5, 18, "Aeroporto"),
    ESTACAO_DE_TREM(12, 15, "Estação de Trem"),
    SHOPPING(20, 7, "Shopping"),
    ESCOLA(6, 23, "Escola"),
    PARQUE(0, 4, "Parque"),
    HOSPITAL(15, 12, "Hospital"),
    BIBLIOTECA(3, 19, "Biblioteca"),
    ESTADIO(22, 25, "Estadio");
    private final int x;
    private final int y;
    private final String name;
    Location(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    /**
     * Returns the {@link Location} corresponding to the specified name.
     *
     * <p>This method iterates through the available {@link Location} values
     * and returns the one that matches the given name. If no match is found,
     * an {@link IllegalArgumentException} is thrown.</p>
     *
     * @param name the name of the location to retrieve
     * @return the {@link Location} associated with the given name
     * @throws IllegalArgumentException if no {@link Location} with the specified name exists
     */
    public static Location valueOfName(String name) {
        for (Location location : Location.values()) {
            if (location.name.equals(name)) {
                return location;
            }
        }
        throw new IllegalArgumentException("Invalid location name: " + name);
    }
    /**
     * Returns the x-coordinate of the location.
     * @return the x-coordinate of the location
     */
    public int getX() {
        return this.x;
    }
    /**
     * Returns the y-coordinate of the location.
     * @return the y-coordinate of the location
     */
    public int getY() {
        return this.y;
    }
    /**
     * Returns the name of the location.
     * @return the name of the location
     */
    public String getName() {
        return this.name;
    }
}