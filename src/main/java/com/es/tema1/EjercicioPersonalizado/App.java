package com.es.tema1.EjercicioPersonalizado;

import com.es.tema1.EjercicioPersonalizado.prueba.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    static DbConnection conexion = new DbConnection();





    public static void main(String[] args) {
        System.out.println();

        DbConnection conexionBdd = new DbConnection();

        conexion.establecerConexion();
        Connection conn = conexion.getConnection();

        String query = "Insert into user (name, email, password) values(?,?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,"Eliaser");
            stmt.setString(2,"elia@gmail.com");
            stmt.setString(3,"1234");

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas >0){
                System.out.println("Inserccion realizada con éxito");
            }else {
                System.out.println("No se realizo ninguna insercion.");
            }

            stmt.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Error");
        }
    }
}
