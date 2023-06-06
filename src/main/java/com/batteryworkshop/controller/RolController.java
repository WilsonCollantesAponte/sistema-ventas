/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.batteryworkshop.controller;

import com.batteryworkshop.interfaces.CRUD;
import com.batteryworkshop.model.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuniorMiguel
 */
public class RolController implements CRUD {

    //manipular el acceso de datos al modelo
    //conexcion ha sido un exito o un error
    Conexion estado = new Conexion();
    Connection con;
    //prepara toda la consulta que enviamos por java
    PreparedStatement ps;
    //trae todos los resultados que hayamos consultado en la consulta
    ResultSet rs;
    //poder ejecutar en nuestra consulta
    String sql = "";

    @Override
    public List<Object> listar()  {
        //nos trae toda la lista de la tabla rol
        List lista = new ArrayList<>();
        sql = "select *from Rol Order By descripcion desc";
        try {
            con = estado.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //pregunta si aún hay regitros 
            while (rs.next()) {
                //formas de imprimer los datos metodos set y get
//                Rol rol = new Rol();
//                rol.setRolId(rs.getInt(1));
//                rol.setDescripcion(rs.getString(2));
//                lista.add(rol);
//                
//                //2do con los constructores
//                 rol = new Rol(rs.getInt(1), rs.getString(2));
//                 lista.add(rol);
                 
                 //3ro 
                 lista.add(new Rol(rs.getInt(1), rs.getString(2)));
                 
                 
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);

        }finally{
            try {
                if(con!=null){
                con.close();
                }
                if(ps!=null){
                ps.close();
                }
                if(rs!=null){
                rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }

        return lista;
    }

    @Override
    public void registrar(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object obtenerObjecto(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> listar(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
