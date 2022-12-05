package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.DetailEquipe;
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
}
