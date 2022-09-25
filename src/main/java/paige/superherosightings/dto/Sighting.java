package paige.superherosightings.dto;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Sighting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sightingId;

    @ManyToOne
    @JoinColumn(name = "superhero_id", referencedColumnName = "superheroId")
    private Superhero superhero;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "locationId")
    private Location location;

    @Column(columnDefinition = "date")
    private LocalDate date;

}
