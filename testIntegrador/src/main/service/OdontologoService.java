package main.service;

import main.dao.Idao;
import main.entity.Odontologo;

import java.util.List;

public class OdontologoService {

    private Idao<Odontologo> odontologoIdao;

    public OdontologoService(){

    }

    public OdontologoService(Idao<Odontologo> odontologoIdao) {
        this.odontologoIdao = odontologoIdao;
    }

    public void setOdontologoIdao(Idao<Odontologo> odontologoIdao) {
        this.odontologoIdao = odontologoIdao;
    }

    public Odontologo guardar(Odontologo odontologo){
        odontologoIdao.agregar(odontologo);
        return odontologo;
    }

    public List<Odontologo> consultarTodo (){
        return odontologoIdao.listarTodos();
    }

    public Odontologo buscarPorId (String id){
        return odontologoIdao.buscarPorId(id);
    }

    public void eliminar (String id){
        odontologoIdao.eliminar(id);
    }
}
