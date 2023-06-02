package main.dao.implement;

import main.dao.Idao;
import main.dao.configuracionJDBC;
import main.entity.Odontologo;
import org.apache.log4j.Logger;
import org.h2.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements Idao<Odontologo> {

    private configuracionJDBC configuracion;
    private Connection connection;

    public OdontologoDaoH2() {
    }

    private Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    public OdontologoDaoH2(configuracionJDBC configuracion) {
        this.configuracion = configuracion;
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        Connection conection = configuracion.conectarConBaseDeDatos();
        Statement statement = null;
        String query = String.format("INSERT INTO odontologos VALUES('%s','%s','%s')", odontologo.getId(), odontologo.getNombre(), odontologo.getApellido());;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e){
            logger.debug("No se ha guardado el odontologo");
            throw new RuntimeException(e);
        }
        logger.info("Se ha guardado el odontologo");
        return odontologo;
    }

    @Override
    public void eliminar(String id) {
        Connection conection = configuracion.conectarConBaseDeDatos();
        Statement statement = null;
        String query = String.format("DELETE FROM odontologos WHERE id = %", id);

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();

        } catch (SQLException e){
            logger.debug("No se ha eliminado el odontologo");
            throw new RuntimeException(e);
        }
        logger.info("Se ha eliminado el odontologo");
    }

    @Override
    public Odontologo buscarPorId(String id) {
        Connection conection = configuracion.conectarConBaseDeDatos();
        Statement statement = null;
        String query = String.format("SELECT id,nombre,apellido FROM odontologos where id = '%s'", id);

        Odontologo odontologo = null;

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String idOdontologo = resultSet.getString("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                odontologo = new Odontologo(idOdontologo, nombre, apellido);
            }
        } catch (SQLException e){
            logger.debug("No se ha encontrado el odontologo");
            throw new RuntimeException(e);
        }
        logger.info("Se ha encontrado el odontologo");
        return odontologo;

    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection conection = configuracion.conectarConBaseDeDatos();
        Statement statement = null;
        String query = String.format("SELECT * FROM odontologos");
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String idOdontologo = resultSet.getString("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                odontologos.add(new Odontologo(idOdontologo, nombre, apellido));

            }
        } catch (SQLException e){
            logger.debug("No se ha encontrado la lista de odontologos");
            throw new RuntimeException(e);
        }
        logger.info("Se han encontrado los siguientes odontologos");
        return odontologos;
    }
}
