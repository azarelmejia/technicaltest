package app.technicaltest.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorder", nullable = false)
    private Integer idorder;

    private Integer iddetails;

    @Column(name = "customerid")
    private Integer customerid;

    @Column(name = "offers", length = 50)
    private String offers;

    @ColumnDefault("getdate()")
    @Column(name = "created")
    private LocalTime created;

    @ColumnDefault("1")
    @Column(name = "enabled")
    private Integer enabled;

}