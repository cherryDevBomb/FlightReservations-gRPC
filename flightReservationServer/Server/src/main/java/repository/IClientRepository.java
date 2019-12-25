package repository;

import model.Client;

public interface IClientRepository extends IRepository<Client> {

    public int getId(Client client);
    public void delete(int id);
}
