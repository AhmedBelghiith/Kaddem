package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.repository.ContratRepository;
import tn.spring.springboot.repository.DepartementRepository;
import tn.spring.springboot.repository.EquipeRepository;
import tn.spring.springboot.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service //cree une instance de ce service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;
    @Override
    public List<Etudiant> getAllEtudiant() {

        return etudiantRepository.findAll() ;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(Long id) {

        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {

        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant findEtudiantByPrenomE(String prenomE) {
        return etudiantRepository.findEtudiantByPrenomE(prenomE);
    }

    @Override
    public Etudiant findEtudiantByNomE(String nomE) {
        return etudiantRepository.findEtudiantByPrenomE(nomE);
    }
    @Override
    public void assignEtudianttoDepartement(Long idEtudiant, Long idDepart) {
        Etudiant etudiant= this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement= this.departementRepository.findById(idDepart).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }


    // on va toucher plusieur tables (table --> entity managed) (.add(e) si exist add to equipe sinon add to etudiant then equipe
    @Transactional
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat,Long idEquipe){
       /* Etudiant etudiant= this.etudiantRepository.save(e);*/
        Equipe equipe=this.equipeRepository.findById(idEquipe).orElse(null);
        Contrat contrat=this.contratRepository.findById(idContrat).orElse(null);
        /*etudiant.setEquipes((Set<Equipe>) equipe);
        etudiant.setContrats((Set<Contrat>) contrat);*/
        contrat.setEtudiant(e);
        equipe.getEtudiants().add(e);
        return e;
    }
    @Override
    public Set<Etudiant> getEtudiantsByDepartement(Long idDepartement) {
        Departement departement=departementRepository.findById(idDepartement).orElse(null);
        Set<Etudiant> etudiants = departement.getEtudiants();
        return etudiants;
    }
}
