package tn.spring.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Equipe")
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe")
    private Long idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @OneToOne
    @JsonIgnore
    private DetailEquipe detailEquipe;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Etudiant> etudiants;
}
