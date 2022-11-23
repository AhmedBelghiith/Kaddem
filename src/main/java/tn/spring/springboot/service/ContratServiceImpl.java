package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.repository.ContratRepository;
import tn.spring.springboot.repository.EtudiantRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

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

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        int j = 0;

        List<Contrat> contrat = contratRepository.findAll();

        for (int i = 0; i < contrat.size(); i++) {
            Contrat ct = contrat.get(i);

            if (ct.isArchive() == false) {
                j++;
            }
        }
        return j;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float CA = 0;
        List<Contrat> contrats = contratRepository.getContratByDate(startDate, endDate);
        for (int i=0 ; i<contrats.size() ; i++){
            Contrat ct= contrats.get(i);
            if (ct.getSpecialite().toString()=="IA"){
                int dd = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
                int df = Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));
                CA += ((df-dd)*300);
            } else if (ct.getSpecialite().toString()=="RESEAU") {
                int dd = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
                int df = Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));
                CA += ((df-dd)*350);
            } else if (ct.getSpecialite().toString()=="CLOUD") {
                int dd = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
                int df = Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));
                CA += ((df-dd)*400);
            } else if (ct.getSpecialite().toString()=="SECURITE") {
                int dd = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
                int df = Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));
                CA += ((df-dd)*450);
            } else {
                return CA;
            }
        }
        return CA;
    }

}
