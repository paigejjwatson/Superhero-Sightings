package paige.superherosightings.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationId;
    @Column(columnDefinition="varchar(50)")
    private String name;
    @Column(columnDefinition="varchar(255)")
    private String description;
    @Column(columnDefinition="varchar(255)")
    private String address;
    @Column(columnDefinition="decimal(10,6)")
    private double longitude;
    @Column(columnDefinition="decimal(10,6)")
    private double latitude;
}
