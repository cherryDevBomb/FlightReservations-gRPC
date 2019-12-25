package repository;

public interface IRepository<T> {

    void save(T entity);
    T findOne(int id);
}


