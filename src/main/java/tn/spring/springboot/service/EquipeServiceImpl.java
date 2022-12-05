package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;
import tn.spring.springboot.repository.ContratRepository;
import tn.spring.springboot.repository.EquipeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {

    EquipeRepository equipeRepository;
    ContratRepository contratRepository;

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe findEquipeByIdEquipe(Long idEquipe) {
        return equipeRepository.findEquipeByIdEquipe(idEquipe);
    }

    @Override
    public List<Equipe> getEquipeByNomEquipe(String nomEquipe) {
        return equipeRepository.findEquipeByNomEquipe(nomEquipe);
    }

    @Override
    public List<Equipe> getEquipeByNiveau(Niveau niveau) {
        return equipeRepository.findEquipeByNiveau(niveau);
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant, Long idDepart) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idetdudiant,idDepart);
    }

   /* @Scheduled(cron = "0 * 13 * * *")
    @Override
    @Transactional
    public void faireEvoluerEquipes() {
        List<Equipe> equipes = equipeRepository.findAll();
        Integer nb_pro_etudiant;
        for (int equipe =0; equipe<equipes.size();equipe++){
            nb_pro_etudiant = 0;
            if (equipes.get(equipe).getNiveau() == Niveau.SENIOR || equipes.get(equipe).getNiveau() == Niveau.JUNIOR ) {
                for (int etudiant = 0; etudiant < equipes.get(equipe).getEtudiants().size(); etudiant++) {
                    for (int contrat = 0; contrat < equipes.get(equipe).getEtudiants().get(etudiant).getContrat().size(); contrat++) {
                        if (contratRepository.GetDaysByIdFromStart(equipes.get(equipe).getEtudiants().get(etudiant).getContrat().get(contrat).getIdContrat()) >= 365) {
                            nb_pro_etudiant++;
                            break;
                        }
                    }
                }
            }
            if (nb_pro_etudiant>=3){
                if (equipes.get(equipe).getNiveau() == Niveau.SENIOR){
                    equipes.get(equipe).setNiveau(Niveau.EXPERT);
                    System.out.println("L'equipe de l'id "+equipes.get(equipe).getIdEquipe()+"\n a passer du niveau SENIOR a EXPERT");
                }else{
                    equipes.get(equipe).setNiveau(Niveau.SENIOR);
                    System.out.println("L'equipe de l'id "+equipes.get(equipe).getIdEquipe()+"\n a passer du niveau JUNIOR a SENIOR");
                }
            }
        }

    } */


}
