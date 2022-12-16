package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.spring.springboot.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByPrenomE(String prenom);
    List<Etudiant> findByEquipes_IdEquipe(Long idEquipe);


}
