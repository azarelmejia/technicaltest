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
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payid", nullable = false)
    private Integer payid;

    private Integer orderid;

    @Column(name = "descripcion")
    private String descripcion;

    @ColumnDefault("0")
    @Column(name = "balance", precision = 15, scale = 2)
    private BigDecimal balance;

    @ColumnDefault("0")
    @Column(name = "taxes", precision = 15, scale = 2)
    private BigDecimal taxes;

    @ColumnDefault("0")
    @Column(name = "Amounts", precision = 15, scale = 2)
    private BigDecimal amounts;

    @ColumnDefault("getdate()")
    @Column(name = "created")
    private LocalTime created;

    @ColumnDefault("1")
    @Column(name = "enabled")
    private Integer enabled;

}