package com.batteryworkshop.controller;
import com.batteryworkshop.model.Rol;
import java.util.List;

public class Conectar {

    public static void main(String[] args) {

//        Conexion cnn = new Conexion();
//        cnn.Conectar();
     

        //Mostrar consultas de prueba
        RolController rolC = new RolController();
        List lista = rolC.listar();
        Rol rol;
        for (int i = 0; i < lista.size(); i++) {
            rol = (Rol)lista.get(i);
            System.out.println(rol.getRolId() + " " + rol.getDescripcion());
        }
 
        
    }
}
