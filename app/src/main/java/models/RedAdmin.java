package models;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class RedAdmin {

    // Método para obtener la dirección IP local
    public String localIps() {
        try {
            // Obtener la dirección IP local
            InetAddress inetAddress = InetAddress.getLocalHost();

            // Retornar la dirección IP como String
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null; // Si no se puede obtener la IP, devolver null
        }
    }
}
