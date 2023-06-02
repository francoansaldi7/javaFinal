package main.dao;

import java.util.List;

public interface Idao<T> {

    public T agregar(T t);
    public void eliminar(String id);
    public T buscarPorId(String id);
    public List<T> listarTodos();

}
