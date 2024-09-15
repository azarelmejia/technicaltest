package app.technicaltest.controller;

import app.technicaltest.Service.ProductsServices;
import app.technicaltest.models.Customers;
import app.technicaltest.models.ProductsModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductsController {

    private final ProductsServices productsServices;

    public ProductsController(ProductsServices productsServices) {
        this.productsServices = productsServices;
    }

    @GetMapping("/api/products")
    public List<ProductsModel> getProducts() {
        try {
            return productsServices.apiProducts();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/api/products/{code}")
    public List<ProductsModel> getProducts(@PathVariable("code") Integer code) {
        try {
            return productsServices.apiProducts()
                    .stream()
                    .filter(productsModel -> productsModel.getId() == code)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/api/products/category/{category}")
    public List<ProductsModel> getProducts(@PathVariable("category") String category) {
        try {
            return productsServices.apiProducts()
                    .stream()
                    .filter(productsModel -> productsModel.getCategory() == category)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}





