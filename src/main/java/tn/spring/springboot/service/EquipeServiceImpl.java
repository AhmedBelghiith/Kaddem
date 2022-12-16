package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Niveau;
import tn.spring.springboot.repository.ContratRepository;
import tn.spring.springboot.repository.EquipeRepository;
import tn.spring.springboot.repository.EtudiantRepository;

import javax.transaction.Transactional;


@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {

    EquipeRepository equipeRepository;
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

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

    @Override
    public int getNbrEtudiantparEquipe(Long idEquipe) {
        List<Etudiant> etudiants = this.etudiantRepository.findByEquipes_IdEquipe(idEquipe);
        int nb = etudiants.size();
        return nb;
    }
    @Override
    public float getMoyenneEquipe(Long idEquipe){
        float notes = 0;
        List<Etudiant> etudiants = this.etudiantRepository.findByEquipes_IdEquipe(idEquipe);
        int nb = etudiants.size();
        for (int i=0;i<nb;i++){
            Etudiant etudiant=etudiants.get(i);
            notes += etudiant.getNote();
        }
        float moy= notes/nb;
        return moy;
    }

    @Override
    public List<Equipe> getAllEquipes(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Equipe> pagedResult = equipeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Equipe>();
        }
    }

    @Override
    public List<Equipe> getAllAsc() {
        List<Equipe> equipes =equipeRepository.findAllAsc(Sort.by(Sort.Direction.ASC, "nomEquipe"));
        return equipes;
    }
    @Override
    public List<Equipe> getAllDesc() {
        List<Equipe> equipes =equipeRepository.findAllDesc(Sort.by(Sort.Direction.DESC, "nomEquipe"));
        return equipes;
    }



    @Override
    public List<Equipe> searchEquipes(String query) {
        List<Equipe> equipes = equipeRepository.searchEquipes(query);
        return equipes;
    }

    @Transactional
    @Override
    public void assignEtudianttoEquipe(Long idEtudiant, Long idEquipe) {
        Etudiant etudiant= this.etudiantRepository.findById(idEtudiant).orElse(null);
        Equipe equipe= this.equipeRepository.findById(idEquipe).orElse(null);
        equipe.getEtudiants().add(etudiant);
        etudiant.getEquipes().add(equipe);

        etudiantRepository.save(etudiant);
        equipeRepository.save(equipe);
    }


}
