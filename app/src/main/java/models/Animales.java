package models;

import java.util.Date;

public class Animales {
    private String nombre;
    private int edad;
    private String color;
    private String sexo;
    private boolean esteril;
    private Date fechaNac;
    private String foto;
    private Date fechaIngreso;

    // Constructor
    public Animales(String nombre, int edad, String color, String sexo, boolean esteril, Date fechaNac, String foto) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
        this.sexo = sexo;
        this.esteril = esteril;
        this.foto = foto;
    }

    public Animales() {

    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Color: " + color);
        System.out.println("Sexo: " + sexo);
        System.out.println("Esteril: " + esteril);
        System.out.println("Fecha nacimiento: " + fechaNac);
        System.out.println("Foto: " + foto);

    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getColores() {
        return color;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean getEsteril() {
        return esteril;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public String getFoto(){
        return foto;
    }

    // Setters
    public void setNombre() {
        this.nombre = nombre;
    }

    public void setEdad() {
        this.edad = edad;
    }

    public void setColores() {
        this.color = color;
    }

    public void setSexo() {
        this.sexo = sexo;
    }

    public void setEsteril() {
        this.esteril = esteril;
    }

    public void setFechaNac() {
        this.fechaNac = fechaNac;
    }

    public void setFoto(){
        this.foto = foto;
    }
}



