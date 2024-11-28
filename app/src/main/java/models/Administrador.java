package models;

public class Administrador {
    //Variables
    private int    id_administrador;
    private int    edadMinima = 18;
    private int    ingresoMinimo = 1500000;
    private String nombre;
    private String password;

    //Costructor por defecto
    public Administrador()
    {
        id_administrador = 1;
        nombre = "only";
        password = "1234";
    }

    //Constructor con parametros

    public Administrador(int id_administrador, String nombre, String password) {
        this.id_administrador = id_administrador;
        this.nombre = nombre;
        this.password = password;
    }

    //Getter and Setter

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String vnombre){nombre = vnombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String vpassword) {
        password = vpassword;
    }


    // Metodo para validar que no queden valores en blanco
    public boolean textVacios(Integer cantValores, String valor1, String valor2, String valor3) {
        boolean x;
        switch (cantValores){
            case 1:
                x = (valor1.isEmpty());
                break;
            case 2:
                x = (valor1.isEmpty() || valor2.isEmpty());
                break;
            case 3:
                x = (valor1.isEmpty() || valor2.isEmpty() || valor3.isEmpty());
                break;
            default:
                x = false;
                break;
        }
        return x;
    }

   /* // Metodo para validar que ingresos sea el requerido
    public boolean textVacios(Integer cantValores, String valor1, String valor2, String valor3) {
        boolean x;
        switch (cantValores){
            case 1:
                x = (valor1.isEmpty());
                break;
            case 2:
                x = (valor1.isEmpty() || valor2.isEmpty());
                break;
            case 3:
                x = (valor1.isEmpty() || valor2.isEmpty() || valor3.isEmpty());
                break;
            default:
                x = false;
                break;
        }
        return x;
    }

    // Metodo para validar que la edad sea la requerida
    public boolean textVacios(Integer cantValores, String valor1, String valor2, String valor3) {
        boolean x;
        switch (cantValores){
            case 1:
                x = (valor1.isEmpty());
                break;
            case 2:
                x = (valor1.isEmpty() || valor2.isEmpty());
                break;
            case 3:
                x = (valor1.isEmpty() || valor2.isEmpty() || valor3.isEmpty());
                break;
            default:
                x = false;
                break;
        }
        return x;
    }*/

}
