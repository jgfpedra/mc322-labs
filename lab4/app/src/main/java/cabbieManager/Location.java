package cabbieManager;

/**
 * Enumeração que representa locais específicos no sistema de gerenciamento de táxis.
 *
 * Cada local possui coordenadas (x, y) e um nome associado. Os locais disponíveis
 * incluem aeroporto, estação de trem, shopping, escola, parque, hospital, biblioteca e estádio.
 *
 * Métodos principais:
 * - {@link #getX()} : Obtém a coordenada x do local.
 * - {@link #getY()} : Obtém a coordenada y do local.
 * - {@link #getName()} : Obtém o nome do local.
 * - {@link #valueOfName(String)} : Retorna a enumeração correspondente a um nome de local, se existir.
 *
 * As coordenadas são representadas como inteiros e podem ser utilizadas para cálculos de distância
 * ou para fins de mapeamento.
 */
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
     * Retorna a enumeração correspondente a um nome de local.
     *
     * @param name o nome do local a ser pesquisado.
     * @return a enumeração correspondente ao nome fornecido, ou null se não existir.
     */
    public static Location valueOfName(String name) {
        for (Location location : Location.values()) {
            if (location.name.equals(name)) {
                return location;
            }
        }
        return null;
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