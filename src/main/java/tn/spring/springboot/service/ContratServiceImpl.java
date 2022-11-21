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

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        int j=0 ;

        List<Contrat> contrat= contratRepository.findAll();

        for(int i=0;i<contrat.size();i++){
            Contrat ct=contrat.get(i);

            if(ct.isArchive()==false){
                j++;
            }
        }
        return j;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float CA=0;
        int nbOfMonths=1;

        List< Contrat> contrat= contratRepository.findAll();
        for(int i=0;i<contrat.size();i++){
            Contrat ct=contrat.get(i);
            int dd=Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
            int df=Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));

            if((nbOfMonths*=(df-dd))==0){
                nbOfMonths=1;
            }else{
                nbOfMonths=(df-dd);
            }
            if(ct.isArchive()==false){

                System.out.println("*******"+nbOfMonths);

                if(ct.getSpecialite().toString()=="IA"){
                    CA+=nbOfMonths*300;

                }
                else if(ct.getSpecialite().toString()=="RESEAUX"){
                    CA+=nbOfMonths*350;
                }
                else if(ct.getSpecialite().toString()=="CLOUD"){
                    CA+=nbOfMonths*400;
                }
                else if(ct.getSpecialite().toString()=="SECURITE"){
                    CA+=nbOfMonths*450;
                }

            }

        }
        return CA;
    }
}
