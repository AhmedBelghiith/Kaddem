package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.service.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {

    IEtudiantService etudiantService;

    @GetMapping("/getalletudiant")
    public List<Etudiant> getAllEtudiant(){
        return etudiantService.getAllEtudiant();
    }

    @PostMapping("/addetudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantService.addEtudiant(e);
    }

    @DeleteMapping("/deleteE/{idEtudiant}")
    private void deleteEtudiant(@PathVariable("idEtudiant") Long idEtudiant){
         etudiantService.deleteEtudiant(idEtudiant);
    }

    @PutMapping("/updateE")
    private Etudiant updateE(@RequestBody Etudiant e){
        return etudiantService.updateEtudiant(e);
    }

    @GetMapping("/getE/{idEtudiant}")
    private Etudiant getEtuById(@PathVariable("idEtudiant") Long idEtudiant){
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @GetMapping("/findetudiantByP/{prenom}")
    public Etudiant findEtudiantByPrenomE(@PathVariable("prenom") String prenom){
        return etudiantService.findEtudiantByPrenomE(prenom);
    }

    @PostMapping("/assignEtudToDepart/{idEtudiant}/{idDepart}")
    public void assignEtudianttoDepartement(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idDepart") Long idDepart){
        etudiantService.assignEtudianttoDepartement(idEtudiant,idDepart);
    }
}
