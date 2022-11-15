package tn.spring.springboot.service;

import tn.spring.springboot.entities.Contrat;


import java.util.List;

public interface IContratService {
    List<Contrat> getAllContrat();
    Contrat addContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContrat (Long id);
    /*Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);*/
}
