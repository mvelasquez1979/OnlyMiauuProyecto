package models;


public class Administrador {
    //Variables
    private int    id_administrador;
    private String nombre;
    private String password;
     boolean logUsu;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method para validar Login
   /* public boolean validaLogin(String nombUsuario, String logUsuario) {

        LoginValidator loginValidator = new LoginValidator();
        boolean loginSuccess;
        loginSuccess = loginValidator.enviarDatos(nombUsuario.trim(), logUsuario.trim());
        if (loginSuccess) {
            // Usuario encontrado, hacer algo
            Log.d("Login", "Usuario encontrado.");
        } else {
            // Usuario no encontrado o error
            Log.d("Login", "Usuario no encontrado.");
        }
        return loginSuccess;
    }*/

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

}
