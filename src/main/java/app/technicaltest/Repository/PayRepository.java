package app.technicaltest.Repository;

import app.technicaltest.models.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, Integer> {
}


