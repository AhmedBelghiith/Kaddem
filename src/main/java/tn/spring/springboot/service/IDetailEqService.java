package tn.spring.springboot.service;
import tn.spring.springboot.entities.DetailEquipe;


import java.util.List;

public interface IDetailEqService {
    List<DetailEquipe> getAllDetailEquipe();
    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe);
    DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe);
    void deleteDetailEquipe (Long id);
    List<DetailEquipe> findByThematiqueLike(String thematique);
    List<DetailEquipe> findBySalleLike(String salle);
    DetailEquipe getDetailEquipeById(Long idDetailEquipe);
    public List<DetailEquipe> getAllDEquipes(Integer pageNo, Integer pageSize, String sortBy);
    List<DetailEquipe> searchDetailEquipes(String query);

    DetailEquipe findDetailEquipeByEquipe(Long idEquipe);

    public List<DetailEquipe>getAllAsc();
    public List<DetailEquipe>getAllDesc();
    DetailEquipe addAndAssignDetailEquipeToEquipe(DetailEquipe detailEquipe, Long idEquipe);

}
