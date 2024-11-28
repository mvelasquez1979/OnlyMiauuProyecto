package models;

public class Animales {
    // Variable estática para mantener el nombre del animal
    private static Integer animalId;
    private static String animalName;

    // Constructor
    public Animales(int id, String nombre) {
        animalId = id;
        animalName = nombre;
    }

    public Animales() {

    }

    // Método para establecer el nombre del animal
    public  void setAnimalName(String name) {
        animalName = name;
    }

    // Método para obtener el nombre del animal
    public  String getAnimalName() {
        return animalName;
    }

    // Método para establecer el id del animal
    public  void setAnimalId(Integer id) {
        animalId = id;
    }

    // Método para obtener el id del animal
    public  Integer getAnimalId(Integer id) {
        return animalId;
    }

}



