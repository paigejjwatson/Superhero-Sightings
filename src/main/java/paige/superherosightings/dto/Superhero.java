package paige.superherosightings.dto;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int superheroId;
    @Column(columnDefinition="varchar(50)")
    private String name;
    @Column(columnDefinition="varchar(255)")
    private String description;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinTable(name = "superhero_superpower",
            joinColumns = {@JoinColumn(name = "superhero_id")},
            inverseJoinColumns = {@JoinColumn(name = "superpower_id")})
    private Superpower superpower;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @ToString.Exclude
    @JoinTable(name = "superhero_organisation",
            joinColumns = {@JoinColumn(name = "superhero_id")},
            inverseJoinColumns = {@JoinColumn(name = "organisation_id")})
    private List<Organisation> organisations;

    public void addOrganisation(Organisation organisation) {
        List<Organisation> old;
        if (this.getOrganisations() != null) {
            old = this.getOrganisations();
        } else {
            old = new ArrayList<>();
        }
        old.add(organisation);
        this.setOrganisations(old);
    }

    public String getOrganisationsString() {
        String string = "";
        List<Organisation> list = this.getOrganisations();
        for (Organisation org : list) {
            string = string + org.getName() + ", ";
        }
        return string;
    }
}
