package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.service.IDetailEqService;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class DetailEqController {

    IDetailEqService detailEqService;

    @GetMapping("/getAllDetailEquipe")
    public List<DetailEquipe> getAllDetailEquipe(){
        return detailEqService.getAllDetailEquipe();
    }

    @GetMapping("/getDetailEquipeById/{idDetailEquipe}")
    public DetailEquipe getDetailEquipeById(@PathVariable("idDetailEquipe") Long idDetailEquipe){
        return detailEqService.getDetailEquipeById(idDetailEquipe);
    }

    @PostMapping("/addDetailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe){
        return detailEqService.addDetailEquipe(detailEquipe);
    }

    @PutMapping("/updateDetailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return detailEqService.updateDetailEquipe(detailEquipe);
    }

    @DeleteMapping("deleteDetailEquipe/{idDetailEquipe}")
    public void deleteDetailEquipe(@PathVariable("idDetailEquipe") Long idDetailEquipe){
        detailEqService.deleteDetailEquipe(idDetailEquipe);
    }

    @GetMapping("/findByThematiqueLike/{thematique}")
    public List<DetailEquipe> findByThematiqueLike(@PathVariable("thematique") String thematique){
        return detailEqService.findByThematiqueLike(thematique);
    }

    @GetMapping("/findbysalle/{salle}")
    public List<DetailEquipe> findBySalleLike(@PathVariable("salle") String salle){
        return detailEqService.findBySalleLike(salle);
    }


    @GetMapping("/detailequipes")
    public ResponseEntity<List<DetailEquipe>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "idDetailEquipe") String sortBy)
    {
        List<DetailEquipe> list = detailEqService.getAllDEquipes(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<DetailEquipe>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/searchDeq")
    public ResponseEntity<List<DetailEquipe>> searchDetailEquipes(@RequestParam("query") String query){
        return ResponseEntity.ok(detailEqService.searchDetailEquipes(query));
    }

    @GetMapping("/findByIdEquipe/{idEquipe}")
    public DetailEquipe findByIdEquipe(@PathVariable("idEquipe") Long idEquipe){
        return detailEqService.findDetailEquipeByEquipe(idEquipe);
    }

    @GetMapping("/getAllAscDeq")
    public List<DetailEquipe> getAllAsc(){
        return detailEqService.getAllAsc();
    }

    @GetMapping("/getAllDescDeq")
    public List<DetailEquipe> getAllDesc(){
        return detailEqService.getAllDesc()   ;
    }

    @PostMapping("/addAndAssignDetailEquipeToEquipe/{idEquipe}")
    @ResponseBody
    public DetailEquipe addAndAssignDetailEquipeToEquipe(@RequestBody DetailEquipe e, @PathVariable("idEquipe") Long idEquipe){
        DetailEquipe detailEquipe =this.detailEqService.addAndAssignDetailEquipeToEquipe(e,idEquipe);
        return detailEquipe;
    }
}
