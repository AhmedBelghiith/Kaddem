package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    Equipe findEquipeByIdEquipe(Long idEquipe);
    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByNomEquipe(String nomEquipe);
    List<Equipe> findEquipeByNiveau(Niveau niveau);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant,Long idDepart);

}
