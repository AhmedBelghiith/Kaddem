package tn.spring.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Contrat")
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContrat")
    private Long idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    private Boolean archive;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @ManyToOne
    @JsonIgnore
    private Etudiant etudiant;
}
