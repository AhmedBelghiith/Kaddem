package tn.spring.springboot.service;

import tn.spring.springboot.entities.Departement;


import java.util.List;
import java.util.Set;

public interface IDepartementService {
    List<Departement> getAllDepartement();
    Departement getDepartementById(Long idDepartement);
    Departement addDepartement(Departement departement);
    Departement updateDepartement(Departement departement);
    void deleteDepartement(Long id);
    public Set<Departement> retrieveDepartementByUniversite(Long idUniv);
}
