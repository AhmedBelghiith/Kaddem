package tn.spring.springboot.service;

import tn.spring.springboot.entities.Departement;


import java.util.List;

public interface IDepartementService {
    List<Departement> getAllDepartement();
    Departement addDepartement(Departement departement);
    Departement updateDepartement(Departement departement);
    void deleteDepartement(Long id);
}
