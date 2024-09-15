package app.technicaltest.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "DetailsOrder")
public class DetailsOrder {
    @Id
    @Column(name = "iddetails", nullable = false)
    private Integer iddetails;

    @Column(name = "idproduct")
    private Integer idproduct;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price", precision = 15, scale = 2)
    private BigDecimal price;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "category", length = 200)
    private String category;

    @Lob
    @Column(name = "image")
    private String image;

    @Column(name = "offers", length = 50)
    private String offers;

    @ColumnDefault("getdate()")
    @Column(name = "created")
    private LocalTime created;

    @ColumnDefault("1")
    @Column(name = "enabled")
    private Integer enabled;

}