package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.repository.ContratRepository;
import tn.spring.springboot.repository.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService{

    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }

   /* @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE){
        Contrat contrat=this.contratRepository.save(ce);
        Etudiant n =this.etudiantRepository.findEtudiantByPrenomE(nomE);
        Etudiant p = this.etudiantRepository.findEtudiantByPrenomE(prenomE);
        String n = nomE;
        String p= prenomE;

    }*/

}
