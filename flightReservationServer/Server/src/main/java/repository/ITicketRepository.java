package repository;

import model.Ticket;

public interface ITicketRepository extends IRepository<Ticket> {

    public int getId(Ticket ticket);
    public void delete(int id);
}
