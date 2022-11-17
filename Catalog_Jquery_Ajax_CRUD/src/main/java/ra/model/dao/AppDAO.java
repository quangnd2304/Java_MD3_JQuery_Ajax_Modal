package ra.model.dao;

import java.util.List;

public interface AppDAO<T,V> {
    List<T> findAll();
    T findById(V id);
    boolean save(T t);
    boolean update(T t);
    boolean delete(V id);
}
