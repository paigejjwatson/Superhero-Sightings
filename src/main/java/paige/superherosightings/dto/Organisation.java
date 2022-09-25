package paige.superherosightings.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Organisation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int organisationId;
    @Column(columnDefinition="varchar(50)")
    private String name;
    @Column(columnDefinition="varchar(255)")
    private String description;
    @Column(columnDefinition="varchar(255)")
    private String address;
    @Column(columnDefinition="varchar(50)")
    private String contact;
    @ManyToMany(mappedBy = "organisations", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Superhero> members;

}
