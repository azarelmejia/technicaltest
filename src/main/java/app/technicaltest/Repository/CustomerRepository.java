package app.technicaltest.Repository;

import app.technicaltest.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
}
