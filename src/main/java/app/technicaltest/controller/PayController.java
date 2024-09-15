package app.technicaltest.controller;

import app.technicaltest.Service.PayServices;
import app.technicaltest.models.GlobalRespModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/pay")
public class PayController{

    private final PayServices payServices;

    public PayController(PayServices payServices) {
        this.payServices = payServices;
    }

    @GetMapping("/execute")
    public GlobalRespModel execute() {
        try {
            return payServices.payProccess();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
