package app.technicaltest.Interfaces;

import app.technicaltest.models.GlobalRespModel;
import app.technicaltest.models.Pay;

import java.util.List;

public interface iPays {
    List<Pay> getPay();

    GlobalRespModel payProccess();
}
