package repository;

import model.Agency;

public interface IAgencyRepository {

    public void save(Agency entity);
    public Agency findUser(String username);
    public boolean findByUsernameAndPassword(String username, String password);
}
