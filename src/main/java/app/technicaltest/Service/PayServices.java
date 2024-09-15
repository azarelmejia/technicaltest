package app.technicaltest.Service;

import app.technicaltest.Interfaces.iPays;
import app.technicaltest.Repository.OrdersRepository;
import app.technicaltest.Repository.PayRepository;
import app.technicaltest.models.GlobalRespModel;
import app.technicaltest.models.Orderdetail;
import app.technicaltest.models.Orders;
import app.technicaltest.models.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PayServices implements iPays {

    @Autowired
    private PayRepository payRepository;
    @Autowired
    private OrderServices orderServices;
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Pay> getPay() {
        return payRepository.findAll();
    }

    @Override
    public GlobalRespModel payProccess(){
        boolean go = false;
        GlobalRespModel rs = new GlobalRespModel(200, "Failed", "Error al procesar el pago");
        try {

            double amount = 0.0;
            double taxes = 0.0;
            //Pay payModel = new Pay();

            List<Orderdetail> orders = orderServices.getOrders()
                    .stream()
                    .filter(orderModel -> orderModel.getEnabled() == 1)
                    .toList();

            if (orders.size() > 0) {
                orders.forEach(c -> {
                    Pay payModel = new Pay();

                    payModel.setOrderid(c.getIdorder());
                    payModel.setDescripcion("Pago");
                    payModel.setBalance(c.getPrice());
                    payModel.setTaxes(BigDecimal.valueOf(c.getPrice().doubleValue() * 0.15));
                    payModel.setAmounts(c.getPrice().add(BigDecimal.valueOf(c.getPrice().doubleValue() * 0.15)));
                    payModel.setEnabled(1);

                    payRepository.save(payModel);
                    ordersRepository.updateOrderStatus(c.getIdorder(), 2);

                });
                rs = new GlobalRespModel(200, "Success", "Proceso de pago completado");
            } else {
                rs = new GlobalRespModel(200, "Warning", "Proceso no encontro ordenes para el pago");
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
