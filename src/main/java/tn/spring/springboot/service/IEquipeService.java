package tn.spring.springboot.service;

import tn.spring.springboot.entities.Equipe;


import java.util.List;

public interface IEquipeService {
    List<Equipe> getAllEquipe();
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    void deleteEquipe (Long id);
    List<Equipe> findByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant,Long idDepart);

}
