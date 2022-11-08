package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.repository.DepartementRepository;
import tn.spring.springboot.repository.EtudiantRepository;

import java.util.List;

@Service //cree une instance de ce service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
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
    public Etudiant findEtudiantByPrenomE(String prenom) {
        return etudiantRepository.findEtudiantByPrenomE(prenom);
    }

    @Override
    public void assignEtudianttoDepartement(Long idEtudiant, Long idDepart) {
        Etudiant etudiant= this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement= this.departementRepository.findById(idDepart).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }
}
