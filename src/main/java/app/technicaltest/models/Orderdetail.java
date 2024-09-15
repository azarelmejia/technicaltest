package app.technicaltest.models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalTime;


/**
 * Mapping for DB view
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Orderdetails")
public class Orderdetail {
    @Id
    private Integer idorder;

    private Integer iddetails;
    private Integer customerid;
    private Integer idproduct;
    private BigDecimal price;
    private String category;
    private String description;
    private LocalTime created;
    private Integer enabled;

}