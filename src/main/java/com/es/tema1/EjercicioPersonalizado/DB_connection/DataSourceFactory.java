package com.es.tema1.EjercicioPersonalizado.DB_connection;


import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/BddDwes";
    //jdbc:mysql://127.0.0.1:3306/?user=root

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public enum DataSourceType{
        JDBC
    }

    public static BasicDataSource getDs(DataSourceType dataSourceType) {
        switch (dataSourceType) {
            case JDBC -> {
                BasicDataSource dataSource = new BasicDataSource();
                dataSource.setUrl(URL);
                dataSource.setUsername(USER);
                dataSource.setPassword(CONTRASENA);
                return dataSource;
            }
            default -> throw new IllegalArgumentException("Tipo de DataSource no soportado: " + dataSourceType);
        }
    }
}
