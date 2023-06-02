package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class configuracionJDBC {

    private String jdbcDriver;
    private String url;
    private String user;
    private String password;

    private Connection connection;

    public configuracionJDBC(String jdbcDriver, String url, String user, String password, Connection connection) {
        this.jdbcDriver = jdbcDriver;
        this.url = url;
        this.user = user;
        this.password = password;
        this.connection = connection;
    }

    public configuracionJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.url = "jdbc:h2:C:\\Users\\Rabbit\\Desktop\\DH\\Back End\\h2-2022-06-13\\h2\\bin;INIT=RUNSCRIPT FROM 'create.sql'";
        this.user = "sa";
        this.password = "sa";
    }

    public Connection conectarConBaseDeDatos() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
