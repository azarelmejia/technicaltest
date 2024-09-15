package app.technicaltest.controller;

import app.technicaltest.Service.OrderServices;
import app.technicaltest.models.GlobalRespModel;
import app.technicaltest.models.Orderdetail;
import app.technicaltest.models.Orders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrderServices orderServices;

    public OrdersController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @GetMapping("/list")
    public List<Orderdetail> getOrders() {
        try {
            return orderServices.getOrders();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/add")
    public GlobalRespModel add(@RequestBody Orders order) {
        try {
            return orderServices.addOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
