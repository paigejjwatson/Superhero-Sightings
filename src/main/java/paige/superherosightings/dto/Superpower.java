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
public class Superpower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int superpowerId;
    @Column(columnDefinition = "varchar(50)")
    private String superpower;
    @OneToOne(mappedBy = "superpower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Superhero superhero;
}
