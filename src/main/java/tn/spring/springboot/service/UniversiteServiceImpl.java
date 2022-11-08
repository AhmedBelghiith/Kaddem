package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Universite;
import tn.spring.springboot.repository.DepartementRepository;
import tn.spring.springboot.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite adduniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateuniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void deleteuniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public void assignUniversityToDepartement(Long idUniv, Long idDepart) {
        Universite universite= this.universiteRepository.findById(idUniv).orElse(null);
        Departement departement= this.departementRepository.findById(idDepart).orElse(null);
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);
    }
}
