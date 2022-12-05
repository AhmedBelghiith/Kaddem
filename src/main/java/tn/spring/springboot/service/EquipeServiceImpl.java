package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;
import tn.spring.springboot.repository.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {

    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe findEquipeByIdEquipe(Long idEquipe) {
        return equipeRepository.findEquipeByIdEquipe(idEquipe);
    }

    @Override
    public List<Equipe> getEquipeByNomEquipe(String nomEquipe) {
        return equipeRepository.findEquipeByNomEquipe(nomEquipe);
    }

    @Override
    public List<Equipe> getEquipeByNiveau(Niveau niveau) {
        return equipeRepository.findEquipeByNiveau(niveau);
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant, Long idDepart) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idetdudiant,idDepart);
    }


}
