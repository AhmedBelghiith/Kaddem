package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;
import tn.spring.springboot.repository.EquipeRepository;
import tn.spring.springboot.service.IEquipeService;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/getNbrEtudiantparEquipe/{idEquipe}")
    public int getNbrEtudiantparEquipe(@PathVariable("idEquipe") Long idEquipe){
        return equipeService.getNbrEtudiantparEquipe(idEquipe);
    }

    @GetMapping("/getMoyenneEquipe/{idEquipe}")
    public float getMoyenneEquipe(@PathVariable("idEquipe") Long idEquipe){
        return equipeService.getMoyenneEquipe(idEquipe);
    }


        @GetMapping("/equipes")
    public ResponseEntity<List<Equipe>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "idEquipe") String sortBy)
    {
        List<Equipe> list = equipeService.getAllEquipes(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Equipe>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Equipe>> searchEquipes(@RequestParam("query") String query){
        return ResponseEntity.ok(equipeService.searchEquipes(query));
    }

    @GetMapping("/getAllAsc")
    public List<Equipe> getAllAsc(){
        return equipeService.getAllAsc();
    }

    @GetMapping("/getAllDesc")
    public List<Equipe> getAllDesc(){
        return equipeService.getAllDesc()   ;
    }

    @PostMapping("/assignEtudianttoEquipe/{idEtudiant}/{idEquipe}")
    public void assignEtudianttoEquipe(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idEquipe") Long idEquipe){
        equipeService.assignEtudianttoEquipe(idEtudiant,idEquipe);
    }




}
