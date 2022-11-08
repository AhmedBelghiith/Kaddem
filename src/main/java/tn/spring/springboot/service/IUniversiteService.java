package tn.spring.springboot.service;

import tn.spring.springboot.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> getAllUniversite();
    Universite adduniversite(Universite u);
    Universite updateuniversite(Universite u);
    void deleteuniversite (Long id);
    void assignUniversityToDepartement(Long idUniv, Long idDepart);
}
