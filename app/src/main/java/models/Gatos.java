package models;


public class Gatos extends Animales{
    private static String razaGato;
    private static String[][] arrayGatos;

    public Gatos() {
        super();
    }


    // Método para establecer raza
    public  void setgatoRaza(String name) {
        razaGato = name;
    }

    // Método para obtener raza
    public  String getGatoArray() {
        return razaGato;
    }

    // Método para establecer array
    public  void setgatoArray(Integer id,String name) {
        getAnimalId(id);
        razaGato = name;
        arrayGatos[1][id] = String.valueOf(id);
        arrayGatos[2][id] = name ;

    }

    // Método para obtener array
    public  String getGatoRaza() {
        return razaGato;
    }

}