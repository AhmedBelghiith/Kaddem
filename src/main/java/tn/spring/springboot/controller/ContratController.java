package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.service.IContratService;

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
}
