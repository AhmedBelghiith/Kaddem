package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.service.IEtudiantService;

import java.util.List;
import java.util.Set;

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

    @GetMapping("/findEtudiantByPrenomE/{prenomE}")
    public Etudiant findEtudiantByPrenomE(@PathVariable("prenomE") String prenomE){
        return etudiantService.findEtudiantByPrenomE(prenomE);
    }

    @GetMapping("/findEtudiantByNomE/{nomE}")
    public Etudiant findEtudiantByNomE(@PathVariable("nomE") String nomE){
        return etudiantService.findEtudiantByPrenomE(nomE);
    }

    @PostMapping("/assignEtudToDepart/{idEtudiant}/{idDepart}")
    public void assignEtudianttoDepartement(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idDepart") Long idDepart){
        etudiantService.assignEtudianttoDepartement(idEtudiant,idDepart);
    }

   @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idEquipe}/{idContrat}")
   @ResponseBody
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idEquipe") Long idEquipe,@PathVariable("idContrat") Long idContrat){
        Etudiant etudiant =this.etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idEquipe,idContrat);
        return etudiant;
    }

    @GetMapping("/getEtudiantsByDepartement/{idDepart}")
    public Set<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepart") Long idDepart){
        return  etudiantService.getEtudiantsByDepartement(idDepart);
    }
}
