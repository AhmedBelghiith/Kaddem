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
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private Long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    private float note;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;
    //onettomany unidirectionnel

    @ManyToOne
    private Departement departement;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "etudiants")
    @JsonIgnore
    private Set<Equipe> equipes;


}
