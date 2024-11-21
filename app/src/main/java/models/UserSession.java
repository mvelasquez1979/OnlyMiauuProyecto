package models;

public class UserSession {
    // Variable estática para mantener el nombre del usuario
    private static String userName;

    // Método para establecer el nombre del usuario
    public  void setUserName(String name) {
        userName = name;
    }

    // Método para obtener el nombre del usuario
    public  String getUserName() {
        String[] partesNombre = userName.split(" ");
        return partesNombre[0];
    }

    // Método para obtener el nombre completo del usuario
    public  String getUserFullName() {
        return userName;
    }
}
