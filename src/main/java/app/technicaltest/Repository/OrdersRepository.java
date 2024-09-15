package app.technicaltest.Repository;

import app.technicaltest.models.Orderdetail;
import app.technicaltest.models.Orders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query("SELECT new app.technicaltest.models.Orderdetail(o.idorder, o.iddetails, o.customerid, d.idproduct, d.price, d.category, d.description, d.created, o.enabled) " +
            "FROM Orders o JOIN DetailsOrder d ON o.iddetails = d.iddetails")
    List<Orderdetail> findAllOrdersWithDetails();

    @Modifying
    @Transactional
    @Query("UPDATE Orders o SET o.enabled = :enabled WHERE o.idorder = :idorder")
    int updateOrderStatus(@Param("idorder") Integer idorder, @Param("enabled") int enabled);

}
