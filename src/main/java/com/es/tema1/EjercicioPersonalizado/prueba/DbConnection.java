package com.es.tema1.EjercicioPersonalizado.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // Ruta de nuestra base de datos
    private String servidor = "jdbc:mysql://127.0.0.1:3306/bdddwes";

    // Nombre de usuario de mysql
    private String username = "root";

    // Clave de usuario de mysql
    private String password = "root";

    // Nuestra librería mysql
    private String driver = "com.mysql.jdbc.Driver";

    // Objeto del tipo Connection para crear la conexión
    private static Connection con;

    public void establecerConexion() {
        try {
            // Cargar drivers de MySQL
            Class.forName(driver);

            // Establecer la conexion con la base de datos
            con = DriverManager.getConnection(servidor, username, password);

            System.out.println("Conexión realizada a la base de datos con éxito.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error!, conexión fallida a la base de datos.");
        }
    }

    public static Connection getConnection() {
        return con; // Retorno el objeto Connection
    }

    public static void cerrarBd(){
        try {
            con.close();
        }catch (Exception e){
            System.out.println("Error, algo ha ido mal");
        }
    }
}