package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;
import tn.spring.springboot.service.IEquipeService;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class EquipeController {

    IEquipeService equipeService;

    @GetMapping("/getAllEquipe")
    public List<Equipe> getAllEquipe(){
        return equipeService.getAllEquipe();
    }

    @GetMapping("/findEquipeByIdEquipe/{idEquipe}")
    public Equipe findEquipeByIdEquipe(@PathVariable("idEquipe") Long idEquipe){
        return equipeService.findEquipeByIdEquipe(idEquipe);
    }
    @GetMapping("/findEquipeByEtudiantsIdEtudiant/{idEtudiant}")
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(@PathVariable("idEtudiant") Long idEtudiant){
        return equipeService.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }
    @GetMapping("/getEquipeByNomEquipe/{nomEquipe}")
    public List<Equipe> getEquipeByNomEquipe(@PathVariable("nomEquipe") String nomEquipe){
        return equipeService.getEquipeByNomEquipe(nomEquipe);
    }
    @GetMapping("/getEquipeByNiveau/{niveau}")
    public List<Equipe> getEquipeByNiveau(@PathVariable("niveau") Niveau niveau){
        return equipeService.getEquipeByNiveau(niveau);
    }

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe e) {
        return equipeService.addEquipe(e);
    }

    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e){
        return equipeService.updateEquipe(e);
    }

    @DeleteMapping("/deleteEquipe/{idEquipe}")
    public void deleteEquipe(@PathVariable("idEquipe") Long idEquipe){
        equipeService.deleteEquipe(idEquipe);
    }

    @GetMapping("/findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart/{idEtudiant}/{idDepart}")
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(@PathVariable("idEtudiant") Long idEtdudiant,@PathVariable("idDepart") Long idDepart){
        return equipeService.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtdudiant,idDepart);
    }

}
