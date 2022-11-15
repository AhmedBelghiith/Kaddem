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
@Table(name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniv")
    private Long idUniv;
    private String nomUniv;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Departement> departements;
}
