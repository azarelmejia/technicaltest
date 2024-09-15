package app.technicaltest.Interfaces;

import app.technicaltest.models.GlobalRespModel;
import app.technicaltest.models.Orderdetail;
import app.technicaltest.models.Orders;

import java.util.List;

public interface iOrders {
    List<Orderdetail> getOrders();
    GlobalRespModel addOrder(Orders orders);
}
