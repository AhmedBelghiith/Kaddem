package tn.spring.springboot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long>, PagingAndSortingRepository<Equipe,Long>{
    Equipe findEquipeByIdEquipe(Long idEquipe);
    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByNomEquipe(String nomEquipe);
    List<Equipe> findEquipeByNiveau(Niveau niveau);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant,Long idDepart);

    @Query("SELECT eq FROM Equipe eq WHERE " +
            "eq.nomEquipe LIKE CONCAT('%',:query, '%')")
    List<Equipe> searchEquipes(String query);

    @Query(value = "SELECT eq FROM Equipe eq")
    List<Equipe> findAllAsc(Sort sort);

    @Query(value = "SELECT eq FROM Equipe eq")
    List<Equipe> findAllDesc(Sort sort);


}
