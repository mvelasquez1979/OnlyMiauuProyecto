package models;

import java.util.Date;

public class Gatos extends Animales{
    private String raza;

    // Constructor
    public Gatos(String nombre, int edad, String raza, String color, String sexo, Boolean esteril, Date fechaNac, String foto) {
        super(nombre, edad, color, sexo, esteril, fechaNac, foto); // Llamada al constructor de la clase base
        this.raza = raza;
    }

    public Gatos() {
        super();
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // Llama al método de la clase base
        System.out.println("Raza: " + raza);
    }

    // Getter
    public String getRaza() {
        return raza;
    }

    // Setter
    public void setRaza() {
        this.raza = raza;
    }

}