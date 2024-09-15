package app.technicaltest.Interfaces;
import app.technicaltest.models.Customers;

import java.util.List;

public interface iCustomers {
    public List<Customers> getCustomers();
    public Customers findCustomer(Integer idCustomer);
    public void addCustomer(Customers customers);
}
