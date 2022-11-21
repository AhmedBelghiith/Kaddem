package tn.spring.springboot.service;

import tn.spring.springboot.entities.Contrat;


import java.util.Date;
import java.util.List;

public interface IContratService {
    List<Contrat> getAllContrat();
    Contrat addContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContrat (Long id);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    public Integer nbContratsValides(Date startDate, Date endDate);


}
