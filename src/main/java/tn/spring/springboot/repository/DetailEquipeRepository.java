package tn.spring.springboot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Equipe;

import java.util.List;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Long>, PagingAndSortingRepository<DetailEquipe,Long> {
    List<DetailEquipe> findByThematiqueLike(String thematique);
    List<DetailEquipe> findBySalleLike(String salle);
    DetailEquipe findDetailEquipeByIdDetailEquipe(Long idDetailEquipe);
    @Query("SELECT deq FROM DetailEquipe deq WHERE " +
            "deq.salle LIKE CONCAT('%',:query, '%')" + "Or deq.thematique LIKE CONCAT('%',:query, '%')")
    List<DetailEquipe> searchDetailEquipes(String query);

    DetailEquipe findDetailEquipeByEquipeIdEquipe(Long idEquipe);

    @Query(value = "SELECT deq FROM DetailEquipe deq")
    List<DetailEquipe> findAllAsc(Sort sort);

    @Query(value = "SELECT deq FROM DetailEquipe deq")
    List<DetailEquipe> findAllDesc(Sort sort);




}
