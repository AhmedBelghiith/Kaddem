package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.service.IContratService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class ContratController {

    IContratService contratService;

    @GetMapping("/getallcontrat")
    public List<Contrat> getAllContrat(){
        return contratService.getAllContrat();
    }

    @PostMapping("/addcontrat")
    public Contrat addContrat(@RequestBody Contrat contrat){
        return contratService.addContrat(contrat);
    }

    @PutMapping("/updatecontrat")
    public Contrat updateContrat(@RequestBody Contrat contrat){
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("deleteContrat/{id}")
    public void deleteContrat(@PathVariable("id") Long id){
        contratService.deleteContrat(id);
    }
    @GetMapping("/nbContratsValides/{DateDebutContrat}/{DateFinContrat}")
    public Integer nbContratsValides(@PathVariable("DateDebutContrat") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateDebutContrat, @PathVariable("DateFinContrat")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date DateFinContrat){

        return  contratService.nbContratsValides(DateDebutContrat,DateFinContrat);
    }
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{DateDebutContrat}/{DateFinContrat}")
    public Float getChiffreAffaireEntreDeuxDate(@PathVariable("DateDebutContrat")
                                                    @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)Date dateD,
                                                @PathVariable("DateFinContrat")
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date dateF){

        return  contratService.getChiffreAffaireEntreDeuxDate(dateD,dateF);
    }
}
