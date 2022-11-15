package tn.spring.springboot.service;

import tn.spring.springboot.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> getAllEtudiant();
    Etudiant addEtudiant(Etudiant e);
    Etudiant updateEtudiant(Etudiant e);
    void deleteEtudiant (Long id);
    Etudiant getEtudiantById(Long id);
    Etudiant findEtudiantByPrenomE(String prenomE);
    Etudiant findEtudiantByNomE(String nomE);
    public void assignEtudianttoDepartement(Long idEtudiant,Long idDepart);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat,Long idEquipe);
}
