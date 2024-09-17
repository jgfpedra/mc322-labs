package taxi;

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

    Location(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public String getName(){
        return this.name;
    }
}
