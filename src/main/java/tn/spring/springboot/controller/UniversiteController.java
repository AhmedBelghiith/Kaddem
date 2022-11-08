package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Universite;
import tn.spring.springboot.service.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {

    IUniversiteService universiteService;

    @GetMapping("/getalluniv")
    public List<Universite> getAllUniversite(){
        return universiteService.getAllUniversite();
    }

    @PostMapping("/addUniv")
    public Universite adduniversite(@RequestBody Universite u){
        return universiteService.adduniversite(u);
    }

    @PutMapping("/updateUniv")
    public Universite updateuniversite(@RequestBody Universite u){
        return universiteService.updateuniversite(u);
    }

    @DeleteMapping("/deleteUniv/{id}")
    public void deleteuniversite(@PathVariable("id") Long id){
        universiteService.deleteuniversite(id);
    }

    @PostMapping("assignUniversityToDepartement/{idUniv}/{idDepart}")
    public void assignUniversityToDepartement(@PathVariable("idUniv") Long idUniv,@PathVariable("idDepart") Long idDepart){
        universiteService.assignUniversityToDepartement(idUniv,idDepart);
    }
}
