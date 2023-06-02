package test;

import main.dao.Idao;
import main.dao.configuracionJDBC;
import main.dao.implement.OdontologoDaoH2;
import main.entity.Odontologo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class Test {
    private static Idao<Odontologo> odontologoIdao = new OdontologoDaoH2(new configuracionJDBC());

    @BeforeClass
    public static void cargarOdontologos (){
        odontologoIdao.agregar(new Odontologo("1", "Garcia", "Joaquin"));
        odontologoIdao.agregar(new Odontologo("2", "Jimenez", "Laura"));
    }

    @org.junit.Test
    public void buscar (){
        Odontologo odontologo = odontologoIdao.buscarPorId("2");
        Assert.assertNotNull(odontologo);
    }

    @org.junit.Test
    public void listar (){
        Odontologo odontologo = (Odontologo) odontologoIdao.listarTodos();
        Assert.assertNotNull(odontologo);
    }

    @org.junit.Test
    public void agregar (){
        Odontologo odontologo = odontologoIdao.agregar(List<T>);
        Assert.assertNotNull(odontologo);
    }

}
