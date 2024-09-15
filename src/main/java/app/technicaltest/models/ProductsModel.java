package app.technicaltest.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsModel {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Rating {
        private double rate;
        private int count;
    }
}

