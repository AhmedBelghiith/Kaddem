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
import java.util.Set;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements IDepartementService{

    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement getDepartementById(Long idDepartement) {
        return departementRepository.findById(idDepartement).orElse(null);
    }

    @Override
    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public Departement updateDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

    @Override
    public Set<Departement> retrieveDepartementByUniversite(Long idUniv) {
        Universite universite =universiteRepository.findById(idUniv).orElse(null);
        Set<Departement> departements = universite.getDepartements();
        return departements;
    }


}
