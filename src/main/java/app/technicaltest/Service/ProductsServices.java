package app.technicaltest.Service;

import app.technicaltest.models.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Service
public class ProductsServices {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${external.api.url}")
    private String url;

    public List<ProductsModel> apiProducts() {
        List<ProductsModel> rs = (List<ProductsModel>) webClientBuilder.build()
                .get()
                .uri(url + "/products")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductsModel>>(){})
                .block();  // Bloquea y espera a la respuesta

        return rs;
    }

    public List<ProductsModel>  ProductsByid(Integer idProduct) {
        try {
            List<ProductsModel> rs = (List<ProductsModel>) webClientBuilder.build()
                    .get()
                    .uri(url + "/products/" + idProduct)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<ProductsModel>>(){})
                    .block();  // Bloquea y espera a la respuesta

            return rs;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
