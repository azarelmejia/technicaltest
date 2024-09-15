package app.technicaltest.Service;

import app.technicaltest.Interfaces.iOrders;
import app.technicaltest.Repository.OrdersRepository;
import app.technicaltest.models.GlobalRespModel;
import app.technicaltest.models.Orderdetail;
import app.technicaltest.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServices implements iOrders {
    @Autowired
    private OrdersRepository orderRepository;
    GlobalRespModel globalRespModel = new GlobalRespModel();

    @Override
    public List<Orderdetail> getOrders() {
        return orderRepository.findAllOrdersWithDetails();
    }

    @Override
    public GlobalRespModel addOrder(Orders orders) {
        globalRespModel.setMessage("Error el crear la orden");
        globalRespModel.setStatus("Failed");
        try {

            var rs = orderRepository.save(orders);

            globalRespModel.setMessage("El servicio se ha agregado correctamente");
            globalRespModel.setStatus("Success");

            return globalRespModel;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
