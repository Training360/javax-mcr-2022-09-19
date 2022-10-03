package training.employees.employees.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zip;

    private String city;

    private String line1;

    // Owner side - ez az oldal felelős a kapcsolatért
    // Itt van az FK
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Employee employee;
}
