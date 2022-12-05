package tn.spring.springboot.service;

import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;


import java.util.List;

public interface IEquipeService {
    List<Equipe> getAllEquipe();
    Equipe findEquipeByIdEquipe(Long idEquipe);
    List<Equipe> getEquipeByNomEquipe(String nomEquipe);
    List<Equipe> getEquipeByNiveau(Niveau niveau);
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    void deleteEquipe (Long id);
    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant,Long idDepart);
    // void faireEvoluerEquipes();

}
