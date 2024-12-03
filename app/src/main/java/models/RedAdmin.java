package models;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class RedAdmin {

    // Variable estática para mantener la IP sel servidor de servicios
    private static String iPLocal = "10.110.45.118";

    // Método para establecer IP
    public  void setIpLocal(String iPRecibida) {
        iPLocal = iPRecibida;
    }

    // Método para obtener IP
    public  String getIpLocal() {
        return iPLocal;
    }

}
